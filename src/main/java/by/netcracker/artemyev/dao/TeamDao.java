package by.netcracker.artemyev.dao;


import by.netcracker.artemyev.entity.Team;
import by.netcracker.artemyev.exception.DaoException;

public interface TeamDao extends GeneralDao<Team> {
    void add(Team object) throws DaoException;
    void update(Team object) throws DaoException;
    void remove(Team object) throws DaoException;
    Team getById(int id) throws DaoException;
}
