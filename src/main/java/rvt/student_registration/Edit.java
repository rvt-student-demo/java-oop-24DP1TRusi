package rvt.student_registration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Edit {
    String filePath = "data/Students.csv";
    Scanner scanner;
    Requirements check;

    public Edit() {
        check = new Requirements();
    }

    public void editStudent(Scanner scanner) {
        try {
            System.out.println("Ievado skolēna personas kodu:");
            String code = scanner.nextLine();
            if (check.CheckCode(code)) {
                String vards;
                String uzvards;
                String email;
                while (true) {
                    System.out.print("Ievadi vārdu:");
                    vards = scanner.nextLine();

                    if (check.checkVards(vards)) {
                        break;
                    }
                    System.out.print("Vārds nav korekts. Mēģini vēlreiz.");
                }

                while (true) {
                    System.out.print("Ievadi uzvārdu:");
                    uzvards = scanner.nextLine();

                    if (check.checkUzvards(uzvards)) {
                        break;
                    }
                    System.out.print("Uzārds nav korekts. Mēģini vēlreiz.");
                }

                while (true) {
                    System.out.print("Ievadi epastu:");
                    email = scanner.nextLine();

                    if (check.CheckEmail(email)) {
                        break;
                    }
                    System.out.print("Epasts nav pareizs. Mēģini vēlreiz.");
                }
                LocalDateTime Obj = LocalDateTime.now();
                DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String time = Obj.format(formatObj);

                BufferedReader br = new BufferedReader(new FileReader("data/Students.csv"));
                String[] lines = new String[100];
                int count = 0;
                Boolean found = false;

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");

                    if (parts[3].equals(code)) {
                        lines[count++] = vards + "," + uzvards + "," + email + "," + code + "," + time;
                        found = true;
                    } else {
                        lines[count++] = line;
                    }
                }
                br.close();

                if (!found) {
                    System.out.println("Tāds skolēns neeksistē.");
                    return;
                }

                FileWriter fw = new FileWriter("data/Students.csv");
                for (int i = 0; i < count; i++) {
                    fw.write(lines[i] + "\n");
                }
                fw.close();

            } else {
                System.out.println("Nepareizi ierakstits personal kods.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
