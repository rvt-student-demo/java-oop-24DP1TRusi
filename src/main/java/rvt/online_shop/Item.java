package rvt.online_shop;

public class Item {
    private String product;
    private int price;
    private int quantity;

    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        this.price = unitPrice;
        this.quantity = qty;
    }

    public int price() {
        return this.price * this.quantity;
    }

    public void increaseQuantity() {
        this.quantity = this.quantity + 1;
    }

    public String toString() {
        return this.product + ": " + this.quantity;
    }
}
