package com.travelset.model.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role {
    private int id;
    private String name;
    private Collection<User> users;

    @ManyToMany(mappedBy = "roles")
    public Set<Permission> permissions;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != role.id) return false;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "role")
    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
