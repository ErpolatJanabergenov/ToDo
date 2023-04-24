import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.User;
import repository.user.UserRepository;
import service.todo.ToDoService;
import service.todo.ToDoServiceImpl;
import service.user.UserService;
import service.user.UserServiceImpl;

import java.io.*;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static String path = "C:\\Users\\User\\IdeaProjects\\ToDo\\src\\resoursec\\User.json";

    static UserService userService = UserServiceImpl.getInstance();
    static ToDoService toDoService = ToDoServiceImpl.getInstance();
    static Gson gson = new GsonBuilder()
            .setPrettyPrinting().create();

    static Scanner scanStr = new Scanner(System.in);
    static Scanner scanNum = new Scanner(System.in);

    public static void main(String[] args)  {

        User user = new User("Erpolat", "erpo", "erpo");
//        User user2 = new User("Ulug'bek", "ulug'", "111");
//        User user3 = new User("Jake", "jake", "222");
//
//        userService.add(user);


//        writWithGson(user);


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
//            StringBuilder sb = new StringBuilder();
//            bufferedReader.lines().forEach(sb::append);
//            User user1 = gson.fromJson(sb.toString(), User.class);
            ArrayList<User> users = gson.fromJson(bufferedReader, new TypeToken<ArrayList<User>>() {});

            System.out.println(users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void writWithGson(User user) {


        String json = gson.toJson(user);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(json);

    }
}

//  }

//        int cm = 0;
//
//        while (true) {
//            System.out.println("1. Sign in\t2. Sign up\t0. Exit");
//            cm = scanNum.nextInt();
//            switch (cm) {
//                case 1 -> {
//                    signIn();
//                }
//                case 2 -> {
//                    signUp();
//                }
//                case 0 -> {
//                    return;
//                }
//                default -> {
//                    System.out.println("Wrong input");
//                    return;
//                }
//            }
//        }
//
//
//    }
//
//    private static void signUp() {
//        System.out.print("Enter name: ");
//        String name = scanStr.nextLine();
//
//        System.out.print("Enter username: ");
//        String username = scanStr.nextLine();
//
//        System.out.print("Enter password: ");
//        String password = scanStr.nextLine();
//
//        User user = new User(name,username,password);
//
//        if (userService.add(user) == 1) {
//            System.out.println("✔✔✔✔✔");
//        }else {
//            System.out.println("Bunaqa user oldindan bor");
//        }
//
//
//    }
//
//    private static void signIn() {
//        System.out.print("Enter username: ");
//        String username = scanStr.nextLine();
//
//        System.out.print("Enter password: ");
//        String password = scanStr.nextLine();
//
//        User user = userService.singIn(username, password);
//
//
//
//    }
//
//    }

