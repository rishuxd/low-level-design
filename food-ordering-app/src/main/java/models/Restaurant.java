package models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private static int nextResId = 0;
	private int resId;
	private String name;
	private String location;
	private List<MenuItem> menu = new ArrayList<>();

	public Restaurant(String name, String location){
		this.name = name;
		this.location = location;
		this.resId = ++nextResId;
	}
    public int getResId(){
        return resId;
    }

	public String getName(){
		return name;
	}

    public String getLocation(){
        return location;
    }

    public List<MenuItem> getMenu(){
        return menu;
    }

    public void addMenuItem(MenuItem item){
        menu.add(item);
    }
}
