package persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.Content;
import model.ListOfContent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ListOfContent loc = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testReaderEmptyLoc() {
        try {
            ListOfContent loc = new ListOfContent("");
            JsonWriter writer = new JsonWriter("./data/testReaderEmptyListOfContent.json");
            writer.open();
            writer.write(loc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testReaderEmptyListOfContent.json");

            loc = reader.read();
            assertEquals("", loc.getName());
            assertEquals(0, loc.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderGeneralLoc() {
        try {
            ListOfContent loc = new ListOfContent("");
            loc.addToList(new Content("a", 1992, "horror", "eng", 5, "hi"));
            loc.addToList(new Content("b", 1982, "comedy", "hin", 4, "ii"));
            JsonWriter writer = new JsonWriter("./data/testReaderGeneralListOfContent.json");
            writer.open();
            writer.write(loc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testReaderGeneralListOfContent.json");
            loc = reader.read();
            assertEquals("", loc.getName());
            List<Content> loC = loc.getList();
            assertEquals(2, loC.size());
            checkContent("a", 1992, "horror", "eng", 5, "hi", loC.get(0));
            checkContent("b", 1982, "comedy", "hin", 4, "ii", loC.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
