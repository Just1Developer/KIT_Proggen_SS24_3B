# Programmieren Aufgabe 3B - SS24

---

## Plagiarism Warning <span style="color:rgb(110, 110, 110); font-size:0.7em;">[EN]</span>

The source code of this Task is almost 1:1 present on the Artemis server. Copying the codebase or medium-large chunks of it may get caught by the plagiarism checker and result in disqualification from taking the module this semester or worse.
It is also advised to take great caution when looking through to code for inspiration, as this can lead to unwillingly or subconsciously copying chunks of the code.

## Plagiatswarnung <span style="color:rgb(110, 110, 110); font-size:0.7em;">[GER]</span>

Der Quellcode dieses Projekts ist nahezu 1:1 auf den Artemis servern vorhanden. Das Kopieren des Codes oder Stücken des codes kann den Plagiatschecker auslösen und dazu führen, dass der Übungsanspruch für Programmieren I dieses Semester verloren geht, oder Schlimmeres.<br/>
Es wird auch empfohlen, beim 'inspirieren lassen' aufzupassen, da hier auch unwillkürlich code in etwa übernommen werden kann.

---

### Achtung: Die Aufgaben darf ich im Rahmen der KIT Nutzungsrichtlinien nicht veröffentlichen. Das schließt genaues Dokumentieren der gesamten Aufgabenstellung mit ein. Ein vollständiges Verständnis dieses Repositories ist unter Umständen nur mit dem Arbeitsblatt möglich.

---

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