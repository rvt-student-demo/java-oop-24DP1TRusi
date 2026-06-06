package rvt;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.plaf.DimensionUIResource;

public class TodoList {
    private ArrayList<String[]> todo;
    private TodoDB db;

    public TodoList() {
        this.db = new TodoDB();
        this.todo = db.findAll();
    }

    public void add(String task) {
        String input = task.trim();

        if (!input.isEmpty() && checkEventString(input)) {
            db.add(input);
            update();
        } else {
            System.out.println("Invalid input: " + input);
        }
    }

    public void update() {
        todo = db.findAll();
    }

    public void remove(int id) {
        db.removeById(id);
        update();
    }

    public boolean checkEventString(String value) {
        final String regex = "^[a-zA-Z0-9 ]+$";
        if (value.length() < 3) {
            return false;
        } else {
            return value.matches(regex);
        }
    }

    public JTable createTable() {
        if (todo == null || todo.isEmpty()) {
            String[] columnName = { "ID", "Task" };
            return new JTable(new Object[0][columnName.length], columnName);
        }
        String[][] data = new String[todo.size()][];
        for (int i = 0; i < todo.size(); i++) {
            data[i] = todo.get(i).clone();
        }

        String[] columnName = { "ID", "Task" };
        JTable table = new JTable(data, columnName);
        table.setPreferredScrollableViewportSize(new DimensionUIResource(450, 50));
        table.setFillsViewportHeight(true);
        return table;
    }
}
