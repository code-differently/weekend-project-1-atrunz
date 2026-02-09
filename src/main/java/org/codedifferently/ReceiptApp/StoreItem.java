package org.codedifferently.ReceiptApp;

public class StoreItem{

    //instance variables
    String name;
    double price;
    int itemID;

    public StoreItem(int itemID, double price){
        this.price = price;
        this.itemID = itemID;
        switch (this.itemID){
            case 0:
                this.name = "TV";
                break;
            case 1:
                this.name = "iPhone";
                break;
            case 2:
                this.name = "PC";
                break;
            case 3:
                this.name = "Macbook";
                break;
            case 4:
                this.name = "ipad";
                break;
            case 5:
                this.name = "Surround Sound System";
                break;
            case 6:
                this.name = "PS5";
                break;
            case 7:
                this.name = "Meta Glasses";
                break;
            case 8:
                this.name = "Google Pixel";
                break;
            case 9:
                this.name = "Xbox Series X";
                break;
            default:
                this.name = "TV";

        }

    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

}
