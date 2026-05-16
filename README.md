# OOP1 Projekt Movie Search

## General 
Dies ist der GitHub Repo für unser Movie Search OOP1 Projekt. Das Repository ist [hier](https://github.com/sofia1738/OOP1_Projekt_Movie_Search.git) abrufbar. Ziel war es ein Konsolenprogramm zur Suche in der IMDB-Datenbank zu entwickeln mit folgenden Funktionen:

-Man kann Titel oder Regisseur einschränken und jeweils nach einen Teil des Bezeichners
suchen. Es gibt ein Menü zur Auswahl von: 

- a) Neue Suche
- b) Neue Filme eingeben
- c) Programm beenden

Die eingegebenen Filme werden in einer separaten Textdatei gespeichert, die für die Suche zusätzlich geladen wird.

## Root Folder

- MovieSearch/src
- data
- resources/media
- .gitignore
- OOP1_Projekt_Movie_Search.jar
- README.md

## Team Mitglieder und Rollen

- Zuständig für MovieRepository und Movie: Sofia W

- Zuständig für MovieSearchService: snowsoftbit

- Zuständig für MovieSearchApp und CsvUserMovieStorage: Cara

## Bedienung und Anleitung für die Nutzung in einem Terminal

![Demo Gif of the Movie Search Program](resources/media/gifs/Movie_Search_Demonstration.gif)

1. Java Installieren. Wir haben die [hier](https://adoptium.net/temurin/releases) erhältliche openjdk version "25.0.2" verwendet.
2. Die ZIP datei vom Repository herunterladen und Entpacken
3. Terminal öffnen
4. In den Projekt Ordner wechseln der gerade entpackt wurde

### Dies ist was man im Terminal eingeben muss

```bash
cd /your/path/to/OOP1_Projekt_Movie_Search-main
java -jar OOP1_Projekt_Movie_Search.jar
