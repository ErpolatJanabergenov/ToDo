package repository.user;

import model.User;
import repository.BaseRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class UserRepository implements BaseRepository<User> {

    private static final UserRepository instance = new UserRepository();

    public static UserRepository getInstance() {
        return instance;
    }

    private UserRepository() {
    }

    String usersPath = "C:\\Users\\User\\IdeaProjects\\ToDo\\src\\resoursec\\User.json";
    @Override
    public int add(User user) {
        ArrayList<User> users = readFromFile();
        users.add(user);
        writeToFile(users);
        return 1;
    }


    public User findByUsername(String username) {
        ArrayList<User> users = readFromFile();
        for (User user : users) {
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
      return null;
    }


    @Override
    public void writeToFile(ArrayList<User> users) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(usersPath))){
            objectOutputStream.writeObject(users + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<User> readFromFile()  {
       try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(usersPath))) {

           return (ArrayList<User>) objectInputStream.readObject();
       }
       catch (EOFException e){
           return new ArrayList<>(1);
       }
       catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
