package model;


public class Movie {
    private final String imdbId;
    private final String title;
    private final String director;

    public Movie(String imdbId, String title, String director) {
        this.imdbId = imdbId;
        this.title = title;
        this.director = director;
    }

    public String getImdbId() { return imdbId; }
    public String getTitle() { return title; }
    public String getDirector() { return director; }

    @Override
    public String toString() {
        return title + " — " + director;
    }
}
