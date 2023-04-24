package repository;

import java.util.ArrayList;

public interface BaseRepository<T> {


    int add(T t);
    void writeToFile(ArrayList<T> t);
    ArrayList<T> readFromFile() throws RuntimeException;
}
