package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.TeamDao;
import by.netcracker.artemyev.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("teamService")
public class TeamService extends GenericService<Team> {

    @Autowired
    private TeamDao teamDao;

}
