package by.netcracker.artemyev.entity.impl;

import by.netcracker.artemyev.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order extends BaseEntity {
    private User user;
    private Flight flight;
    private String name;
    private String surname;
    private String phone;
    private String mail;

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

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname", nullable = false)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "phone", nullable = false)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "mail", nullable = false)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + this.getId() +
                ", idUser=" + getFlight() +
                ", idFlight=" + getUser() +
                ", name=" + name +
                ", surname=" + surname +
                ", phone=" + phone +
                ", mail=" + mail +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) (long) this.getId() + 2;
        result += this.getUser().hashCode();
        result += this.getFlight().hashCode();
        result += this.getName().hashCode();
        result += this.getSurname().hashCode();
        result += this.getPhone().hashCode();
        result += this.getMail().hashCode();
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
        if(!this.getName().equals(order.getName())) {
            return false;
        }
        if(!this.getSurname().equals(order.getSurname())) {
            return false;
        }
        if(!this.getPhone().equals(order.getPhone())) {
            return false;
        }
        if(!this.getMail().equals(order.getMail())) {
            return false;
        }
        return true;
    }

}
