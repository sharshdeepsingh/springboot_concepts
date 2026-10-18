
package org.sharshdeep.service;

import org.sharshdeep.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private final Map<Integer, User> userDB = new HashMap<>();

    // Create user
    public User createUser(User user) {
        userDB.put(user.getId(), user);
        return user;
    }

    // Get user by ID
    public User getUserById(Integer id) {
        return userDB.get(id);
    }

    // Get all users
    public List<User> getAllUser() {
        return new ArrayList<>(userDB.values());
    }

    // Update user
    public User updateUser(User user) {
        if (!userDB.containsKey(user.getId())) {
            return null;
        }

        userDB.put(user.getId(), user);
        return user;
    }

    // Delete user
    public boolean deleteUser(Integer id) {
        return userDB.remove(id) != null;
    }
}
