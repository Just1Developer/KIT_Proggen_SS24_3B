# Programmieren Aufgabe 3B - SS24

### Die Aufgaben darf ich im Rahmen der KIT Nutzungsrichtlinien nicht veröffentlichen. Das schließt genaues Dokumentieren der gesamten Aufgabenstellung mit ein. Ein vollständiges Verständnis dieses Repositories ist unter Umständen nur mit dem Arbeitsblatt möglich.

Die Anzahl von Droiden sind so, dass sie nur von Planeten ausgehen müssen, die sonst nicht erreicht werden.
Unter den gegebenen Bedingungen sind das genau alle Planeten mit Eingangsgrad 0.

Wir gehen also davon aus, dass alle Planeten am Anfang Startpunkte sind. Wir nutzen einen Ansatz, der einen Mix aus Vorteilen von
Listen bzw. Arrays darstellt. Wir verfolgen die Listengröße, da nur diese Relevant ist, und nutzen für das Markieren einen Array.
Somit sparen wir uns teure 'remove' calls für Planeten für n*m Kanten, wovon viele ins Leere gehen würden.<br/>
Für jeden Planeten schauen wir für jede Hyperroute nach, ob zum Ziel (target) bisher noch keine Hyperroute geht. Dies ist durch einen
O(1) lookup im Array möglich. Falls das der Fall ist, reduzieren wir die Listengröße im Array und aktualisieren den Array Eintrag vom
Planet Target.

Am Ende dieses O(n*m) Prozesses, bei dem n die Anzahl der Planeten und m die Anzahl der Hyperroutes ist (worst case), haben wir einen
Array, in dem wir in O(n) alle Startplaneten auflisten können, und die Listengröße als extra Variable. Auf diese wir dann in O(1)
zugreifen und ausgeben.