package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.entity.impl.Team;
import by.netcracker.artemyev.exception.DaoException;

import java.util.List;

/**
 * Interface describes dao layer for entity Team
 *
 * @autor Artemyev Artoym
 */
public interface TeamDao extends GeneralDao<Team> {
    List<Team> getAll() throws DaoException;
}
