# Pünktliche-Bahn
Gruppenarbeit Mechatronik Trinational Descartes: Daniel Ott, André Fuchs, Patrik Lämmle, Philippe Licht

![Titel Bild]( https://github.com/Gladius-Illuminatus/Puenktliche-Bahn/blob/master/PB.png)



## Inhaltsverzeichnis
1. SCRUM Team

2. Zielsetzung Kunde

3. Epic

4. Definition of Ready	(DoR)

5. Definition of Done	(DoD)

6. User Storys 

7. User Rollen

8. Tasks mit Akzeptanzkriterium

9. Story-Points

10. Priorisierung

11. Release Plan

12. Testing

13. Appendix



## 1. SCRUM Team
Philippe: 	Programmierer/Oberflächen Designer

Andre: 		Programmierer / Software Architekt
	
Daniel: 		SCRUM Master	/ Programmierer	

Patrik:		PO/ Programmierer


 
## 2. Zielsetzung Kunde
Sehr geehrte Descartes

Mein Name ist Loko Motive und ich bin Leiter der „Pünktliche Bahn, a subsidiary of AB Inc.“. Meine Firma plant Ticketcounter einzuführen und braucht für diese Interfaces. 

Ich pendle oft. Das Interface der DB ist manchmal unklar zu bedienen. Beispielsweise werden Bahnfahrten auf dem Interface unterteilt zwischen Europa und nur Deutschland, weshalb Basel SBB nicht sofort als Option zu finden ist, obwohl das die Endstation des einzigen Zuges bei meiner Haltestelle ist.

Deshalb wünsche ich mir, dass durch diese Interfaces der Kunden schnell, unkompliziert und mit möglichst wenig Klicks sein gewünschtes Ticket kaufen kann.



## 3. Epic 
Als Kunde möchte ich meinen Abfahrts- und Zielort auswählen können, und zum Ticketkauf weitergeleitet werden, die Zugfahrklasse und Alterskategorie auswählen und sofort das Ticket beziehen.
 
 
 
## 4. Definition of Ready	(DoR)
* Backlog Items sind klein genug.

* Backlog Items sind für jeden Beteiligten klar verständlich.

* Jedes Backlog Item ist geschätzt.

* Jedes Backlog Item hat Akzeptanzkriterien (Min. 1).

* Akzeptanzkriterien sind von jedem Beteiligten verstanden.

* Jedes Backlog Item hat eine Priorisierung.



## 5. Definition of Done	(DoD)
* Alle Akzeptanzkriterien wurden erfüllt.

* Dokumentation wurde durchgeführt.

* Release Dokumentation wurde angepasst.

* Es wurden Unit Tests durchgeführt und als gut befunden «Grün».

* Es sind keine kritischen Bugs offen.


 
## 6. User Storys 
1. Als Kunde möchte ich Abfahrts- und Zielort auswählen können, um die Fahrstrecke zu definieren.

2. Als Kunde möchte ich das Ticket einfach spezifizieren und kaufen können, um keine Zeit zu verlieren.
## 7. User Rollen
**Kunde:**

Besitz keine Kenntnisse über die Software.

Das wichtigste Ziel ist, dass die Software ohne Komplikationen und Anwendungskenntnisse bedient werden kann.

**Supporter:**

Besitzt ein sehr detailliertes Wissen über die Software und die Grundthematik.

Das wichtigste Ziel ist, dass die Software fehlerfrei funktioniert.

**Administrator:**

Besitzt Kenntnisse über die Software und ist für deren Funktionalität verantwortlich.

Im Falle einer Störung wird ein Supporter aufgeboten.

Das wichtigste Ziel ist, dass die Software möglichst fehlerfrei funktioniert.



 
 
## 8. Tasks mit Akzeptanzkriterium
User Story 1

Use Case 1|Abart und Zielort Eingabe|Akzeptanzkriterium
------|------|------
Beschreibung|Der Benutzer kann den Abfahrt- und Zielort eingeben|
Voraussetzung|GUI Panel 1 Lay-out + Liste der Abfahrt und Zielorte
Task 1|GUI Panel 1 Layout erstellen|Button für Ziel und Abfahrtsort, Bestätigen vorhanden.
Task 2|Liste der Orte erstellen|Liste ist mit min 10 Orten in txt Forma vorhanden
Task3.1|GUI Panel 1 File Reader|Variablen werden korrekt eingelesen
Task3.2|GUI Panel 1 Programmieren, Liste einbinden, Button erstellen|Alle Button laut Layout sind vorhanden, Orte können ausgewählt werden und werden korrekt angezeigt
Task 4.1|Unit Test 1.1 schreiben|
Task 4.2|Unit Test 1.2 schreiben|



Use Case 2|Abfahrt, Ankunftszeit angeben, bestätigen/zurück|Akzeptanzkriterium
------|------|------
Beschreibung|Der Benutzer sieht die theoretische Abfahrt und Ankunftszeit
Voraussetzung|GUI Panel 2 Layout + Algorithmus zur Fahrzeit Berechnung
Task 5|GUI Panel 2 Layout erstellen|Anzeigen für gewählter Abfahrts-, Zielort + nächste Verbindung und Fahrzeit + Bestätigungsknopf 
Task 6|GUI Panel 2 Programmieren|Anzeige funktioniert gemäss Layout + der Button bestätigen ist vorhanden und schaltet korrekt
Task 7|Untit Test 2 schreiben


User Story 2

Use Case 3|Zugfahrklasse und Alterskategorie auswählen|Akzeptanzkriterium
------|------|------
Beschreibung|Der Benutzer kann zwischen Erst- und Zweitklassig wählen und zwischen Kleingeist, Halbstark und Grossmaul auswählen|
Voraussetzung|GUI Panel 3 Layout
Task 8|GUI Panel 3 Layout erstellen|Buttons für Klassen und Alterskategorien sind vorhanden
Task 9|GUI Panel 3 Programmieren|Button gemäss Layout vorhanden
| Schnittstelle erstellen |Variablen werden korrekt umgeschaltet
Task 10|Unit Test 3 erstellen



Use Case 4|Ticket kaufen und bezahlen|Akzeptanzkriterium
------|------|------
Beschreibung|Der Benutzer kann auf Kaufen tippen und bekommt eine Kaufbestätigung mit Ticket
Voraussetzung|GUI Panel 4 Layout
Task 11|GUI Panel 4 Layout erstellen|Button Kaufen, Layout Ticket erstellen
Task 12|GUI Panel 4 Programmieren, Schnittstelle erstellen|Button gemäss Layout erstellen und Variablen umstellen
Task 13|Ticket ausgeben|Ticket wird gemäss Layout angezeigt
Task 14|Unit Test 4 erstellen

 
 
## 9. Story-Points
![ Story-Points 1]( https://github.com/Gladius-Illuminatus/Puenktliche-Bahn/blob/master/StoryPoints1.png)
Erster Durchgang

![ Story-Points 2]( https://github.com/Gladius-Illuminatus/Puenktliche-Bahn/blob/master/StoryPoints2.png)
Zweiter Durchgang



## 10. Priorisierung
![Priorisierung]( https://github.com/Gladius-Illuminatus/Puenktliche-Bahn/blob/master/Gewichtung.png)
 
 
 
## 11. Release Plan
Iteration 1  (11.12.19) |Iteration 2  (17.12.19) |Iteration 3  (10.01.20)
------|------|------
Task 1: GUI Panel 1 Layout erstellen |~~Task 4.1: Unit Test 1.1 schreiben~~|~~Task 7: Unit Test 2 schreiben~~
Task 2: Liste der Orte erstellen |~~Task 4.2: Unit Test 1.2 schreiben~~|~~Task 10: Unit Test 3 schreiben~~
Task 3.1: GUI Panel 1 File Reader erstellen|Task 9: GUI Panel 3 Programmieren, Schnittstelle erstellen|~~Task 14: Unit Test 4 schreiben~~
Task 3.2: GUI Panel 1 Programmieren, Liste einbinden, Button erstellen| Task 12: GUI Panel 4 Programmieren, Schnittstelle erstellen |Bugs fixen: Blue Screen of Death reparieren.
Task 5: GUI Panel 2 Layout erstellen|Task 13 Ticket ausgeben
Task 6: GUI Panel 2 Programmieren|Task 15: JUnitTest zu Funktion: positionOfStringInArray();
Task 8: GUI Panel 3 Layout erstellen|Task 16: JUnitTest 2 zu Funktion: formatDoubleToString();
Task 11: GUI Panel 4 Layout erstellen

Task 15 und 16 wurden nach Absprache mit dem Lehrer Herr Bachmann erstellt, weil die vorigen Unit Tests der Task 4.1, 4.2, 7, 10 und 14 nicht in der vorgesehenen Form durchführbar sind.


 
## 12. Testing
Zu testende Punkte|gut|schlecht
------|:------:|:------:
Abfahrtsort kann ausgewählt werden|X
Ankunftsort kann ausgewählt werden|X
Button Bestätigen funktioniert auf allen Schaltflächen|X
Fahrzeit wird korrekt angezeigt|X
Ankunftszeit wird korrekt angezeigt|X
Fahrklasse kann ausgewählt werden|X
Altersklasse kann ausgewählt werden|X
Button Fahrkarte drucken funktioniert|X
Ticket Ausgabe wird angezeigt||X


## 13. Appendix

Layout 1

![Layout 1](https://github.com/Gladius-Illuminatus/Puenktliche-Bahn/blob/master/GUI%201.%20Layout.png )

Layout 2

![Layout 2]( https://github.com/Gladius-Illuminatus/Puenktliche-Bahn/blob/master/GUI%202.%20Layout.png)

Layout 3

![Layout 3](https://github.com/Gladius-Illuminatus/Puenktliche-Bahn/blob/master/GUI%203.%20Layout.png )


Layout 4

![Layout 4](https://github.com/Gladius-Illuminatus/Puenktliche-Bahn/blob/master/GUI%204.%20Layout.png )


Planungsboard

![Trello](https://github.com/Gladius-Illuminatus/Puenktliche-Bahn/blob/master/Trello.PNG )

