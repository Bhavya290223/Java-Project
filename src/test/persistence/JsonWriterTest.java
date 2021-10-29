package persistence;

import model.Content;
import model.ListOfContent;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            ListOfContent loc = new ListOfContent("");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptyLoc() {
        try {
            ListOfContent loc = new ListOfContent("");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyList.json");
            writer.open();
            writer.write(loc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyList.json");
            loc = reader.read();
            assertEquals("", loc.getName());
            assertEquals(0, loc.getList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterGeneralLoc() {
        try {
            ListOfContent loc = new ListOfContent("");
            loc.addToList(new Content("saw 1", 1990, "Sci-Fi", "eng", 5, "hulu"));
            loc.addToList(new Content("saw 2", 1995, "Sci-Fi", "eng", 4, "hulu"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralList.json");
            writer.open();
            writer.write(loc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralList.json");
            loc = reader.read();
            assertEquals("", loc.getName());
            List<Content> contents = loc.getList();
            assertEquals(2, contents.size());
//            checkContent("saw 1", 1990, "Sci-Fi", "eng", 5, "hulu", contents.get(0));
//            checkContent("saw 2", 1995, "Sci-Fi", "eng", 4, "hulu", contents.get(1));
            assertEquals("saw 1", contents.get(0).getName());
            assertEquals("saw 2", contents.get(1).getName());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
