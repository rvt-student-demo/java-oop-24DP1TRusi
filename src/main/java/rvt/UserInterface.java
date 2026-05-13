package rvt;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class UserInterface {
    private TodoList todo;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scan) {
        this.todo = list;
        this.scanner = scan;
    }

    public void start() {
        JFrame frame = new JFrame("Todo list.");
        JPanel p = new JPanel();
        JTextField field = new JTextField(10);
        JButton button = new JButton("Add");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JTable table = todo.createTable();
        JScrollPane scrollpane = new JScrollPane(table);
        p.add(scrollpane);
        p.add(field);
        p.add(button);
        frame.add(p);
        frame.setVisible(true);

        while (true) {
            System.out.println("Command: ");
            String teksts = scanner.nextLine();

            // if (teksts.equals("add")) {
            // System.out.println("To add: ");
            // this.todo.add(scanner.nextLine());
            // // button.addActionListener(new ActionListener() {
            //     public void actionPerformed(ActionEvent e) {
            //         System.out.println("Button clicked");
            //     }
            // });

            table = todo.createTable();
            scrollpane = new JScrollPane(table);
            p.add(scrollpane);
            frame.add(p);
            frame.setVisible(true);

            if (teksts.equals("list")) {
                todo.print();

            } else if (teksts.equals("remove")) {
                System.out.println("Which one is removed?");
                int num = Integer.valueOf(scanner.nextLine());
                todo.remove(num);

                table = todo.createTable();
                scrollpane = new JScrollPane(table);
                frame.add(scrollpane);
                frame.setVisible(true);
            }
        }
    }
}
