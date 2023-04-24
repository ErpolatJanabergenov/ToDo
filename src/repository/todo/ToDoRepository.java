package repository.todo;

import model.ToDo;
import model.User;
import repository.BaseRepository;
import service.todo.ToDoServiceImpl;

import java.io.*;
import java.util.ArrayList;

public class ToDoRepository implements BaseRepository<ToDo> {

    private static final ToDoRepository instance = new ToDoRepository();

    public static ToDoRepository getInstance() {
        return instance;
    }
   private ToDoRepository() {
    }

    String toDoPath = "C:\\Users\\User\\IdeaProjects\\ToDo\\src\\resoursec\\ToDo.txt";

    @Override
    public int add(ToDo toDo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toDoPath))){
            writer.write(toDo.toString());
            return 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeToFile(ArrayList<ToDo> toDos) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(toDoPath))){
            objectOutputStream.writeObject(toDos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<ToDo> readFromFile() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(toDoPath))) {
            return (ArrayList<ToDo>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
