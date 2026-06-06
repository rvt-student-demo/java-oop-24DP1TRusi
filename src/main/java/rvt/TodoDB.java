package rvt;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoDB {
    
    private static final String DB_URL = "jdbc:sqlite:todo.db";

    public TodoDB() {
        initSchema();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void initSchema() {
        String sql = "CREATE TABLE IF NOT EXISTS todo ("
                + "id INTEGER PRIMARY KEY,"
                + "task TEXT NOT NULL) STRICT";
        try (
            Connection conn = connect();
            Statement stmt = conn.createStatement();
        ) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Schema init failed: "
                + e.getMessage());
        }
            
    }
    public void add(String task) {
        String sql = "INSERT INTO todo(task) VALUES(?)";
        try (
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, task);

            int myRs = stmt.executeUpdate();
            System.out.println(myRs + " row(s) inserted");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

    }

    public ArrayList<String[]> findAll() {
        ArrayList<String[]> list = new ArrayList<>();
        String sql = "SELECT id, task FROM todo ORDER BY id";
        try (
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            ResultSet myRs = stmt.executeQuery();

            while (myRs.next()) {
                int id = myRs.getInt("id");
                String task = myRs.getString("task");
                list.add(new String[]{String.valueOf(id), task});
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    

    public void removeById(int id) {
        String sql = "DELETE FROM todo WHERE id = ?";
        try (
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
