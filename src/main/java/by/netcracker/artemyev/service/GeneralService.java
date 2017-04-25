package by.netcracker.artemyev.service;

import java.util.List;

public interface GeneralService<T> {
    void add(T object);
    void update(T object);
    void remove(T object);
    T getById(int id);
    List<T> getAll();
}
