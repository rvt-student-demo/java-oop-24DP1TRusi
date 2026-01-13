package rvt;

import java.util.Scanner;

public class UserInterface {
    private TodoList todo;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scan) {
        this.todo = list;
        this.scanner = scan;
    }

    public void start() {

        while (true) {
            System.out.println("Command: ");
            String teksts = scanner.nextLine();
            
            if (teksts.equals("stop")) {
                break;

            } else if (teksts.equals("add")) {
                System.out.println("To add: ");
                this.todo.add(scanner.nextLine());

            } else if (teksts.equals("list")) {
                todo.print();

            } else if (teksts.equals("remove")) {
                System.out.println("Which one is removed?");
                int num = Integer.valueOf(scanner.nextLine());
                todo.remove(num);
            }

        }
    }
}
