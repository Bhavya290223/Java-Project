package persistence;

import model.Content;
import model.ListOfContent;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// This class references code from the WorkRoomApp repository
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents a reader that reads list of contents from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads list of Content from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ListOfContent read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseLoC(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses List of contents from JSON object and returns it
    private ListOfContent parseLoC(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        ListOfContent loc = new ListOfContent(name);
        addContents(loc, jsonObject);
        return loc;
    }

    // MODIFIES: loc
    // EFFECTS: parses loc from JSON object and adds them to List of contents
    private void addContents(ListOfContent loc, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("loc");
        for (Object json : jsonArray) {
            JSONObject nextContent = (JSONObject) json;
            addContent(loc, nextContent);
        }
    }

    // MODIFIES: loc
    // EFFECTS: parses content from JSON object and adds it to List of contents
    private void addContent(ListOfContent loc, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int year = jsonObject.getInt("year");
        String genre = jsonObject.getString("genre");
        String language = jsonObject.getString("language");
        int ratings = jsonObject.getInt("ratings");
        String location = jsonObject.getString("site");
        Content c = new Content(name, year, genre, language, ratings, location);
        loc.addToList(c);
    }
}
