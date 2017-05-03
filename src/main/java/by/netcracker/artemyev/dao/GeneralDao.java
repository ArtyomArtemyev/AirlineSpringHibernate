package by.netcracker.artemyev.dao;

/**
 * Interface describes common dao
 * @autor Artemyev Artoym
 */
public interface GeneralDao<T> {
    void add(T object);
    void update(T object);
    void remove(T object);
}
