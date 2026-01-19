package rvt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private ArrayList<String> todo;

    public TodoList () {}

    public void add(String task) {
        try (PrintWriter pWriter = new PrintWriter(new FileWriter("data/todo.csv", true))) {
            pWriter.println(task);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void print() {
        try (Scanner  reader = new Scanner(new File("data/todo.csv"))) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                System.out.println(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void remove(int number) {
        this.todo.remove(number - 1);
    }
}
