package storage;

import model.Movie;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CsvUserMovieStorage {

    private final Path filePath;

    public CsvUserMovieStorage(String path) {
        this.filePath = Paths.get(path);
    }

    public void saveMovie(Movie movie) throws IOException {
        // Ordner anlegen, falls er fehlt
        if (filePath.getParent() != null) {
            Files.createDirectories(filePath.getParent());
        }

        // Film ans Ende der Datei schreiben
        try (BufferedWriter writer = Files.newBufferedWriter(
                filePath,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        )) {
            writer.write(movie.getImdbId() + "," + movie.getTitle() + "," + movie.getDirector());
            writer.newLine();
        }
    }
}
