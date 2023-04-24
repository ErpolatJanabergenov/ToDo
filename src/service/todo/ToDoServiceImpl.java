package service.todo;

import model.ToDo;
import repository.todo.ToDoRepository;

import java.util.Objects;
import java.util.UUID;

public class ToDoServiceImpl implements ToDoService{

    private static final ToDoServiceImpl instance  = new ToDoServiceImpl();

    public static ToDoServiceImpl getInstance() {
        return instance;
    }

    private ToDoServiceImpl() {
    }

    @Override
    public int add(ToDo toDo) {
        return 1;
    }

    @Override
    public void remove(UUID userId) {



    }
}
