package service;

import java.util.UUID;

public interface BaseService<T> {

    int add(T t);
    void remove(UUID id);
}
