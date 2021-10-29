package persistence;

import model.Content;

import static org.junit.Assert.assertEquals;

public class JsonTest {
    protected void checkContent(String name, int year, String genre, String lang, int ratings,
                                String location, Content c) {
        assertEquals(name, c.getName());
        assertEquals(year, c.getYear());
        assertEquals(genre, c.getGenre());
        assertEquals(lang, c.getLanguage());
        assertEquals(ratings, c.getRatings());
        assertEquals(location, c.getLocation());
    }
}
