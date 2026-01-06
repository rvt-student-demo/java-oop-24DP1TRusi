package rvt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner  reader = new Scanner(new File("data/data.csv"))) {
            reader.nextLine();
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                String[] parts = row.split(",");
                String name = parts[0];
                int age = Integer.valueOf(parts[1]);
                int id = Integer.valueOf(parts[2]);
                String email = parts[3];
                String course = parts[4];
                double gpa = Double.valueOf(parts[5]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
