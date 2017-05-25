package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.entity.impl.Team;
import by.netcracker.artemyev.exception.DaoException;

import java.util.List;

/**
 * @autor Artemyev Artoym
 */
public interface TeamDao extends GeneralDao<Team> {
    List<Team> getAll() throws DaoException;
}
