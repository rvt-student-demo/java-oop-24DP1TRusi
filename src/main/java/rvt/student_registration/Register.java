package rvt.student_registration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Register {
    String filePath = "data/Students.csv";
    Requirements i;

    public Register() {
        i = new Requirements();
    }

    public void addStudent(Scanner scanner) {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter("data/Students.csv", true))) {
            while (true) {
                System.out.print("Studenta vārds:");
                String input1 = scanner.nextLine();
                String vards = input1.trim();
                if (i.checkVards(vards)) {
                    wr.write(vards + ",");
                    break;
                }
                System.out.print("Vārds nav pareizs. Mēģini vēlreiz.");
            }

            while (true) {
                System.out.print("Studenta uzvārds:");
                String input2 = scanner.nextLine();
                String uzvards = input2.trim();
                if (i.checkUzvards(uzvards)) {
                    wr.write(uzvards + ",");
                    break;
                }
                System.out.print("Uzvārds nav pareizs. Mēģini vēlreiz.");
            }

            while (true) {
                System.out.print("Studenta epasts:");
                String input3 = scanner.nextLine();
                String email = input3.trim();
                if (emailAlreadyExists(email)) {
                    System.out.println("Šāds epasts jau pastāv.");
                    continue;
                }
                if (i.CheckEmail(email)) {
                    wr.write(email + ",");
                    break;
                }
                System.out.print("Epasts nav pareizs. Mēģini vēlreiz.");
            }

            while (true) {
                System.out.print("Studenta personas kods:");
                String input4 = scanner.nextLine();
                String code = input4.trim();
                if (codeAlreadyExists(code)) {
                    System.out.println("Šāds personas kods jau pastāv.");
                    continue;
                }
                if (i.CheckCode(code)) {
                    wr.write(code + ",");
                    break;
                }
                System.out.print("Personas kods nav pareizs. Mēģini vēlreiz.");
            }

            LocalDateTime Obj = LocalDateTime.now();
            DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String time = Obj.format(formatObj);
            wr.write(time);
            wr.newLine();

            System.out.println("Students veiksmīgi pievienots!");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

    public boolean codeAlreadyExists(String code) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/Students.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts[3].equals(code)) {
                    br.close();
                    return true;
                }
            }
            br.close();
            return false;

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            return false;
        }

    }

    public boolean emailAlreadyExists(String email) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/Students.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts[2].equals(email)) {
                    br.close();
                    return true;
                }
            }
            br.close();
            return false;

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            return false;
        }

    }
}
