package rvt;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> todo;

    public TodoList () {
        this.todo = new ArrayList<>();
    }

    public void add(String task) {
        this.todo.add(task);
    }

    public void print() {
        for (int i = 0; i < todo.size(); i++) {
            int num = i + 0;
            System.out.println((num + 1) + ":" + todo.get(i));
        }
    }
    public void remove(int number) {
        this.todo.remove(number - 1);
    }
}
