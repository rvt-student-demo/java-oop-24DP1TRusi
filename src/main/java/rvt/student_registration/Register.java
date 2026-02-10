package rvt.student_registration;

// import java.io.BufferedReader;
import java.io.BufferedWriter;
// import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Register {
    private final String filePath = "data/Students.csv";
    private ArrayList<String> list;

    public Register() {
        this.list = new ArrayList<>();
        // loadFromFile();
    }

    // private void loadFromFile() {
    //     try (BufferedReader br = new BufferedReader(new FileReader("Students.csv"))) {
    //         String line;
    //         while ((line = br.readLine()) != null) {
    //             this.list.add(line);
    //         }
    //     } catch (IOException e) {
    //         System.out.println("Error reading file.");
    //     }
    // }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        Requirements i = new Requirements();
        try (BufferedWriter wr = new BufferedWriter(new FileWriter("data/Students.csv", true))) {
            System.out.println("Studenta vārds:");
            String input1 = scanner.nextLine();
            String name = input1.trim();
            if (i.checkVards(name) == true) {
                wr.write(name + ",");
            } else {
                System.out.println("Nederīga ievade!");
            }

            System.out.println("Studenta uzvārds:");
            String input2 = scanner.nextLine();
            String surname = input2.trim();
            if (i.checkUzvards(surname)) {
                wr.write(surname + ",");
            } else {
                System.out.println("Nederīga ievade!");
            }

            System.out.println("Studenta e-pasts:");
            String input3 = scanner.nextLine();
            String email = input3.trim();
            if (i.CheckEmail(email)) {
                wr.write(email + ",");
            } else {
                System.out.println("Nederīga ievade!");
            }

            System.out.println("Studenta parsonas kods:");
            String input4 = scanner.nextLine();
            String code = input4.trim();
            if (i.CheckCode(code)) {
                wr.write(code + ",");
            } else {
                System.out.println("Nederīga ievade!");
            }

            LocalDateTime Obj = LocalDateTime.now();
            DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String time = Obj.format(formatObj);
            wr.write(time);
            wr.newLine();

            this.list.add(name + "," + surname + "," + email + "," + code + "," + time);
            scanner.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }
}
