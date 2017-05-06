package by.netcracker.artemyev.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class describes flight
 * @autor Artemyev Artoym
 */
@Entity
@Table(name = "flight")
public class Flight implements Serializable {
    private long id;
    private String navigation;
    private Team team;

    @Id
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "navigation", nullable = false)
    public String getNavigation() {
        return navigation;
    }

    public void setNavigation(String navigation) {
        this.navigation = navigation;
    }

    @ManyToOne
    @JoinColumn(name = "team_id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Flight() {
        super();
    }

    public Flight(long id, String navigation, Team team) {
        this.id = id;
        this.navigation = navigation;
        this.team = team;
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
        Flight flight = (Flight) object;
        if(this.getId() != flight.getId()) {
            return false;
        }
        if(!this.getNavigation().equals(flight.getNavigation())) {
            return false;
        }
        if(this.getTeam() != flight.getTeam()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) this.getId() + 2;
        result += this.getNavigation().hashCode();
        result += this.getTeam().hashCode();
        return result;
    }

}
