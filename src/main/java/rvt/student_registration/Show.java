package rvt.student_registration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Show {

    public void ShowStudents() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/Students.csv"));
            String line = "+" + "-".repeat(20) + "+" + "-".repeat(20) + "+" + "-".repeat(30) + "+" + "-".repeat(15)
                    + "+" + "-".repeat(25) + "+";
            System.out.println(line);
            System.out.printf("|%-20s|%-20s|%-30s|%-15s|%-25s|%n", "Vards", "Uzvards", "E-pasts", "Personal kods",
                    "Laiks un datums");
            System.out.println(line);

            br.readLine();
            String linija;
            while ((linija = br.readLine()) != null) {
                String[] parts = linija.split(",");
                System.out.printf("|%-20s|%-20s|%-30s|%-15s|%-25s|%n", parts[0], parts[1], parts[2], parts[3],
                        parts[4]);
            }
            System.out.println(line);
            br.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
