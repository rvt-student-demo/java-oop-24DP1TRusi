package rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class TodoList {
    private ArrayList<String> todo;
    private final String filePath = "data/todo.csv";

    public TodoList () {
        this.todo = new ArrayList<>();
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/todo.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                this.todo.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    private int getListId() {
        return todo.size();
    }

    public void add(String task) {
        this.todo.add(task);

        try (BufferedWriter pWriter = new BufferedWriter(new FileWriter("data/todo.csv", true))) {

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void print() {
        for (int i = 0; i < todo.size(); i++) {
            int num = i + 0;
            System.out.println((num + 1) + ":" + todo.get(i));
        }

        // try (Scanner  reader = new Scanner(new File("data/todo.csv"))) {
        //     while (reader.hasNextLine()) {
        //         String row = reader.nextLine();
        //         System.out.println(row);
        //     }
        // } catch (Exception e) {
        //     System.out.println("Error: " + e.getMessage());
        // }
    }
    public void remove(int id) {
        this.todo.remove(id - 1);
    }
}
