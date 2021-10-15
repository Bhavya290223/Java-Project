package model;

import java.util.ArrayList;
import java.util.List;

public class ListOfContent {
    private List<Content> loC;
    private int position;

    //EFFECTS - creates a new List of Content
    public ListOfContent() {
        loC = new ArrayList<>();
    }

    //EFFECTS: returns the List of Content
    public List<Content> getList() {
        return loC;
    }

    //EFFECTS: checks whether the list contains a Content with the given name
    public boolean contains(String cn) {
        for (Content l:loC) {
            if (cn.equals(l.getName())) {
                return true;
            }
        }
        return false;
    }

    //EFFECTS: returns the List of names of contents
    public List<String> getNames() {
        List<String> n = new ArrayList<>();
        for (Content c : loC) {
            n.add(c.getName());
        }
        return n;
    }

    //EFFECTS: returns the List of genres of contents
    public List<String> getGenres() {
        List<String> n = new ArrayList<>();
        for (Content c : loC) {
            n.add(c.getGenre());
        }
        return n;
    }

    //EFFECTS: returns the List of languages of contents
    public List<String> getLanguages() {
        List<String> n = new ArrayList<>();
        for (Content c : loC) {
            n.add(c.getLanguage());
        }
        return n;
    }

    //EFFECTS: returns the List of sites of contents
    public List<String> getLocation() {
        List<String> n = new ArrayList<>();
        for (Content c : loC) {
            n.add(c.getLocation());
        }
        return n;
    }

    //EFFECTS: returns the List of contents by given year
    public List<String> contentbyYear(int newYear) {
        List<String> n = new ArrayList<>();
        for (Content c : loC) {

            if (newYear > 1800 && newYear == c.getYear()) {
                n.add(c.getName());
            }
        }
        return n;
    }

    //EFFECTS: returns the List of contents by given genre
    public List<String> contentbyGenre(String newGenre) {
        List<String> n = new ArrayList<>();
        for (Content c : loC) {

            if (newGenre.equals(c.getGenre())) {
                n.add(c.getName());
            }
        }
        return n;
    }

    //EFFECTS: returns the List of contents by given language
    public List<String> contentbyLang(String newLang) {
        List<String> n = new ArrayList<>();
        for (Content c : loC) {

            if (newLang.equals(c.getLanguage())) {
                n.add(c.getName());
            }
        }
        return n;
    }

    //EFFECTS: returns the List of contents by given ratings
    public List<String> contentbyRatings(int newRatings) {
        List<String> n = new ArrayList<>();
        for (Content c : loC) {

            if (newRatings == c.getRatings()) {
                n.add(c.getName());
            }
        }
        return n;
    }

    //EFFECTS: returns the List of contents by given site
    public List<String> contentbySite(String newSite) {
        List<String> n = new ArrayList<>();
        for (Content c : loC) {

            if (newSite.equals(c.getLocation())) {
                n.add(c.getName());
            }
        }
        return n;
    }

    //MODIFIES: this
    //EFFECTS: adds a content to the List of contents
    public void addToList(Content c) {
        if (!loC.contains(c)) {
            loC.add(c);
        }
    }

    //EFFECTS: returns the length of List of contents
    public int length() {
        return loC.size();
    }

    //EFFECTS: checks whether the List of contents is empty or not
    public boolean isEmpty() {
        return loC.size() == 0;
    }

    //EFFECTS: returns the next item in the List of contents
    public Content getNextContent() {
        Content ret = loC.get(position);
        position++;
        return ret;
    }

    //MODIFIES: this
    //EFFECTS: removes a content from the list of content
    public void removeContent(String name) {
        for (Content next : loC) {
            if (name.equals(next.getName())) {
                loC.remove(next);
            }
        }
    }
}
