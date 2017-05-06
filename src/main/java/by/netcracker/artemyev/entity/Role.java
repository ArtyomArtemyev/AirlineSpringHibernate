package by.netcracker.artemyev.entity;

import by.netcracker.artemyev.enumeration.RoleType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Class describes role of users
 * @autor Artemyev Artoym
 */
@Entity
@Table(name = "user_role")
public class Role implements Serializable {
    private long id;
    private RoleType roleType;
    private List<User> userList;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", updatable = false, nullable = false)
    @Enumerated(EnumType.STRING)
    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    @OneToMany(mappedBy = "role")
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Role() {
        super();
    }

    public Role(long id, RoleType roleType) {
        this.id = id;
        this.roleType = roleType;
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
        if(this.getRoleType() != role.getRoleType()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) this.getId() + 2;
        result += this.getRoleType().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id +
                ", roleType=" + roleType +
                '}';
    }

}
