package models;

public class User {
    private String id;
    private String tier;

    public User(String id, String tier) {
        this.id = id;
        this.tier = tier;
    }

    public String getUserId() {
        return id;
    }

    public String getUserTier() {
        return tier;
    }
}
