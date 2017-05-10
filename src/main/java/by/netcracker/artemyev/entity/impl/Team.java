package by.netcracker.artemyev.entity.impl;

import by.netcracker.artemyev.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Class describes employee team for flight
 * @autor Artemyev Artoym
 */
@Entity
@Table(name = "team")
public class Team extends BaseEntity {
    private String idMembers;
    private List<Flight> flightList;

    @Column(name = "id_members", nullable = false)
    public String getIdMembers() {
        return idMembers;
    }

    public void setIdMembers(String idMembers) {
        this.idMembers = idMembers;
    }

    @OneToMany(mappedBy = "team")
    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public Team() {
        super();
    }

    public Team(long id, String idMembers) {
        this.setId(id);
        this.idMembers = idMembers;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Team team = (Team) object;
        if(this.getId() != team.getId()) {
            return false;
        }
        if(!this.getIdMembers().equals(team.getIdMembers())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) (long) this.getId() + 2;
        result += this.getIdMembers().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Team{" + "id=" + this.getId() +
                ", idMembers='" + idMembers +
                '}';
    }

}
