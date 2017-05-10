package by.netcracker.artemyev.entity;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity implements Serializable, Cloneable {
    private Long id;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public abstract String toString();

    public abstract int hashCode();

    public abstract boolean equals(Object object);

}
