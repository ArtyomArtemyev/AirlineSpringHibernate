package by.netcracker.artemyev.entity;

import by.netcracker.artemyev.enumeration.EnumGender;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @Column(name = "gender_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", updatable = false, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumGender gender;

    @OneToMany(mappedBy = "gender")
    private List<Employee> employeeList;

    public Gender() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EnumGender getGender() {
        return gender;
    }

    public void setGender(EnumGender gender) {
        this.gender = gender;
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
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Gender{");
        stringBuilder.append("id=").append(id);
        stringBuilder.append(", gender=").append(gender);
        stringBuilder.append(", employeeList=").append(employeeList);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
