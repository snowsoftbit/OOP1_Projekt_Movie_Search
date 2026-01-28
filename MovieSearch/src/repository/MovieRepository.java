package repository;

import model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;



public class MovieRepository {

    private final List<Movie> movies = new ArrayList<>();

    public void loadImdbCsv(String path) throws Exception {

        File file = new File(path);
        
        
        // File Input liest Datei in Bytes, 
        // InputStreamReader wandelt in UTF-8 um (bspw. bessere Darstellung von Umlauten), 
        // BufferedReader erlaubt effizientes Lesen (readline-Methode)
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file),
                        StandardCharsets.UTF_8
                )
        );

        String line;

        while ((line = reader.readLine()) != null) {

            // Leere Zeilen überspringen
            if (line.trim().isEmpty()) {
                continue;
            }

            // CSV-Zeile aufteilen
            String[] parts = line.split(",");

            // Ungültige Zeilen überspringen
            if (parts.length < 3) {
                continue;
            }

            String imdbId = parts[0].trim();
            String title = parts[1].trim();
            String director = parts[2].trim();

            // Pflichtfelder prüfen
            if (imdbId.isEmpty() || title.isEmpty() || director.isEmpty()) {
                continue;
            }

            Movie movie = new Movie(imdbId, title, director);
            movies.add(movie);
        }

        reader.close();
    }


    public void loadUserCsv(String path) throws Exception {

        File file = new File(path);

        // Wenn Datei nicht existiert: nichts tun
        if (!file.exists()) {
            return;
        }

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file),
                        StandardCharsets.UTF_8
                )
        );

        String line;

        while ((line = reader.readLine()) != null) {

            if (line.trim().isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");

            if (parts.length < 3) {
                continue;
            }

            String imdbId = parts[0].trim();
            String title = parts[1].trim();
            String director = parts[2].trim();

            if (imdbId.isEmpty() || title.isEmpty() || director.isEmpty()) {
                continue;
            }

            Movie movie = new Movie(imdbId, title, director);
            movies.add(movie);
        }

        reader.close();
    }




    public void addUserMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAllMovies() {
        return Collections.unmodifiableList(movies);
    }
}
