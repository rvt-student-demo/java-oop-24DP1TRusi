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

    public TodoList() {
        this.todo = new ArrayList<>();
        loadFromFile();
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
        return this.todo.size() - 1;
    }

    public void add(String task) {
        String input = task.trim();

        if (checkEventString(input) == true) {
            this.todo.add((getListId() + 1) + "," + input);

            try (BufferedWriter wr = new BufferedWriter(new FileWriter("data/todo.csv", true))) {
                wr.write(getListId() + "," + input);
                wr.newLine();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        } else {
            System.out.println("Nederīga ievade!");
        }
    }

    public void print() {
        for (int i = 1; i < todo.size(); i++) {
            System.out.println(todo.get(i));
        }
    }

    private boolean updateFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/todo.csv"))) {
            for (int i = 0; i < todo.size(); i++) {
                bw.write(todo.get(i));
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void remove(int id) {
        this.todo.remove(id);
        updateFile();
    }

    public boolean checkEventString(String value) {
        final String regex = "^[a-zA-Z0-9 ]+$";
        if (value.length() < 3) {
            return false;
        } else {
            return value.matches(regex);
        }
    }
}
