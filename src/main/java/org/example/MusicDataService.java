package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class MusicDataService {
    @GetMapping("/all")
    public String getAllEntries() throws SQLException, JsonProcessingException {
        System.out.println("Gordelweg");
        String q = "SELECT * FROM songs3;";
        PreparedStatement statement = DBConnection.getConnection().prepareStatement(q);
        ResultSet result = statement.executeQuery();
        List<Object> list = new ArrayList<Object>();
        while (result.next()) {
            list.add(new Song(
                    result.getInt("id"),
                    result.getString("artist"),
                    result.getString("title"),
                    result.getLong("created"),
                    result.getBoolean("starred"),
                    result.getString("genre")
            ));
        }
        System.out.println("Added song: " + list.get(0).toString() );
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addObject(@RequestBody Song object) throws SQLException {
        System.out.println("HEllo mellow");
        this.insertObject(object);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteItemById(@RequestParam int id) throws SQLException {
        this.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/put")
    public ResponseEntity<Void> setFavorite(@RequestParam int id, @RequestParam boolean starred) throws SQLException {
        System.out.println("putty putty putty");
        this.setFavoriteValue(id, starred);
        return ResponseEntity.ok().build();
    }
    private void insertObject(Song song) throws SQLException {
        String q = "INSERT INTO songs3 (artist, title, created, genre) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DBConnection.getConnection().prepareStatement(q);
        statement.setString(1, song.getArtist());
        statement.setString(2, song.getTitle());
        statement.setString(3, String.valueOf(song.getCreated()));
        statement.setString(4, song.getGenre());
        statement.executeUpdate();
    }

    private void deleteById(int id) throws SQLException {
        System.out.println("Loesoe");
        String q = "DELETE FROM songs3 WHERE id = ?;";
        PreparedStatement statement = DBConnection.getConnection().prepareStatement(q);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    private void setFavoriteValue(int id, boolean value) throws SQLException {
        String q = "UPDATE songs3 SET starred = ? WHERE id = ?;";
        PreparedStatement statement = DBConnection.getConnection().prepareStatement(q);
        statement.setInt(1, value ? 1 : 0);
        statement.setInt(2, id);
        statement.executeUpdate();
    }
}