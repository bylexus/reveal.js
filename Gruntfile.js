/* global module:false */
module.exports = function(grunt) {
	var port = grunt.option('port') || 8000;
	var root = grunt.option('root') || '.';
    var path = require('path');
    var nunjucks = require('nunjucks');

    nunjucks.configure('.', {
        noCache: true
    });
	if (!Array.isArray(root)) root = [root];

	// Project configuration
	grunt.initConfig({
		pkg: grunt.file.readJSON('package.json'),
		meta: {
			banner:
				'/*!\n' +
				' * reveal.js <%= pkg.version %> (<%= grunt.template.today("yyyy-mm-dd, HH:MM") %>)\n' +
				' * http://revealjs.com\n' +
				' * MIT licensed\n' +
				' *\n' +
				' * Copyright (C) 2017 Hakim El Hattab, http://hakim.se\n' +
				' */'
		},

		uglify: {
			options: {
				banner: '<%= meta.banner %>\n',
				screwIE8: false
			},
			build: {
				src: 'js/reveal.js',
				dest: 'js/reveal.min.js'
			}
		},

		sass: {
			core: {
				src: 'css/reveal.scss',
				dest: 'css/reveal.css'
			},
			themes: {
				expand: true,
				cwd: 'css/theme/source',
				src: ['*.sass', '*.scss'],
				dest: 'css/theme',
				ext: '.css'
			}
		},

		autoprefixer: {
			core: {
				src: 'css/reveal.css'
			}
		},

		cssmin: {
			options: {
				compatibility: 'ie9'
			},
			compress: {
				src: 'css/reveal.css',
				dest: 'css/reveal.min.css'
			}
		},


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

                          if (pathname.match(/\/$/)) {
                              pathname += 'index.html';
                          }
                          if (pathname.match(/\.html$/)) {
                              res.end(nunjucks.render(path.join('.',pathname), {
                                  project: grunt.config.get('pkg.project')
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
			js: {
				files: [ 'Gruntfile.js', 'js/reveal.js' ],
				tasks: 'js'
			},
			theme: {
				files: [
					'css/theme/source/*.sass',
					'css/theme/source/*.scss',
					'css/theme/template/*.sass',
					'css/theme/template/*.scss'
				],
				tasks: 'css-themes'
			},
			css: {
				files: [ 'css/reveal.scss' ],
				tasks: 'css-core'
			},
			html: {
				files: root.map(path => path + '/*.html')
			},
			markdown: {
				files: root.map(path => path + '/*.md')
			},
			options: {
				livereload: true
			}
		},

		retire: {
			js: [ 'js/reveal.js', 'lib/js/*.js', 'plugin/**/*.js' ],
			node: [ '.' ]
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
                        '!node_modules/**',
                        '!test/**',
                        '!CONTRIBUTING.md',
                        '!Gruntfile.js',
                        '!LICENSE',
                        '!README.md',
                        '!bower.json',
                        '!package*.json'
                    ],
                    dest: 'build/'
                }]
            }
        },

        clean: {
            build: ['build/']
        },

        'nunjucks-render': {
            options: {},
            build: {
                files: [{
                src: [
                    '**/*.html',
                    '!node_modules/**',
                    '!test/**',
                    '!plugin/**',
                    '!**/_*.html'
                ],
                expand: true,
                dest: 'build/'
                }]
            }
        },

        'pdf': {
            build: {
                html: ['build/**/*.html'],
                options: {}
            }
        }

	});

	// Dependencies
	grunt.loadNpmTasks( 'grunt-contrib-connect' );
	grunt.loadNpmTasks( 'grunt-contrib-cssmin' );
	grunt.loadNpmTasks( 'grunt-contrib-copy' );
	grunt.loadNpmTasks( 'grunt-contrib-clean' );
	grunt.loadNpmTasks( 'grunt-contrib-uglify' );
	grunt.loadNpmTasks( 'grunt-contrib-watch' );
	grunt.loadNpmTasks( 'grunt-autoprefixer' );
	grunt.loadNpmTasks( 'grunt-retire' );
	grunt.loadNpmTasks( 'grunt-sass' );
	grunt.loadNpmTasks( 'grunt-zip' );

    grunt.registerMultiTask('nunjucks-render', 'generates html files from nunjucks templates', function(){
        this.files.forEach(function(f) {
              // Concat specified files.
              var processedContent = f.src.map(function(filepath) {
                // Read file source.
                var content = nunjucks.render(path.join('.',filepath), {
                  project: grunt.config.get('pkg.project')
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
	grunt.registerTask( 'default', [ 'css', 'js' ] );

	// JS task
	grunt.registerTask( 'js', [ 'uglify' ] );

	// Theme CSS
	grunt.registerTask( 'css-themes', [ 'sass:themes' ] );

	// Core framework CSS
	grunt.registerTask( 'css-core', [ 'sass:core', 'autoprefixer', 'cssmin' ] );

	// All CSS
	grunt.registerTask( 'css', [ 'sass', 'autoprefixer', 'cssmin' ] );

	// Package presentation to archive
	grunt.registerTask( 'package', [ 'default', 'zip' ] );

	// Serve presentation locally
	grunt.registerTask( 'serve', [ 'connect', 'watch' ] );

	// Run build task: exports everything as standalone html to build/
	grunt.registerTask( 'build', [ 'css', 'js', 'clean:build', 'nunjucks-render:build', 'copy:build' ] );

};
