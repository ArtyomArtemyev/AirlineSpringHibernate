package by.netcracker.artemyev.entity;

import by.netcracker.artemyev.enumeration.GenderType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Class describes gender
 * @autor Artemyev Artoym
 */
@Entity
@Table(name = "gender")
public class Gender implements Serializable {
    private long id;
    private GenderType gender;
    private List<Employee> employeeList;

    @Id
    @Column(name = "gender_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    @OneToMany(mappedBy = "gender")
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Gender() {
        super();
    }

    public Gender(long id, GenderType genderType) {
        this.id = id;
        this.gender = genderType;
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
        Gender gender = (Gender) object;
        if(this.getId() != gender.getId()) {
            return false;
        }
        if(this.getGender() != gender.getGender()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) this.getId() + 2;
        result += this.getGender().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Gender{" + "id=" + id +
                ", gender=" + gender +
                '}';
    }

}
