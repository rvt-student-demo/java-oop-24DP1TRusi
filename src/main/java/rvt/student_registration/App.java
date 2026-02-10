package rvt.student_registration;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface user = new UserInterface(scanner);
        user.start(); 
    }
}
