package search;

import java.util.ArrayList;
import java.util.List;
import model.Movie;

public class MovieSearchService {

    public List<Movie> search(List<Movie> movies, String titlePart, String directorPart) {

        List<Movie> result = new ArrayList<>();

        if (movies == null) {
            return result;
            // Wenn unser ArrayList fuer Movies leer ist
        }


        String titleFilter;
        if (titlePart == null) {
            titleFilter = "";
        } else {
            titleFilter = titlePart.trim().toLowerCase();
        }

        String directorFilter;
        if (directorPart == null) {
            directorFilter = "";
        } else {
            directorFilter = directorPart.trim().toLowerCase();
        }

        // Die Suche muss case-insensitive sein also .toLowerCase() verwenden.
        // Die .trim() methode entfernt white space bei der Eingabe des Benutzers
        // Dies behandelt leere Eingaben vom Benutzer und filter Eingaben

        for (Movie movie : movies) {
            // Dies geht durch alle Filme durch

            boolean matchesTitle;
            boolean matchesDirector;

            // Nach Titel suchen und pruefen
            if (titleFilter.isEmpty()) {
                matchesTitle = true;
            } else {
                String movieTitle = movie.getTitle();

                if (movieTitle == null) {
                    matchesTitle = false;

                } else {
                    matchesTitle = movieTitle.toLowerCase().contains(titleFilter);
                }
            }

            // nach Director suchen und pruefen
            if (directorFilter.isEmpty()) {
                matchesDirector = true;
            } else {
                String movieDirector = movie.getDirector();

                if (movieDirector == null) {
                    matchesDirector = false;
                } else {
                    matchesDirector = movieDirector.toLowerCase().contains(directorFilter);
                }
            }

            if (matchesTitle && matchesDirector) {
                result.add(movie);
                // Kombinationssuche erfolgt nur wenn Titel und Director passen bzw. true sind
                // erlaubt auch Suche nur nach Director oder Titel wenn eines davon leer ist.
            }
        }

        return result;
    }
}
