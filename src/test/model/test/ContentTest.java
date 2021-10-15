package model.test;

import model.Content;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContentTest {
    private Content h;
    private Content h2;
    private Content h3;
    private Content h4;

    @BeforeEach
    public void setup() {

        h = new Content("abc",1990, "Comedy", "eng", 5, "Netflix");
        h2 = new Content("efg ",2000,"Horror", "spn", 3, "Hulu");
        h3 = new Content("ijk",2001,"Action", "hin", 4, "HBO");
        h4 = new Content("mno ",2011,"Adventure", "eng", 5, "Disney");
    }

    @Test
    public void ContentConstructorTest() {
        assertEquals("abc",h.getName());
        assertEquals(5,h.getRatings());
        assertEquals(2001,h3.getYear());
        assertEquals("Horror",h2.getGenre());
        assertEquals("spn",h2.getLanguage());
        assertEquals("Disney",h4.getLocation());

    }

    @Test
    public void setRatingsTest() {

        assertEquals(5, h.getRatings());
        h.setRating(3);
        assertEquals(3, h.getRatings());
        h.setRating(3);
        assertEquals(3, h.getRatings());
        h2.setRating(5);
        h2.setRating(1);
        assertEquals(1, h2.getRatings());


    }
}
