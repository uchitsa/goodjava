package io.github;

import java.util.HashSet;
import java.util.Set;

public class User {

    private String name;
    private Set<User> friends = new HashSet<>();

    public User(String name) {
        this.name = name;
    }

    public void befriend(User other) {
        friends.add(other);
    }

    public boolean isDirectFriendOf(User other) {
        return friends.contains(other);
    }

    public boolean isIndirectFriendOf(User other) {
        for (User friend : other.friends) {
            if (friend.isDirectFriendOf(this)) return true;
        }
        return false;
    }
}
