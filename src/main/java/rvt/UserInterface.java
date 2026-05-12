package rvt;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserInterface {
    private TodoList todo;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scan) {
        this.todo = list;
        this.scanner = scan;
    }

    public void start() {
        JFrame frame = new JFrame("Todo list.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        JTable table = todo.createTable();
        JScrollPane scrollpane = new JScrollPane(table);
        frame.add(scrollpane);
        frame.setVisible(true);

        while (true) {
            System.out.println("Command: ");
            String teksts = scanner.nextLine();

            if (teksts.equals("stop")) {
                break;

            } else if (teksts.equals("add")) {
                System.out.println("To add: ");
                this.todo.add(scanner.nextLine());
                frame.repaint();

            } else if (teksts.equals("list")) {
                todo.print();
                frame.repaint();

            } else if (teksts.equals("remove")) {
                System.out.println("Which one is removed?");
                int num = Integer.valueOf(scanner.nextLine());
                todo.remove(num);
                frame.repaint();
            }
        }
    }
}
