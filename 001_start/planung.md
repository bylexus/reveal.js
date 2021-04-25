Detailplan Lektion 1 - 18.08.2021
===========================================

Infrastruktur
---------------

* Jeder Schüler hat Docker lokal installiert
* Github Classroom Repo für jeden Schüler, mit Template aus https://github.com/bylexus/m151-template.git, beinhaltet:
  * Docker-Infrastruktur, Start mit: `docker-compose up -d`, beinhaltet:
    * `m151-web`: http://localhost:8020/webroot/
    * `plantuml`: http://localhost:10001/
    * `m151-db`: MySQL-Server, Port 3306, user: `m151`, pw: `m151`
    * `m151-docsify`: http://localhost:10000/


Material
--------

* Jahresplan (Moodle)
* Projekt-Beschrieb (Moodle)
* Github Classroom-Repos parat
* Projekt-Skelett (Code, Repo)
* Infos zum Setup auf Moodle:
  * MySQL Workbench: https://www.mysql.com/products/workbench/
  * VS Code: https://code.visualstudio.com/ mit PHP Extension Pack
  * composer (Teil vom Skelett)
  * git: SourceTree (https://www.sourcetreeapp.com/)
  * Github classroom invitation: https://classroom.github.com/a/4vyMjw_f

Ziele
-----

* Jahresplan: Sie kennen die wichtigsten Daten des Jahres
* Sie kennen die Aufgabenstellung der Projektarbeit
* Sie haben eine lauffähige Entwicklungsumgebung, und das Projekt-Skelett funktioniert

Detailplan
----------

Achtung: COVID-19-Folien erst bringen!

08:20 ( 5min )      Begrüssung, Beschreibung des Moduls 151, Ziel
08:25 ( ca. 5min )  Jahresplan, Hinweise auf Kurzreferate und Abgabetermine, Moodle
08:30 (rest)        Setup Entwicklungsumgebung mit Docker
  * Clone des Classroom-Repos
  * Bauen / Starten der Docker-Container
  * Test der Infrastruktur:
    * Docsify
    * Web-Skelett
  * Erklärung composer, autoloading
    * Beispiel mit Test-Klasse aufzeigen
    * Namespacing, Klassen
09:55 Ende

Ziel
----

- Alle Schüler haben das Skeleton-Projekt von Git Classroom geklont
- Alle Schüler haben eine lauffähige Entwicklungsumgebung via Docker
- Alle Schüler konnten das Skeleton-Projekt mit Docker in Betrieb nehmen
