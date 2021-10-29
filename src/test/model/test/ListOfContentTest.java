package model.test;

import model.Content;
import model.ListOfContent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListOfContentTest {

    ListOfContent LC1;
    ListOfContent LC2;
    ListOfContent LC3;

    Content c1;
    Content c2;
    Content c3;


    @BeforeEach
    public void setup() {
        LC1 = new ListOfContent("a");
        LC2 = new ListOfContent("b");
        LC3 = new ListOfContent("c");

        c1 = new Content("abc", 1995, "Comedy",
                "eng",5, "Netflix");
        c2 = new Content("ijk", 2000, "Sci-fi",
                "eng",4, "Hulu");
        c3 = new Content("xyz", 1990, "Horror",
                "hin",4, "Netflix");

        LC1.addToList(c1);
        LC1.addToList(c2);
        LC1.addToList(c3);
        LC2.addToList(c3);
    }

    @Test
    public void getListTest() {

        assertEquals(0,LC3.length());

        LC3.addToList(c1);
        LC3.addToList(c2);

        assertEquals(2,LC3.length());
        assertTrue(LC3.getList().contains(c1));
        assertTrue(LC3.getList().contains(c2));

        LC3.removeContent(c1.getName());

        assertEquals(1 ,LC3.getList().size());
        assertFalse(LC3.getList().contains(c1));
        assertTrue(LC3.getList().contains(c2));
    }

    @Test
    public void getNamesTest() {
        List<String> m = new ArrayList<>();
        m.add("abc");
        m.add("ijk");
        m.add("xyz");

        List<String> n = new ArrayList<>();
        n.add("xyz");

        assertEquals(m , LC1.getNames());
        assertEquals(n , LC2.getNames());
    }

    @Test
    public void getGenresTest() {
        List<String> m = new ArrayList<>();
        m.add("Comedy");
        m.add("Sci-fi");
        m.add("Horror");

        List<String> n = new ArrayList<>();
        n.add("Horror");

        assertEquals(m , LC1.getGenres());
        assertEquals(n , LC2.getGenres());
    }

    @Test
    public void getLanguagesTest() {
        List<String> m = new ArrayList<>();
        m.add("eng");
        m.add("eng");
        m.add("hin");

        List<String> n = new ArrayList<>();
        n.add("hin");

        assertEquals(m , LC1.getLanguages());
        assertEquals(n , LC2.getLanguages());
    }

    @Test
    public void getLocationTest() {
        List<String> m = new ArrayList<>();
        m.add("Netflix");
        m.add("Hulu");
        m.add("Netflix");

        List<String> n = new ArrayList<>();
        n.add("Netflix");


        assertEquals(m , LC1.getLocation());
        assertEquals(n , LC2.getLocation());
    }

    @Test
    public void contentByYearTest() {
        List<String> m = new ArrayList<>();
        m.add(c1.getName());

        List<String> n = new ArrayList<>();

        List<String> o = new ArrayList<>();
        o.add(c3.getName());

        assertEquals(m , LC1.contentbyYear(1995));
        assertEquals(n , LC1.contentbyYear(-1));
        assertEquals(o , LC2.contentbyYear(1990));
    }

    @Test
    public void contentByGenreTest() {
        List<String> m = new ArrayList<>();
        m.add(c1.getName());

        List<String> n = new ArrayList<>();
        n.add(c3.getName());

        assertEquals(m , LC1.contentbyGenre("Comedy"));
        assertEquals(n , LC2.contentbyGenre("Horror"));
    }

    @Test
    public void contentByLanguageTest() {
        List<String> m = new ArrayList<>();
        m.add(c1.getName());
        m.add(c2.getName());

        List<String> n = new ArrayList<>();
        n.add(c3.getName());

        assertEquals(m , LC1.contentbyLang("eng"));
        assertEquals(n , LC2.contentbyLang("hin"));
    }

    @Test
    public void contentByRatingsTest() {
        List<String> m = new ArrayList<>();
        m.add(c1.getName());

        List<String> n = new ArrayList<>();
        n.add(c3.getName());

        assertEquals(m , LC1.contentbyRatings(5));
        assertEquals(n , LC2.contentbyRatings(4));
    }

    @Test
    public void contentBySiteTest() {
        List<String> m = new ArrayList<>();
        m.add(c1.getName());
        m.add(c3.getName());

        List<String> n = new ArrayList<>();

        assertEquals(m , LC1.contentbySite("Netflix"));
        assertEquals(n , LC2.contentbySite("Hulu"));
    }

    @Test
    public void getNextContentTest() {

        LC1.addToList(c1);
        LC1.addToList(c2);
        LC1.addToList(c3);

        assertEquals(c1 , LC1.getNextContent());
        assertEquals(c2 , LC1.getNextContent());
    }

    @Test
    public void containsTest() {

        assertFalse(LC3.contains(c1.getName()));
        assertFalse(LC3.contains(c2.getName()));

        LC3.addToList(c1);

        assertTrue(LC3.contains(c1.getName()));
        assertFalse(LC3.contains(c2.getName()));

        LC3.addToList(c2);

        assertTrue(LC3.contains(c1.getName()));
        assertTrue(LC3.contains(c2.getName()));

        LC3.removeContent("abc");

        assertFalse(LC3.contains(c1.getName()));
        assertTrue(LC3.contains(c2.getName()));
    }

    @Test
    public void addToListAlreadyThereTest() {

        assertEquals(0,LC3.getList().size());

        LC3.addToList(c1);
        LC3.addToList(c2);

        assertEquals(2,LC3.getList().size());

        LC3.addToList(c1);
        LC3.addToList(c2);

        assertEquals(2,LC3.getList().size());
    }

    @Test
    public void addToListNotThereTest() {

        assertEquals(0,LC3.getList().size());

        LC3.addToList(c1);
        LC3.addToList(c2);

        assertEquals(2,LC3.getList().size());
    }


    @Test
    public void lengthTest() {

        assertEquals(3,LC1.length());
        assertEquals(0, LC3.length());
        assertEquals(1, LC2.length());
    }

    @Test
    public void isEmptyTest() {

        assertFalse(LC1.isEmpty());
        assertTrue(LC3.isEmpty());
    }

    @Test
    public void removeContentTest() {

        assertEquals(0,LC3.getList().size());

        LC3.addToList(c1);
        LC3.addToList(c2);

        assertEquals(2,LC3.getList().size());

        LC3.removeContent(c1.getName());
        assertEquals(1,LC3.getList().size());

        LC3.removeContent(c1.getName());
        assertEquals(1,LC3.getList().size());

        LC3.removeContent(c2.getName());
        assertEquals(0,LC3.getList().size());

        LC3.removeContent(c2.getName());
        assertEquals(0,LC3.getList().size());
    }
}