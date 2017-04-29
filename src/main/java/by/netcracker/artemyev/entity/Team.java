package by.netcracker.artemyev.entity;

import javax.persistence.*;

/**
 * Class describes employee team for flight
 * @autor Artemyev Artoym
 */
@Entity
@Table(name = "team")
public class Team {
    private long id;
    private String idMembers;

    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "id_members", nullable = false)
    public String getIdMembers() {
        return idMembers;
    }

    public void setIdMembers(String idMembers) {
        this.idMembers = idMembers;
    }

    public Team() {
        super();
    }

    public Team(long id, String idMembers) {
        this.id = id;
        this.idMembers = idMembers;
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
        Team team = (Team) object;
        if(this.getId() != team.getId()) {
            return false;
        }
        if(!this.getIdMembers().equals(team.getIdMembers())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) this.getId() + 2;
        result += this.getIdMembers().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Team{" + "id=" + id +
                ", idMembers='" + idMembers +
                '}';
    }
}
