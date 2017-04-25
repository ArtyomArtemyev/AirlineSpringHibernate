package by.netcracker.artemyev.entity;

import by.netcracker.artemyev.enumeration.EnumAppointment;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @Column(name = "appointment_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", updatable = false, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumAppointment appointment;

    @OneToMany(mappedBy = "appointment")
    private List<Employee> employeeList;

    public Appointment() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EnumAppointment getAppointment() {
        return appointment;
    }

    public void setAppointment(EnumAppointment appointment) {
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
        result = (int) this.getId() + 2;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Appointment{");
        stringBuilder.append("id=").append(id);
        stringBuilder.append(", appointment=").append(appointment);
        stringBuilder.append(", employeeList=").append(employeeList);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

}
