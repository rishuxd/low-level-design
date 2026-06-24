package models;

public class MenuItem {
    private String code;
    private String name;
    private double price;

    public MenuItem(String code, String name, double price){
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    
    public String getCode(){
        return code;
    }

    public double getPrice(){
        return price;
    }
}
