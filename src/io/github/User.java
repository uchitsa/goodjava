package io.github;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
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
        Set<User> visited = new HashSet<>();
        Deque<User> frontier = new LinkedList<>();
        frontier.add(this);
        while (!frontier.isEmpty()) {
            User user = frontier.removeFirst();
            if (user.equals(other)) return true;
            if (visited.add(user)) {
                frontier.addAll(user.friends);
            }
        }
        return false;
    }
}
