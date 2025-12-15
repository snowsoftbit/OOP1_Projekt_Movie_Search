package repository;

import model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieRepository {

    private final List<Movie> movies = new ArrayList<>();

    public void loadImdbCsv(String path) throws Exception {
        // TODO (du): CSV einlesen, jede Zeile -> new Movie(imdbId, title, director) -> add
        // Tipp: UTF-8 verwenden, ungültige Zeilen skippen
    }

    public void loadUserCsv(String path) throws Exception {
        // TODO (du): Wenn Datei nicht existiert: einfach return
        // Sonst Zeilen im gleichen Format wie IMDB laden
    }

    public void addUserMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAllMovies() {
        return Collections.unmodifiableList(movies);
    }
}
