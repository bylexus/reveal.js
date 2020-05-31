/* global module:false */
module.exports = function(grunt) {
	var port = grunt.option('port') || 8000;
	var root = grunt.option('root') || '.';
    var path = require('path');
    var dayjs = require('dayjs');
    var nunjucks = require('nunjucks');

    var today = dayjs().format('YYYY-MM-DD');
    var builddir = 'm151-build-' + today;

    nunjucks.configure('.', {
        noCache: true
    });
	if (!Array.isArray(root)) root = [root];

	// Project configuration
	grunt.initConfig({
		pkg: grunt.file.readJSON('package.json'),

		connect: {
			server: {
				options: {
					port: port,
					base: root,
					livereload: true,
					open: true,
					useAvailablePort: true,
                    middleware: function(connect, options, middlewares) {
                      // add Nunjucks template parser for all .html or /-Files
                      middlewares.unshift(function(req, res, next) {
                          var parts = require('url').parse(req.url);
                          var pathname = parts.pathname;
                          var webrootRel =path.relative(pathname,'/') || '.';

                          if (pathname.match(/\/$/)) {
                              pathname += 'index.html';
                          }
                          if (pathname.match(/\.html$/)) {
                              res.end(nunjucks.render(path.join('.',pathname), {
                                  project: grunt.config.get('pkg.project'),
                                  webroot: webrootRel
                              }));
                          } else {
                              return next();
                          }
                      });
                      return middlewares;
                    },
                }
            }
        },

		zip: {
			bundle: {
				src: [
					'index.html',
					'css/**',
					'js/**',
					'lib/**',
					'images/**',
					'plugin/**',
					'**.md'
				],
				dest: 'reveal-js-presentation.zip'
			}
		},

		watch: {
			css: {
				files: root.map(path => path + '/**/*.css')
			},
			html: {
				files: root.map(path => path + '/**/*.html')
			},
			markdown: {
				files: root.map(path => path + '/**/*.md')
			},
			options: {
				livereload: true
			}
		},

        copy: {
            build: {
                files: [{
                    expand: true,
                    src: [
                        '**/*',
                        '!**/*.html',
                        '!**/*.scss',
                        '!css/theme/source/**',
                        '!node_modules*/**',
                        '!test/**',
                        '!m151-build*/**',
                        '!CONTRIBUTING.md',
                        '!Gruntfile.js',
                        '!LICENSE',
                        '!README.md',
                        '!bower.json',
                        '!package*.json'
                    ],
                    dest: builddir + '/'
                }]
            }
        },

        clean: {
            build: ['m151-build-*/']
        },

        'nunjucks-render': {
            options: {},
            build: {
                files: [{
                src: [
                    '**/*.html',
                    '!node_modules*/**',
                    '!demo.html',
                    '!test/**',
                    '!plugin/**',
                    '!**/_*.html'
                ],
                expand: true,
                dest: builddir + '/'
                }]
            }
        }
	});

	// Dependencies
	grunt.loadNpmTasks( 'grunt-contrib-connect' );
	grunt.loadNpmTasks( 'grunt-contrib-copy' );
	grunt.loadNpmTasks( 'grunt-contrib-clean' );
	grunt.loadNpmTasks( 'grunt-contrib-watch' );
	grunt.loadNpmTasks( 'grunt-zip' );

    grunt.registerMultiTask('nunjucks-render', 'generates html files from nunjucks templates', function(){
        this.files.forEach(function(f) {
              // Concat specified files.
              var processedContent = f.src.map(function(filepath) {
                // Read file source.
                var webrootRel =path.relative(path.dirname(filepath),'./') || '.';
                var content = nunjucks.render(path.join('.',filepath), {
                  project: grunt.config.get('pkg.project'),
                  webroot: webrootRel
                });
                return content;
              }).join('\n');
            grunt.log.ok(f.dest);
            grunt.file.write(f.dest, processedContent);
        });
    });

    // Generates PDFs from HTML files. Meant to be run after the 'build' job.
    grunt.registerMultiTask('pdf',' Generates PDFs from the built HTML', function() {
        const puppeteer = require('puppeteer');
        const path = require('path');
        const done = this.async();

        puppeteer.launch()
            .then(browser => browser.newPage())
            .then(page => {
                let files = grunt.file.expand(this.data.html);
                let p = Promise.resolve();
                // sync promise execution pattern: Execute all PDF execution promises
                // after the first one is done.
                files.forEach(function(f) {
                    let fInfo = path.parse(f);
                    let input = path.join(__dirname,f);
                    let pdf = path.join(fInfo.dir,fInfo.name+'.pdf');

                    p = p.then(function(){
                        grunt.log.ok('Generating '+pdf);
                        return page.goto('file://'+input+'?print-pdf', {waitUntil: 'networkidle2'})
                            .then(() => page.pdf({path: pdf}, this.data.options || {}));
                    }.bind(this));

                }.bind(this));
                return p;
            })
            .then(done)
            .catch(e => {
                grunt.log.fail(e);
                done();
            });
    });

	// Default task
	grunt.registerTask( 'default', [ 'serve' ] );

	// Package presentation to archive
	grunt.registerTask( 'package', [ 'default', 'zip' ] );

	// Serve presentation locally
	grunt.registerTask( 'serve', [ 'connect', 'watch' ] );

	// Run build task: exports everything as standalone html to build/
	grunt.registerTask( 'build', [ 'clean:build', 'nunjucks-render:build', 'copy:build' ] );

};
