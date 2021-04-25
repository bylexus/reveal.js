Hinweise für die Abgabe Projektarbeit M151
===========================================

**Spätester Zeitpunkt für die Abgabe (GIT-Commit): 19.12.2020, 00:00**

An diesem Zeitpunkt geben Sie ab (alles in Ihrem git Repository):

    den gesamten Code inkl. Config und DB (siehe unten)
    die gesamte Doku, ohne Vortrag, in Docsify

## Export

**WICHTIG!** Ich erwarte, dass die Abgabe Out-of-the-Box funktioniert: Committen sie daher ALLES
in Ihr Repository, auch Konfigurationsdateien und vor allem einen DB-Dump.

1. **DB-Dump erstellen:**

Einen DB-Dump Ihrer DB inklusive MySQL-User-Tabellen (ersetzen Sie allenfalls die Usernamen, Datenbanknamen und Passwort) können Sie folgendermassen erstellen (Shell-Kommando):

```sh
docker exec -i m151-db mysqldump -u root -proot --databases m151 mysql > dbdump.sql
```

Benennen Sie das File `dbdump.sql`.

2. git commit/push alles, inkl. Config + DB-Dumps

**Das composer-vendor-Verzeichnis und das npm node_modules-Verzeichnis müssen Sie NICHT committen.**
Das installiere ich nach dem Klon Ihres Repos.


## Import

Ich werde folgendes ausführen, um Ihr Projekt zu starten:

1. `git clone [repo-URL] && cd repo-pfad`
2. `docker-compose up`
3. `docker exec -i m151-db sh -c 'mysql -u root -proot -h 127.0.0.1' < dbdump.sql`
4. `docker exec -ti m151-web composer install`

Danach sollte das Projekt (Frontend, Backend Web, DB, Docsify) laufen. Ich investiere nicht viel Zeit für
die Fehlersuche.


