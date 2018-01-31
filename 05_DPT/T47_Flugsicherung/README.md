# Aufgabenstellung
Zu Simulationszwecken existieren zwei Flughäfen A und B mit einer Entfernung von 1000. 
Gleichzeitig startet ein Flugzeug F1 in A und ein Flugzeug F2 in B. 
F1 und F2 sind bei der Flugsicherung registriert und werden kontinuierlich überwacht. 
F1 und F2 nutzen die gleiche Route und bewegen sich nach dem Start in einer Reisehöhe von initial 10000. 
F1 und F2 fliegen konstant mit einer Geschwindigkeit von 20 pro Sekunde. 
Die zulässige Reisehöhe liegt im Normalfall zwischen 9500 und 11250. 
Der Mindestabstand zwischen F1 und F2 bezüglich der Höhe beträgt 250. 
Mit einer Wahrscheinlichkeit von 0.2 ändert ein Flugzeug pro Sekunde die Reisehöhe um +/- 250 innerhalb des zulässigen Bereichs. 
Sind die beiden Flugzeuge eine Sekunde voneinander entfernt und auf gleicher Reisehöhe, 
wird die Flugsicherung automatisch benachrichtigt. Die Flugsicherung sendet das Kommando CLIMB an F1 oder F2 (zufällig bestimmt). 
F1 oder F2 steigt um 250. In diesem kritischen Fall liegt die zulässige Reisehöhe zwischen 9250 und 11500. 
Eine Kollision von F1 und F2 in der nächsten Sekunde wird dadurch ausgeschlossen.

## Modifikationen   
Sind die beiden Flugzeuge eine Sekunde voneinander entfernt und auf gleicher Reisehöhe, 
wird die Flugsicherung automatisch **von ihren Listenern** benachrichtigt. 
F1 oder F2 steigt um ~~250~~ **500**. In diesem kritischen Fall liegt die zulässige Reisehöhe zwischen ~~9250~~ **9000** und ~~11500~~ **11750**. 
