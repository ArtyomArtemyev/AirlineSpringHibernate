package by.netcracker.artemyev.entity.impl;

import by.netcracker.artemyev.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Class describes airplane team
 *
 * @autor Artemyev Artoym
 */
@Entity
@Table(name = "airplane_team")
public class AirplaneTeam extends BaseEntity {
    private String team;
    private List<Airplane> airplaneList;

    public AirplaneTeam() {
        super();
    }

    @Column(name = "team")
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @OneToMany(mappedBy = "airplaneTeam")
    public List<Airplane> getAirplaneList() {
        return airplaneList;
    }

    public void setAirplaneList(List<Airplane> airplaneList) {
        this.airplaneList = airplaneList;
    }

    @Override
    public String toString() {
        return "AirplaneTeam{" + "id=" + this.getId() +
                ", team=" + team +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) (long) this.getId() + 2;
        result += this.getTeam().hashCode();
        return result;
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
        AirplaneTeam team = (AirplaneTeam) object;
        if(this.getId() != team.getId()) {
            return false;
        }
        if(this.getTeam().equals(team.getTeam())) {
            return false;
        }
        return true;
    }

}
