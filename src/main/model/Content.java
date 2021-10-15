package model;

public class Content {
    private String name;
    private int year;
    private String genre;
    private String language;
    private int ratings;
    private String location;

    //REQUIRES: 1 <= rating <= 5 and year > 1900
    //MODIFIES: this
    //EFFECTS: creates a new content
    public Content(String name,
                   int year,
                   String genre,
                   String lang,
                   int ratings,
                   String location) {

        this.name = name;
        this.year = year;
        this.genre = genre;
        language = lang;
        this.ratings = ratings;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getLanguage() {
        return language;
    }

    public int getRatings() {
        return ratings;
    }

    public String getLocation() {
        return location;
    }

    public void setRating(int newRating) {
        ratings = newRating;
    }
}
