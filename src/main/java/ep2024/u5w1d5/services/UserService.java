package ep2024.u5w1d5.services;

import ep2024.u5w1d5.entities.User;
import ep2024.u5w1d5.exceptions.DuplicateItemException;
import ep2024.u5w1d5.exceptions.ItemNotFoundException;
import ep2024.u5w1d5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        if (userRepository.existsByUsername((user.getUsername()))) {
            throw new DuplicateItemException(user.getUsername());
        }
        if (userRepository.existsByEmail((user.getEmail()))) {
            throw new DuplicateItemException(user.getUsername());
        }
        System.out.println("User " + user.getUsername() + " created successfully!");
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> filterByUsername(String username) {
        List<User> users = userRepository.findByUsernameStartingWithIgnoreCase(username);
        if (users.isEmpty()) {
            throw new ItemNotFoundException(username);
        }
        return users;
    }

    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public void findByIdAndDelete(long id) {
        User found = this.findById(id);
        userRepository.delete(found);
        System.out.println("User with id " + id + "deleted!");
    }

    public void findByIdAndUpdate(long id, User updatedUser) {
        User found = this.findById(id);
        found.setUsername(updatedUser.getUsername());
        found.setFullname(updatedUser.getFullname());
        found.setEmail(updatedUser.getEmail());

        userRepository.save(found);
        System.out.println("User with id " + id + "updated successfully!");
    }
}
