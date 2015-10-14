# projzesp
Carpooling - projektowanie zespołowe

Wymagane:
- npm (path) https://nodejs.org/en/
- git (path) https://git-scm.com/
- Java 8 (path)

Jak tej cholery używać:
1) klonujemy projekt,
2) importujemy jak projekt gradle bazując na wraperze
3) wykonujemy komendę ./gradlew build lub wybieramy w ide task build
NOTE: podczas budowania powinny się ściągnąć wszystkie zależności zarówno Java'owe,
jak i frontendowe. Budowanie powinno się zakończyć wielkim napisem build successful! :D
4) wykonujemy komendę ./gradlew bootRun lub wybieramy w ide task bootRun
5) wpisujemy przeglądarkę adres http://localhost:8080/.

Struktura projektu:
1) src/main/java - pliki java'owe. (to raczej oczywiste),
2) src/test/java - pliki testów java'owych (piszemy testy piszemy!)
3) src/main/resources/public - pliki frontend'owe
4) ..../public/app - pliki jsowe i htmlowe (do osobnych folderów wrzucamy kolejne strony)
5) ..../public/app/routes.js - pliki do routingu wewnętrznego aplikacji
6) ..../public/app/app.js - moduł główny angulara.
7) ..../public/css - pliki cssowe
8) ..../index.html - szablon indexu, z którego jest generowany index. (Nie ruszać komentarzy!)
8a) swoje cssy linkujemy w bloku <!-- build:css css/main.css -->
8b) swoje jsy linkujemy w bloku <!-- build:js js/app.js -->
8c) o zależności zewnętrzne się nie martwcie same się wstawią, jeśli będą zadeklarowane w pliku bower.json
9) ..../templates/index.html - nie zmieniaj, bo i tak Ci to nic nie da, ponieważ jest generowany.
10) .../bower_components/ - zależności zewnętrzne
11) application.yml - propertiesy aplikacji
12) .bowerrc - deklaracja ścieżki do zależności zewnętrznych frontendu
13) bower.json - taki mini pom.xml lub build.gradle dla frontendu.
NOTE: Tu wrzucamy wszystkie zależności frontendowe. Nie ściągać inaczej!

NOTE: Proponuje funkcjonalną strukturę pakietów.