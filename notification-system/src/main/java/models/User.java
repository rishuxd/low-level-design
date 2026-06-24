package models;

import java.util.HashSet;
import java.util.Set;

import enums.Channel;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private final String phone;
    private final String devToken;

    private Set<Channel> optedChannels = new HashSet<>();
    
    public User(String id, String name, String email, String phone, String devToken) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.devToken = devToken;
    }
    

    public void optIn(Channel channel) { optedChannels.add(channel); }
    public void optOut(Channel channel) { optedChannels.remove(channel); }
    public boolean isOpted(Channel channel) { return optedChannels.contains(channel); }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDevToken() { return devToken; }
}
