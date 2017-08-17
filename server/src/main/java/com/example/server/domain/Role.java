package com.example.server.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by japnica on 8/14/2017.
 */

@Entity
@Table(name = "role")
public class Role {

    @NotNull
    @Id
    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}
