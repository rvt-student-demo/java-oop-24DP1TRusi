package rvt;

import java.sql.Statement;
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
        String sql = "INSERT INTO todo(task) VALUE(?)";
        try (
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, task);

            int myRs = stmt.executeUpdate();
            System.out.println(myRs + " record(s) inserted");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

    }

    public void findAll() {
        String sql = "SELECT id, task FROM todo ORDER BY id";
        try (
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            ResultSet myRs = stmt.executeQuery();

            while (myRs.next()) {
                int id = myRs.getInt("id");
                String task = myRs.getString("task");

                System.out.println(id + "|" + task);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeById(int id) {
        String sql = "DELETE todo WHERE id = ?";
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
