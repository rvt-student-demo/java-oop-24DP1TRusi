package rvt;

// import java.util.Scanner;
// import java.awt.Dimension;
// import java.awt.event.ActionEvent;
// import javax.swing.BoxLayout;
// import javax.swing.JButton;
import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JScrollPane;
// import javax.swing.JTable;
// import javax.swing.JTextField;

public class UserInterface {
    // private TodoList todo;
    // private Scanner scanner;
    private JFrame window;

    public UserInterface() {
        // this.todo = list;
        // this.scanner = scan;
        initialize();
    }

    private void initialize() {
        window = new JFrame("Todo App");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(500,400);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }

    public void show() {
        window.setVisible(true);
    }
    // public void start() {
    //     JFrame frame = new JFrame("Todo list.");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     JTable table = todo.createTable();
    //     JScrollPane scrollpane = new JScrollPane(table);
    //     scrollpane.setPreferredSize(new Dimension(1000, 400));

    //     JPanel p = new JPanel();
    //     p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
    //     JTextField field = new JTextField(10);
    //     JButton button = new JButton("Add");
    //     JButton remButton = new JButton("Remove");
    //     p.add(scrollpane);
    //     JPanel inputPanel = new JPanel();
    //     inputPanel.add(field);
    //     inputPanel.add(button);
    //     inputPanel.add(remButton);
    //     p.add(inputPanel);
    //     frame.add(p);

    //     frame.setSize(400, 400);
    //     frame.setVisible(true);

        // while (true) {
        //     System.out.println("Command: ");
        //     String teksts = scanner.nextLine();

        //     if (teksts.equals("add")) {
        //     System.out.println("To add: ");
        //     this.todo.add(scanner.nextLine());
            // button.addActionListener(new ActionListener() {
            //     public void actionPerformed(ActionEvent e) {
            //         System.out.println("Button clicked");
            //     }
        //     });

        //     table = todo.createTable();
        //     scrollpane = new JScrollPane(table);
        //     p.add(scrollpane);
        //     frame.add(p);
        //     frame.setVisible(true);

        //     if (teksts.equals("list")) {
        //         todo.print();
        //     }

        //     if (teksts.equals("remove")) {
        //         System.out.println("Which one is removed?");
        //         int num = Integer.valueOf(scanner.nextLine());
        //         todo.remove(num);

        //         table = todo.createTable();
        //         scrollpane = new JScrollPane(table);
        //         frame.add(scrollpane);
        //         frame.setVisible(true);
        //     }
        // }
    // }
}
