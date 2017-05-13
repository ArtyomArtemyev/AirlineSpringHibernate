package by.netcracker.artemyev.entity.impl;

import by.netcracker.artemyev.entity.BaseEntity;
import by.netcracker.artemyev.enumeration.GenderType;

import javax.persistence.*;
import java.util.List;

/**
 * Class describes gender
 * @autor Artemyev Artoym
 */
@Entity
@Table(name = "gender")
public class Gender extends BaseEntity {
    private GenderType gender;
    private List<Employee> employeeList;

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

    public Gender(GenderType genderType) {
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
        result = (int) (long) this.getId() + 2;
        result += this.getGender().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Gender{" + "id=" + this.getId() +
                ", gender=" + gender +
                '}';
    }

}
