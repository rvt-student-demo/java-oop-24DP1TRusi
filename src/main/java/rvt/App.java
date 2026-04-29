package rvt;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java grafika!!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024,768);

        GrafikasPanelis grafika = new GrafikasPanelis();
        frame.add(grafika);
        frame.setVisible(true);
    }
}
