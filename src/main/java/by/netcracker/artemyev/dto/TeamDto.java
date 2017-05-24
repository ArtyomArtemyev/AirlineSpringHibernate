package by.netcracker.artemyev.dto;

import by.netcracker.artemyev.entity.impl.Employee;

import java.util.List;

/**
 * Class describes team entity, which using for exchanges between components
 * @autor Artemyev Artoym
 */
public class TeamDto {
    private Long idTeam;
    private List<Employee> teamMembers;

    public TeamDto() {
        super();
    }

    public TeamDto(Long idTeam, List<Employee> listEmployee) {
        this.setIdTeam(idTeam);
        this.setTeamMembers(listEmployee);
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }

}
