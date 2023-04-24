package service.user;

import model.User;
import repository.user.UserRepository;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class UserServiceImpl implements UserService {

   private static final UserServiceImpl instance = new UserServiceImpl();

    public static UserServiceImpl getInstance() {
        return instance;
    }

    UserRepository userRepository = UserRepository.getInstance();

    private UserServiceImpl() {
    }

    @Override
    public int add(User user) {
        if (checkUser(user.getUsername())) {
            return -1;
        }
        userRepository.add(user);
        return 1;
    }

    private boolean checkUser(String username) {
        ArrayList<User> users = userRepository.readFromFile();
               for (User user : users) {
            if (Objects.equals(user.getUsername(), username)){
                return true;
            }
        }
          return false;
    }

    @Override
    public void remove(UUID id) {


    }

    @Override
    public User singIn(String username, String password) {

        return null;
    }
}
