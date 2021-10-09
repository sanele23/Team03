package team03;
import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Game {
    private Player player;
    private static Charset ENCODING = StandardCharsets.UTF_8;

    // Create a new game
    public Game(Player player) {
        this.player = player;
    }

    // Display game content
    public void display() {

        if (null != player) {
            player.display();
        }
        else {
            System.out.println("<empty>");
        }
    }

    // Save game to a file
    public void saveGame(String filename) {
        // Generate the JSON
        Gson gson = new Gson();
        Path path = Paths.get(filename);
        Writer writer = null;

        // Following code is reproduced/based on StackOverflow post:
        try {
            writer = Files.newBufferedWriter(path, ENCODING);
            gson.toJson(player, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (null != writer)
        {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return;
    }

    // Load a new game
    public static Game loadGame(String fileName) {
        Gson gson = new Gson();
        Path path = Paths.get(fileName);
        Reader reader = null;
        Player player = null;

        try {
            reader = Files.newBufferedReader(path, ENCODING);
            player = gson.fromJson(reader, Player.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (null != reader) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new Game(player);
    }


}
