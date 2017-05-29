package by.netcracker.artemyev.entity.impl;

import by.netcracker.artemyev.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Class describes flight
 * @autor Artemyev Artoym
 */
@Entity
@Table(name = "flight")
public class Flight extends BaseEntity {
    private String navigation;
    private Team team;
    private Airplane airplane;
    private List<Order> orderList;

    public Flight() {
        super();
    }

    public Flight(String navigation, Team team) {
        this.navigation = navigation;
        this.team = team;
    }

    @Column(name = "navigation", nullable = false)
    public String getNavigation() {
        return navigation;
    }

    public void setNavigation(String navigation) {
        this.navigation = navigation;
    }

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    @ManyToOne
    @JoinColumn(name = "team_id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @OneToMany(mappedBy = "flight")
    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
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
    public String toString() {
        return "Flight{" + "id=" + this.getId() +
                ", navigation=" + navigation + '\'' +
                ", team=" + team +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) (long) this.getId() + 2;
        result += this.getNavigation().hashCode();
        result += this.getTeam().hashCode();
        return result;
    }


}
