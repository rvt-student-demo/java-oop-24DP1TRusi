package rvt.student_registration;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    final Register register;
    final Remove remove;
    final Show show;
    final Requirements i;
    final Edit edit;

    public UserInterface() {
        this.register = new Register();
        this.remove = new Remove();
        this.show = new Show();
        this.i = new Requirements();
        this.edit = new Edit();
    }

    public void start() {

        while (true) {
            System.out.println("Izvēlies, ko gribi darīt. (register; show; remove; edit; exit)");
            System.out.println("Komanda: ");
            String teksts = scanner.nextLine();

            if (teksts.equals("exit")) {
                break;

            } else if (teksts.equals("register")) {
                register.addStudent(scanner);

            } else if (teksts.equals("show")) {
                show.ShowStudents();

            } else if (teksts.equals("remove")) {
                System.out.println("Kuru noņemt? (ievadi personas kodu)");
                String code = scanner.nextLine();
                if (i.CheckCode(code)) {
                    remove.removeStudent(code);
                } else {
                    System.out.println("Nepareizi ievadīts kods!");
                }

            } else if (teksts.equals("edit")) {
                edit.editStudent(scanner);

            } else {
                System.out.println("Tāda komanda nepastāv!");
            }

        }
    }
}
