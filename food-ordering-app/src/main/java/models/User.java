package models;

public class User {
    private int userId;
    private String name;
    private String add;
    private Cart cart;

    public User(int userId, String name, String add){
        this.userId = userId;
        this.name = name;
        this.add = add;
        this.cart = new Cart();
    }
    
    public int getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }

    public String getAdd(){
        return add;
    }

    public void addCart(Cart cart){
        this.cart = cart;
    }

    public Cart getUserCart(){
        return cart;
    }
}
