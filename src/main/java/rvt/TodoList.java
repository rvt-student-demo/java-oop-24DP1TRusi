package rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.plaf.DimensionUIResource;

public class TodoList {
    private static ArrayList<String[]> todo;
    private final String filePath = "data/todo.csv";

    public TodoList() {
        this.todo = new ArrayList<>();
        loadFromFile();
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/todo.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                this.todo.add(line.split(","));
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
            String toInput = (getListId() + 1) + "," + input;
            this.todo.add(toInput.split(","));

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
            System.out.println(String.join(",", todo.get(i)));
        }
    }

    private boolean updateFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/todo.csv"))) {
            for (int i = 0; i < todo.size(); i++) {
                String line = String.join(",", todo.get(i));
                bw.write(line);
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

    public static String[][] getData() {
        String[][] data = new String[todo.size() - 1][];
        for (int i = 1; i < todo.size(); i++) {
            data[i - 1] = todo.get(i).clone();
        }
        return data;
    }

    public JTable createTable() {
        String[][] data = TodoList.getData();
        String[] columnName = { "ID", "Task"};
        JTable table = new JTable(data, columnName);

        table.setPreferredScrollableViewportSize(new DimensionUIResource(500, 50));
        table.setFillsViewportHeight(true);
        return table;
    }
}
