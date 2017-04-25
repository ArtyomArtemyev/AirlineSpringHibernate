package by.netcracker.artemyev.entity;

import by.netcracker.artemyev.enumeration.EnumRole;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_role")
public class Role {

    @Id
    @Column(name = "user_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", updatable = false, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumRole enumRole;

    @OneToMany(mappedBy = "role")
    private List<User> userList;

    public Role() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EnumRole getEnumRole() {
        return enumRole;
    }

    public void setEnumRole(EnumRole enumRole) {
        this.enumRole = enumRole;
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
        Role role = (Role) object;
        if(this.getId() != role.getId()) {
            return false;
        }
        if(this.getEnumRole() != role.getEnumRole()) {
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
        final StringBuilder stringBuilder = new StringBuilder("Role{");
        stringBuilder.append("id=").append(id);
        stringBuilder.append(", enumRole=").append(enumRole);
        stringBuilder.append(", userList=").append(userList);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
