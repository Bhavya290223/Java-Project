package model;


import org.json.JSONObject;
import persistence.Writable;

// represents a content with name, year (above 1900), genre, language, ratings (out of 5), and streaming site
public class Content implements Writable {
    private String name;
    private int year;
    private String genre;
    private String language;
    private int ratings;
    private String location;

    // represents a content with name, year (above 1900), genre, language, ratings (out of 5), and streaming site
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
        EventLog.getInstance().logEvent(new Event("New ratings are: " + newRating));
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("year", year);
        json.put("genre", genre);
        json.put("language", language);
        json.put("ratings", ratings);
        json.put("site", location);
        return json;
    }
}
