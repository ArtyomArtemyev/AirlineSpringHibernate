package by.netcracker.artemyev.entity.impl;

import by.netcracker.artemyev.entity.BaseEntity;
import by.netcracker.artemyev.enumeration.AppointmentType;

import javax.persistence.*;
import java.util.List;

/**
 * Class describes appointment of employee
 * @autor Artemyev Artoym
 */
@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity {
    private AppointmentType appointment;
    private List<Employee> employeeList;

    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    public AppointmentType getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentType appointment) {
        this.appointment = appointment;
    }

    @OneToMany(mappedBy = "appointment")
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Appointment() {
        super();
    }

    public Appointment(Long id, AppointmentType appointment) {
        this.setId(id);
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
        Appointment appointment = (Appointment) object;
        if(this.getId() != appointment.getId()) {
            return false;
        }
        if(this.getAppointment() != appointment.getAppointment()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) (long) this.getId() + 2;
        result += this.getAppointment().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Appointment{" + "id=" + this.getId() +
                ", appointment=" + appointment +
                '}';
    }

}
