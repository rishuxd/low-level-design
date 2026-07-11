package models;

import enums.UserTier;

public class User {
    private String id;
    private UserTier tier;

    public User(String id, UserTier tier) {
        this.id = id;
        this.tier = tier;
    }

    public String getUserId() {
        return id;
    }

    public UserTier getUserTier() {
        return tier;
    }
}
