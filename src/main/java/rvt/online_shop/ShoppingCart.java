package rvt.online_shop;

import java.util.HashMap;

public class ShoppingCart {
    public HashMap<String, Item> map;

    public ShoppingCart(){
        this.map = new HashMap<String, Item>();
    }

    public void add(String product, int price) {
        if (!this.map.containsKey(product)){
            this.map.put(product, new Item(product, 1, price));
        } else {
            this.map.get(product).increaseQuantity();
        }
    }

    public int price() {
        int i = 0;
        for (String n : this.map.keySet()) {
            i += this.map.get(n).price();
        }
        return i;
    }

    public void print() {
        for (String i : this.map.keySet()) {
            System.out.println(this.map.get(i).toString());
        }
    }
}
