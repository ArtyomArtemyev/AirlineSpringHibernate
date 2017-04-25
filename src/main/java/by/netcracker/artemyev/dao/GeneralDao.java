package by.netcracker.artemyev.dao;

import java.util.List;

public interface GeneralDao<T> {
    void add(T object);
    void update(T object);
    void remove(T object);
    T getById(int id);
    List<T> getAll();
}
