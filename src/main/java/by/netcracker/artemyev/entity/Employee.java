package by.netcracker.artemyev.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", updatable = false, nullable = false)
    private String name;

    @Column(name = "surname", updatable = false, nullable = false)
    private String surname;

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;

    public Employee() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
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
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Employee{");
        stringBuilder.append("id=").append(id);
        stringBuilder.append(", name='").append(name).append('\'');
        stringBuilder.append(", surname='").append(surname).append('\'');
        stringBuilder.append(", gender=").append(gender);
        stringBuilder.append(", appointment=").append(appointment);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

}
