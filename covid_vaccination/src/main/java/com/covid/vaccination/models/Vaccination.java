package com.covid.vaccination.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vaccination_entity")
public class Vaccination {

    @Id
    @Column(name="id")
    public long id;
    @Column(name="vaccine_name")
    public String vaccine_name;
    @Column(name="doses")
    public int doses;
    @Column(name="type")
    public String type;

    public Vaccination(long id, String vaccine_name, int doses, String type) {
        this.id = id;
        this.vaccine_name = vaccine_name;
        this.doses = doses;
        this.type = type;
    }

    public Vaccination(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVaccine_name() {
        return vaccine_name;
    }

    public void setVaccine_name(String vaccine_name) {
        this.vaccine_name = vaccine_name;
    }

    public int getDoses() {
        return doses;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
