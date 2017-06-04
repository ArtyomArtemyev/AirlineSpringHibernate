package by.netcracker.artemyev.service;

import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

/**
 * This interface describes common service
 *
 * @autor Artemyev Artoym
 */
public interface GeneralService<T> {

    /**
     * Create the given Entity
     *
     * @param  - entity to be created
     * @throws ServiceException - if fails with adding at Service layer
     */
    void add(T object) throws ServiceException;

    /**
     * Update the given Entity
     *
     * @param  - entity to be updated
     * @throws ServiceException - if fails with adding at Service layer
     */
    void update(T object) throws ServiceException;

    /**
     * Update the given Entity
     *
     * @param  - entity to be deleted
     * @throws ServiceException - if fails with adding at Service layer
     */
    void remove(T object) throws ServiceException;

    /**
     * Update the given Entity
     *
     * @param  - id of the Entity to be returned
     * @return - the Entity matching the given id
     * @throws ServiceException - if fails with adding at Service layer
     */
    T getById(Long id) throws ServiceException;

    /**
     * Returns a list of all Entities
     *
     * @return a list of all Entities
     * @throws ServiceException - if something fails at Service layer
     */
    List<T> getAll() throws ServiceException;
}
