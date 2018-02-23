# I20 // Kraftwerk

_Strategy, Command, Adapter_

Einem Kraftwerk mit fünf Blöcken stehen die Quellen Wasser, Solar und Atomkraft für die EnergieErzeugung zur Verfügung: I - Wasser, II und III Solar, IV und V Atomkraft. Die fünf Blöcke werden zentral über eine Leitwarte gesteuert. Das Kommando ACTIVATE aktiviert einen Block und es wird Energie produziert. Das Kommando DEACTIVATE deaktiviert einen Block und es wird keine Energie geliefert. Die produzierte Energie pro Block wird als Zeichenkette der Länge 500 und den Zeichen [0,1] dargestellt. Die Zeichenkette enthält genau 380 Zeichen 1, die zufällig verteilt sind. Zwischen einem Block und der zentralen Sammelstation ist ein Adapter geschaltet, der die Zeichenkette auf eine Iteration von 0 und 1 (010101..) normiert. Die normierte Zeichenkette endet in 1, überschüssige Zeichen 1 nach dem letzten 01 werden durch den Adapter abgeschnitten. In der zentralen Sammelstation werden die normierten Zeichenketten zu einer fortlaufenden Zeichenkette verbunden. Über einen Adapter sind Haushalte an die zentrale Sammelstation angeschlossen. Für die Nutzung der produzierten Energie im Haushalt, entnimmt der Adapter eine Zeichenkette mit 220 Zeichen 1 aus der zentralen Sammelstation und generiert 4-er Blöcke (0101 0101...). Zu Simulationszwecken wird jede Sekunde Energie durch mindestens drei Blöcke für drei angeschlossene Haushalte produziert.

# Änderungen
> Die normierte Zeichenkette endet in 1, überschüssige Zeichen ~~0~~ nach der letzten ~~1~~ werden durch den Adapter abgeschnitten.

Die normierte Zeichenkette endet in 1, überschüssige Zeichen __1__ nach dem letzten __01__ werden durch den Adapter abgeschnitten.