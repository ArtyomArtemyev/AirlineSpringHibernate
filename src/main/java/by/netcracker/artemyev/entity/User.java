package by.netcracker.artemyev.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", updatable = false, nullable = false)
    private String login;

    @Column(name = "password", updatable = false, nullable = false)
    private String password;

    @Column(name = "mail", updatable = false, nullable = false)
    private String mail;

    @ManyToOne
    @JoinColumn(name = "user_role_id", nullable = false)
    private Role role;

    public User() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
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
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("User{");
        stringBuilder.append("id=").append(id);
        stringBuilder.append(", login='").append(login).append('\'');
        stringBuilder.append(", password='").append(password).append('\'');
        stringBuilder.append(", mail='").append(mail).append('\'');
        stringBuilder.append(", role=").append(role);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
