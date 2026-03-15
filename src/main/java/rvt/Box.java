package rvt;

import java.util.ArrayList;

public class Box implements Packable{
    private ArrayList<Packable> box;
    private double cap;

    public Box(double cap) {
        this.box = new ArrayList<>();
        this.cap = cap;
    }

    public void add(Packable item) {
        if (item.weight() + weight() <= this.cap) {
            box.add(item);
        }
    }

    public double weight() {
        double weight = 0;
        for (Packable item : box) {
            weight += item.weight();
        }
        return weight;
    }

    public String toString() {
        return "Box: " + this.box.size() + " items, total weight " + weight() + " kg";
    }
}
