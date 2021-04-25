04/11.11.2020 - Kurzvorträge Web-Bedrohungen
================

SQL - Injection: Janshon
----------------------------
start 08:29
- agenda vorhanden

grafik zu sql injection: nicht ganz klar, was gemeint ist: ein web-formular wäre gut gewesen.
Erklärung dazu recht unklar: ein formular mit bild wäre hier gut gewesn.
nervös, viele ähms, abgebrochene Sätze
code-beispiele: das fertige sql hätte noch aufgezeigt werden können
prepared statement nicht ganz korrekt erklärt: das db-system liefert keinen fehler, sondern es sorgt dafür
dass eben der ganze String suaber escapet wird.
Hilfsmittel: Browser: viel zu klein. Zoomen, und auch viel zu schnell hin- und hergeklickt.



ende: 08:36 --> 7 min
demo: 08:36 - 08:39 --> 3 min

--> zeit nicht eingehalten

Handout:

"SQL Injection ist eine Sicherheitslücke im Web" --> nicht ganz korrekt: Dies gilt nicht nur für das Web!
Bedrohungsszenario:
- genaue Code-Stelle erläutern, wo das Problem liegt. Hier sieht man ca. 10 Zeilen Code, aber wo passiert nun der Angriff?
- ein Beispiel eines falsch zusammengesetzten SQLs wäre hier sehr hilfreich gewesen

Ebens Erklärung Schutzmassmahme: WO genau passiert nun das Prepared Statement? Und was für ein sql resultiert
am Schluss daraus? --> zu wenig genau, es ist nicht klar, wie das genau funktioniert.


Cross Site Scripting (XSS): Kanakis
----------------------------------------

Start: 08:28
Ende:  08:36 (8min)
Demo: 08:36-08:43 (7min) --> ok

Vortrag:

- Agenda
- Angriffsszenario:
  - Erklärung 2 Szenarien, ok
    So ist die Erklärung zwar stimmig, aber man kann sich nicht so recht etwas darunter vorstellen
    - Was ist denn ein "Script"? --> Hinweis auf JavaScript wäre hier notewndig gewesen
  - verschiedene Arten aufgezeigt, zeigt 2 davon
  - Stored XSS: gut erklärt, mit Grafik
  - Reflected XSS: Wie bringt man den User dazu, dieses Script einzugeben? --> mittels Link, Phising
- Schutzmassnahmen:
  - Phising erwähnt
  - Eingaben von User-Filtern, Sanitizing: Hier wäre ein Beispiel zwingend gewesen! das reicht nicht.

Sicheres Auftreten, gut


Demo:

- Vorbereitung: gut
- welche Attacke wird hier demonstriert?
- Hinweis auf Script in URL wäre gut gewesen --> das ist die Essenz des Angriffs, wurd nicht erklärt.
- Sie zeigen Code, den Sie nicht genau verstehen (file_put_contents) --> schlecht

Hilfsmittel: gut, auch zoom

Schutzmassnahme: in Demo-Code gezeigt (htmlspecialchars)


Handout:

Schutzmassnahme: ungenügend. Hier muss eine konkrete Massnahme erläutert werden, nicht einfach "Data sanitizing, finden Sie via Google".
Code-Beispiele, Schutzmassnahme: nicht erklärt: Es ist nicht ersichtlich, wie denn nun konkret eine
Schutzmassnahme umgesetzt wird. Es gibt z.B. auch php-eigene Funktionen, die man aufführen könnte.
Ungenügene.
Bilder: die Bilder sind ohne Erklärung einfach "hingeklatscht". was soll uns z.B. das Bild der Webseite am Schluss sagen?



Session Hijacking: Köppel
-----------------------------

start: 08:42
Agenda vorhanden
Themen: wie erhält man eine Session? gut, trägt als Hintergrundinfo zum Verständnis bei

verständliche Sprache, gute Erklärungen
 ende 08:48 ( 6 min )

 demo 08:48

 demo: hilfsmittel: zu schnell hin/her geklickt, nicht alle seine tätigkeiten erklärt. schwierig, zu folgen.
 code: schwer lesbar, da zu klein.

 08: 52 (4 min)

 Handout:
 Fehlerfrei, Übersichtlichkeit: 2x recht unglückliche Seitenumbrüche (Header mit 1 Zeile auf einer Seite, letzte Seite mit wenigen Zeilen). Achten Sie auf saubere Darstellung. Auch der Textblock zum Erlangen der Session-Informationen ist sehr rudimentär / zusammengepresst, schwer verständlich.
 Auch Satzstellungsfehler vorhanden ("Aber heutzutage gibt es kostenlose SSL Zertifizierungsstelle, wie Let’s Encrypt.")




Directory Traversal Attack: Degan
--------------------------------------

start: 08:53

Agenda, gnz kurzes Szenario als Einstieg
Bedrohung: warum ist dies genau ein problem? --> fehlerhafter Code in Backend schuld, ein Beispiel wäre notwendig gewesen
auch schutzvorkehrungen: nur kurz im TExt erklärt. das ist sehr minimal, und nicht gut verständlich.

ende : 08:59 (6min)
demo 08:59 (2 min)


Handout: 

Bedrohungsszenario: wie auch im Vortrag fehlt hier die genaue Erklärung, wie das nun auf der Server-Seite passiert: Es wird nicht klar, warum denn der Server nun aufgrund des eingegebenen Pfades diese Datei aufrufen soll --> ein kurzes Code-Snippet hätte hier mehr als 1000 Worte gesagt.
Ebenso Schutzmassnahme: Sehr minimal. Hier hätten ein paar Verweise und vor allem auch Code-Snippets hin müssen.
Es ist dem Leser jetzt absolut nicht klar, wie genau dies zu verhindern ist



Cross Site Request Forgery (CSRF):Häuptli
-----------------------------------------------

Start: 08:49
Ende:  09:05 -->16min, gut
Demo:  09:05-09:10 (5min)

Vortrag:

- Agenda
- sicheres Auftreten, gute Sprache
- kurze Einleitung, gut, Bedingungen für den Angriff aufgezeigt
- Bedrohungsszenario:
  - Ablauf gut mit Bild + Wort erklärt
  - ein eindrückliches Beispiel wäre hier notwendig gewesen, z.B. Link mit "/send/money" oder so,
    so war wenig klar, was denn nun genau missbraucht wird.
- Schutzmassnahmen:
  - Erklärungen in Wort - Hinweis auf OWASP-Empfehlungen, gut
  - gute Erklärung der möglichen Schutzmassnahmen. Super!
-> sehr guter Vortrag.


Demo:

- Einstieg mit schwer verständlichem Code
- code sehr dunkel und klein --> schlecht/nicht lesbar
- gut vorbereitet
- zeig Angriff: ok, etwas undurchsichtig. hier wäre bessere Erklärung notewndig gewesen.
- zeigt Schutz: wie oben, code nicht gross erklärt




Brute Force Attacks: Stauffiger
-------------------------------------

Start: 09:12
Ende:  09:18 (6min)
Demo:  09:18 - 09:23 (5min)
--> zu kurz

Vortrag:

- keine Agenda
- abgelesen, wirkt etwas hölzern
- Grundlagen, kurze Einleitung
- Arten von Brute force aufgezeigt und erklärt, gut

- Angriffsszenario:
   nicht aufgezeigt in vortrag?
- Schutzmassnahmen:
  mehrere Massnahmen kurz erklärt

Demo:
- gut vorbereitet
- demo mit hydra
- code / shell zu klein / zu dunkel, man sieht nichts
- demo lief nicht durch - was war das Problem?
- Schutzmassnahme: keine gezeigt. hier wäre ein php-code-beispiel (z.B. timeout) notwendig gewesen


(Distributed) Denial Of Service, (D)DOS: Tüscher
------------------------------------------------------

Start:  09:24 - 09:29 (5min)
Ende:  
Demo:  09:29-09:32 (3min)

Vortrag:

- keine Agenda
- Begriffserklärung
- Angriffsszenario:
    - gute Analogie mit Auto / Verkehr aufgezeigt
    - Gut aufgezeigt mit bildlicher Darstellung
  
- Schutzmassnahme:
  - mehrere Massnahmen aufgezeigt, gut

Demo:
- gut erklärt, was läuft / was er macht
- Angriffsszenario: 
  - flood mit low orbit ion cannon, zeigt ping auf schüler-Rechner auf
  - eindrücklich: nur mit 1 rechner kann man bereits ddos durchführen
- schutzmechanismus: konnte in demo nicht aufgezeigt werden --> hier wäre mehr möglich gewesen
(bsp linux-vm mit firewall)

