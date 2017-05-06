package by.netcracker.artemyev.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class describes user
 * @autor Artemyev Artoym
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    private long id;
    private String login;
    private String password;
    private String mail;
    private Role role;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "login", nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "mail", nullable = false)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @ManyToOne
    @JoinColumn(name = "user_role_id", nullable = false)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User() {
        super();
    }

    public User(long id, String login, String password, String mail, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.role = role;
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
        User user = (User) object;
        if(this.getId() != user.getId()) {
            return false;
        }
        if(!this.getLogin().equals(user.getLogin())) {
            return false;
        }
        if(!this.getPassword().equals(user.getPassword())) {
            return false;
        }
        if(!this.getMail().equals(user.getMail())) {
            return false;
        }
        if(this.getRole() != user.getRole()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) this.getId() + 2;
        result += this.getLogin().hashCode();
        result += this.getPassword().hashCode();
        result += this.getMail().hashCode();
        result += this.getRole().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", role=" + role +
                '}';
    }
}
