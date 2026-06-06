package rvt;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class UserInterface {
    private TodoList todo;
    private JFrame window;

    public UserInterface(TodoList list) {
        this.todo = list;
        initialize();
    }

    private void initialize() {
        window = new JFrame("Todo App");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(500, 400);
        window.setResizable(true);
        window.setLocationRelativeTo(null);
        BorderLayout layout = new BorderLayout();
        window.setLayout(layout);

        JPanel panel = new JPanel();
        JTable table = todo.createTable();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1));

        // add
        JPanel addPanel = new JPanel();
        JTextField addTf = new JTextField(10);
        JButton addBtn = new JButton("Add");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                todo.add(addTf.getText());
                table.setModel(todo.createTable().getModel());
                table.revalidate();
                table.repaint();
                addTf.setText("");
            }
        });

        // remove
        JPanel removePanel = new JPanel();
        JTextField removeTf = new JTextField(3);
        JButton removeBtn = new JButton("Remove");

        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    todo.remove(Integer.parseInt(removeTf.getText()));
                    table.setModel(todo.createTable().getModel());
                    table.revalidate();
                    table.repaint();
                    removeTf.setText("");
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid ID: " + removeTf.getText());
                }
            }
        });

        addPanel.add(addTf);
        addPanel.add(addBtn);
        removePanel.add(removeTf);
        removePanel.add(removeBtn);

        inputPanel.add(addPanel);
        inputPanel.add(removePanel);

        window.add(panel, BorderLayout.CENTER);
        window.add(inputPanel, BorderLayout.SOUTH);
    }

    public void show() {
        window.setVisible(true);
    }
}
