# Rekursion, minne och abstrakta datatyper
![Mandelbrotfraktalen](assets/top-image.jpg)

## Innehåll
- [Kodexempel](#kodexempel)
- [Föreläsningsslides](#presentationer)
- [Uppgifter och andra filer](#andra-filer)
- [IntelliJ-plugins](#verktyg)
- [Resurser](#resurser)
  - [Länkar](#links)
  - [Videoklipp](#videor)

# <a id="kodexempel"></a>Kodexempel

Sourcemappen innehåller:

| Filnamn                            | Beskrivning                                                                                                                                                                                    |
|------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **BinarySearch.java**              | Exempel på hur en binär sökning fungerar i Java.                                                                                                                                               |
| **Box.java**                       | En väldigt simpel generisk klass.                                                                                                                                                              |
| **DoubleNode.java**                | En rekursiv klass som kan användas för att skapa en dubbellänkad lista.                                                                                                                        |
| **FibonacciIterative.java**        | Ett exempel på hur iteration kan användas för att få bort den exponentiella tidskomplexiteten som en rekursiv fibonacci innebär.                                                               |
| **FibonacciRecursive.java**        | En rekursiv fibonaccialgoritm som anropar sig själv två gånger varje gång den körs.                                                                                                            |
| **FibonacciRecursiveDynamic.java** | Ett rekursivt fibonaccialternativ som använder en dynamisk programmeringsteknik för att effektivisera algoritmen.                                                                              |
| **FibonacciStackCounter.java**     | Ett program som genererar en webbsida som visar vad som pushas på och poppas från callstacken när en rekursiv fibonaccialgoritm anropas.                                                       |
| **Node.java**                      | En klass som kan användas för att bygga en Länkad Lista. En Node innehåller en instans av sig själv och kan därför sägas vara en rekursiv datastruktur.                                        |
| **SierpinskiTriangle.java**        | Ett program som ritar upp en liksidig triangel och för varje rekursivt anrop sedan delar in den i tre mindre trianglar. Använd +/- för att zooma och c för att slå på/av färg.                 |
| **SimpleQueue.java**               | En version av en kö som använder en dubbellänkad lista som underliggande datatyp.                                                                                                              |
| **Stack.java**                     | En implementation av en stack som är generisk för att man ska kunna lagra olika typer av data i den.                                                                                           |
| **ValueVsReference.java**          | Ett kort exempel som illustrerar skillnaden mellan att skicka variabler som värde och att skicka dem som referenser (detta sköts automatiskt i Java men det är bra att förstå vad som händer). |

# <a id="presentationer"></a>Föreläsningsslides
| Filnamn                                           | Beskrivning                                                                                                                                       |
|---------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|
| [**Föreläsning 1**](files/Forelasning_1_algo.pdf) | Presentationen från föreläsningstillfälle 29/1 där vi behandlade rekursiva algoritmer, callstacken, minne, referenser och dynamisk programmering. |
| [**Föreläsning 2**](files/Forelasning_2_algo.pdf) | Presentationen från föreläsningstillfälle 30/1 där vi pratade om rekursiva datastrukturer, abstrakta datatyper, Generics, stackar och köer.       |

# <a id="andra-filer"></a>Uppgifter och andra filer
| Filnamn                                                                      | Beskrivning                                                                                                                                                                                                                  |
|------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [**Rekursive_fibonacci_tree.pdf**](files/Recursive_fibonacci_tree.pdf)       | En bättre översikt av anropsträdet som skapas när vi anropar en rekursiv fibonaccialgoritm. Visar även hur anropen returnerar värden och i vilken ordning de skapas.                                                         |
| [**Godel_Escher_Bach_Recursion.pdf**](files/Godel_Escher_Bach_Recursion.pdf) | Utdrag från Douglas Hofstadters bok Gödel, Escher, Bach. Kapitlet handlar specifikt om rekursivitet. (26 sidor)                                                                                                              |
| [**Uppgifter vecka 5.pdf**](files/Uppgifter_vecka_5.pdf)                     | Uppgifter att arbeta med som handlar om det vi gått genom under vecka 5: rekursiva algoritmer, stackar, köer, minne och abstrakta datatyper.                                                                                 |
| [**Uppgifter_vecka_5_facit.pdf**](files/Uppgifter_vecka_5_facit.pdf)         | Lösningsförslag till uppgifterna ovan för vecka 5. (Försök att lösa dem själva innan ni kikar på lösningarna!)                                                                                                               |
| [**Lathund_Git.pdf**](files/Lathund_Git.pdf) | Lite instruktioner och allmänna tips för hur man använder Git och versionshantering. Ett bra tips är att börja jobba med versionshantering i era laborationer om ni inte redan gör det för att bli bekväma med arbetsflödet. |

# <a id="verktyg"></a>IntelliJ-plugins
- **PDF Viewer.** https://plugins.jetbrains.com/plugin/14494-pdf-viewer
- **CPU Usage Indicator.** https://plugins.jetbrains.com/plugin/8580-cpu-usage-indicator
- **One Dark Theme.** https://plugins.jetbrains.com/plugin/11938-one-dark-theme
- **Classic UI.** https://plugins.jetbrains.com/plugin/24468-classic-ui

# <a id="resurser"></a>Resurser

## <a id="links"></a>Länkar
- **Gif-animering av binär sökning**: https://www.mathwarehouse.com/programming/images/binary-vs-linear-search/linear-vs-binary-search-best-case.gif
- **Bra sammanfattning av Generics**: https://docs.oracle.com/javase/tutorial/java/generics/index.html
- **Abstrakta datatyper**: https://www.geeksforgeeks.org/abstract-data-types/
- **The importance of Naive Solutions**: https://softwaredoug.com/blog/2022/11/14/importance-of-naive-solutions
- **Boktips: Gödel, Escher, Bach.** https://sv.wikipedia.org/wiki/G%C3%B6del,_Escher,_Bach

## <a id="videor"></a>Videoklipp
- **The Secret Rules of Modern Living Algorithms** (58 min)<br>
[<img src="/assets/thumbnail_1.png" alt="The Secret Rules of Modern Algorithms" width="500"/>](https://www.youtube.com/watch?v=kiFfp-HAu64)
- **Stepping through Recursive Fibonacci** (8 min)<br>
[<img src="https://img.youtube.com/vi/zg-ddPbzcKM/hqdefault.jpg" alt="Stepping through recursive fibonacci" width="500"/>](https://www.youtube.com/watch?v=zg-ddPbzcKM)
- **The magic of fibonacci numbers** (6 min)<br>
[<img src="https://img.youtube.com/vi/SjSHVDfXHQ4/hqdefault.jpg" alt="The magic of fibonacci numbers" width="500"/>](https://www.youtube.com/watch?v=SjSHVDfXHQ4)
- **Fibonacci numbers and plants** (3 delar x 6 min - se alla)<br>
[<img src="https://img.youtube.com/vi/ahXIMUkSXX0/hqdefault.jpg" alt="Doodling in math" width="500"/>](https://www.youtube.com/watch?v=ahXIMUkSXX0)
- **David Brailsford om loopar och rekursion** (12 min)<br>
[<img src="https://img.youtube.com/vi/HXNhEYqFo0o/hqdefault.jpg" alt="Loops and Recursion" width="500"/>](https://www.youtube.com/watch?v=HXNhEYqFo0o)
- **Fractal Antennas** (3 min)<br>
[<img src="https://img.youtube.com/vi/1mPefLpoz50/hqdefault.jpg" alt="Fractal Antennas" width="500"/>](https://www.youtube.com/watch?v=1mPefLpoz50)
- **Program som sys in i minnet för Apollodatorn** (2 min)<br>
[<img src="https://img.youtube.com/vi/P12r8DKHsak/hqdefault.jpg" alt="Core rope memory" width="500"/>](https://www.youtube.com/watch?v=P12r8DKHsak)
- **Kort film om MC Escher** (4 min)<br>
[<img src="https://img.youtube.com/vi/Kcc56fRtrKU/hqdefault.jpg" alt="Kort film om MC Escher" width="500"/>](https://www.youtube.com/watch?v=Kcc56fRtrKU)
- **Fördjupning: Mandelbrotfraktalen** (16 min)<br>
[<img src="https://img.youtube.com/vi/FFftmWSzgmk/hqdefault.jpg" alt="Mandelbrotfraktalen" width="500"/>](https://www.youtube.com/watch?v=FFftmWSzgmk)
- **Fördjupning: Ackermann** (14 min)<br>
[<img src="https://img.youtube.com/vi/i7sm9dzFtEI/maxresdefault.jpg" alt="Fördjupning: Ackermannfunktionen" width="500"/>](https://www.youtube.com/watch?v=i7sm9dzFtEI)
