package ui;

import java.util.List;
import java.util.Scanner;
import model.Movie;
import repository.MovieRepository;
import search.MovieSearchService;
import storage.CsvUserMovieStorage;

public class MovieSearchApp {

    private final Scanner sc = new Scanner(System.in);

    private final MovieRepository repo = new MovieRepository();
    private final MovieSearchService searchService = new MovieSearchService();
    private final CsvUserMovieStorage storage = new CsvUserMovieStorage("data/user_movies.csv");

    public static void main(String[] args) {
        new MovieSearchApp().run();
    }

    public void run() {
        // Filme laden
        try {
            repo.loadImdbCsv("MovieSearch/data/movie_directors_export_new.csv");
            repo.loadUserCsv("MovieSearch/data/user_movies.csv");
        } catch (Exception e) {
            System.out.println("Fehler beim Laden der Dateien.");
        }

        // Menü
        while (true) {
            printMenu();
            String choice = sc.nextLine().trim().toLowerCase();

            if (choice.equals("a")) {
                handleSearch();
            } else if (choice.equals("b")) {
                handleAddMovie();
            } else if (choice.equals("c")) {
                System.out.println("Programm beendet.");
                break;
            } else {
                System.out.println("Bitte a, b oder c eingeben.");
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("a) Neue Suche");
        System.out.println("b) Neuen Film eingeben");
        System.out.println("c) Beenden");
        System.out.print("Auswahl: ");
    }

    private void handleSearch() {
        System.out.print("Titel-Teil (leer = egal): ");
        String titlePart = sc.nextLine();

        System.out.print("Regisseur-Teil (leer = egal): ");
        String directorPart = sc.nextLine();

        List<Movie> results = searchService.search(repo.getAllMovies(), titlePart, directorPart);

        System.out.println("Treffer: " + results.size());
        for (Movie m : results) {
            System.out.println(m);
        }
        // Einbau einer Verzögerung
        System.out.println();
        System.out.println("Weiter mit Enter...");
        sc.nextLine();
    }

    private void handleAddMovie() {
        System.out.print("Titel: ");
        String title = sc.nextLine();

        System.out.print("Regisseur: ");
        String director = sc.nextLine();

        if (title.isEmpty() || director.isEmpty()) {
            System.out.println("Titel und Regisseur dürfen nicht leer sein.");
            return;
        }

        String imdbId = "user-" + System.currentTimeMillis();
        Movie movie = new Movie(imdbId, title, director);

        // sofort suchbar
        repo.addUserMovie(movie);

        // dauerhaft speichern
        try {
            storage.saveMovie(movie);
            System.out.println("Film gespeichert.");
        } catch (Exception e) {
            System.out.println("Speichern fehlgeschlagen.");
        }
    }
}
