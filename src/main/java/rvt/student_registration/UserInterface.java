package rvt.student_registration;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    // private ArrayList<String> list;

    public UserInterface( Scanner scan) {
        this.scanner = scan;
        // this.list = new ArrayList<>();
        // loadFromFile();
    
    }

    public void start() {
        final Register register = new Register();

        while (true) {
            System.out.println("Izvēlies, ko gribi darīt. (register; show; remove; edit; exit)");
            System.out.println("Komanda: ");
            String teksts = scanner.nextLine();
            
            if (teksts.equals("exit")) {
                break;

            } else if (teksts.equals("register")) {
                register.addStudent();

            } else if (teksts.equals("show")) {
                // todo.print();

            } else if (teksts.equals("remove")) {
                System.out.println("Kuru noņemt?");
                // int num = Integer.valueOf(scanner.nextLine());
                // todo.remove(num);
            } else if (teksts.equals("edit")) {
                System.out.println("Kuru rediģēt?");

            }

        }
    }

    // private void loadFromFile() {
    //     try (BufferedReader br = new BufferedReader(new FileReader("data/todo.csv"))) {
    //         String line;
    //         while ((line = br.readLine()) != null) {
    //             this.list.add(line);
    //         }
    //     } catch (IOException e) {
    //         System.out.println("Error reading file.");
    //     }
    // }
}
