package persistence;

import model.ListOfContent;
import org.json.JSONObject;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// This class references code from the WorkRoomApp repository
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of List of Contents to file
    public void write(ListOfContent loc) {
        JSONObject json = loc.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
