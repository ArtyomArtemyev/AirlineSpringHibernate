package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.dao.TeamDao;
import by.netcracker.artemyev.entity.impl.Team;
import by.netcracker.artemyev.service.GenericService;
import by.netcracker.artemyev.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl extends GenericService<Team> implements TeamService{

    @Autowired
    private TeamDao teamDao;

}
