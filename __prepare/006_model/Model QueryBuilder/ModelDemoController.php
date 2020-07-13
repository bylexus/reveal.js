<?php
namespace M151\Controller;

use M151\Http\Request;
use M151\Application;
use M151\Model\BenutzerQB;



class ModelDemoController extends Controller {
    public function index(Request $req) {
        header('Content-Type: text/plain');

        // Hier holen wir die PHP PDO-Connection: Application im Beispiel ist eine Singleton-Klasse,
        // welche die Connection einmal erstellt und dann zurückliefert: Bei mehrfachem Aufruf
        // wird somit immer dieselbe PDO-Instanz ausgeliefert:
        $conn = Application::getInstance()->dbConn();

        // Erstelle QueryBuilder, Übergabe der DB-Connection:
        $qb = new BenutzerQB($conn);


        // ----- Einzelner Datensatz: ------
        echo "Hole einzelnen Datensatz by ID (1):\n";
        $res = $qb->get(1);
        var_dump($res);

        // ----- Mehrere Datensätze: ------
        echo "\n\n\nHole mehrere Datensatz by SQL-Filter:\n";
        $res = $qb->query("name = 'Beutlin'",'name,vorname');
        var_dump($res);

    }
}
