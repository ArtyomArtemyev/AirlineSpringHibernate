package by.netcracker.artemyev.entity.impl;

import by.netcracker.artemyev.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order extends BaseEntity {
    private User user;
    private Flight flight;

    public Order() {
        super();
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Airplane{" + "id=" + this.getId() +
                ", idUser=" + getFlight() +
                ", idFlight=" + getUser() +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) (long) this.getId() + 2;
        result += this.getUser().hashCode();
        result += this.getFlight().hashCode();
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
        Order order = (Order) object;
        if(this.getId() != order.getId()) {
            return false;
        }
        if(this.getFlight() != order.getFlight()) {
            return false;
        }
        if(this.getUser() != order.getUser()) {
            return false;
        }
        return true;
    }


}
