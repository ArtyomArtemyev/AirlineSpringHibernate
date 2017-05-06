package by.netcracker.artemyev.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class describes employee
 * @autor Artemyev Artoym
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    private long id;
    private String name;
    private String surname;
    private Gender gender;
    private Appointment appointment;

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @ManyToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Employee() {
        super();
    }

    public Employee(long id, String name, String surname, Gender gender, Appointment appointment) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.appointment = appointment;
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
        Employee employee = (Employee) object;
        if(this.getId() != employee.getId()) {
            return false;
        }
        if(this.getAppointment() != employee.getAppointment()) {
            return false;
        }
        if(this.getGender() != employee.getGender()) {
            return false;
        }
        if(!this.getName().equals(employee.getName())) {
            return false;
        }
        if(!this.getSurname().equals(employee.getSurname())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) this.getId() + 2;
        result += this.getName().hashCode();
        result += this.getSurname().hashCode();
        result += this.getAppointment().hashCode();
        result += this.getGender().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +  + '\'' +
                ", appointment=" + appointment +
                '}';
    }

}
