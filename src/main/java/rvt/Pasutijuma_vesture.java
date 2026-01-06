package rvt;

import java.io.File;
import java.util.Scanner;

public class Pasutijuma_vesture {
    public static void main(String[] args) {
        try (Scanner  reader = new Scanner(new File("data/orders.csv"))) {
            reader.nextLine();

            double summa = 0;
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                String[] parts = row.split(",");

                int orderID = Integer.valueOf(parts[0]);
                String customer = parts[1];
                String product = parts[2];
                int quantity = Integer.valueOf(parts[3]);
                double price = Double.valueOf(parts[4]);
                double kopa = price * quantity;

                System.out.println("Pasūtījums #" + orderID + ": " + customer + " pasūtīja " + quantity + " x " + product + " (" + price + " EUR) -> Kopā: " + kopa + " EUR");
                summa += kopa;
            }
            System.out.println("Kopējā pasūtījumu summa: " + summa + " EUR");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

