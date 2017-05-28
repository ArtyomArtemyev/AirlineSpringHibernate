package by.netcracker.artemyev.entity.impl;

import by.netcracker.artemyev.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "airplane")
public class Airplane extends BaseEntity {
    private String model;
    private AirplaneTeam team;

    public Airplane() {
        super();
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    public AirplaneTeam getAirplaneTeam() {
        return team;
    }

    public void setAirplaneTeam(AirplaneTeam airplaneTeam) {
        this.team = airplaneTeam;
    }

    @Override
    public String toString() {
        return "Airplane{" + "id=" + this.getId() +
                ", model=" + model +
                ", team=" + team +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) (long) this.getId() + 2;
        result += this.getModel().hashCode();
        result += this.getAirplaneTeam().hashCode();
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
        Airplane airplane = (Airplane) object;
        if(this.getId() != airplane.getId()) {
            return false;
        }
        if(this.getAirplaneTeam() != airplane.getAirplaneTeam()) {
            return false;
        }
        if(this.getModel() != airplane.getModel()) {
            return false;
        }
        return true;
    }

}
