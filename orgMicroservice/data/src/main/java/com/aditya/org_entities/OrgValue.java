package com.aditya.org_entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "organization")
public class OrgValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String companyName;
    private String address;

    OrgValue(){

    }

    public OrgValue(Long id, String companyName, String address) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrgValue{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrgValue orgValue = (OrgValue) o;
        return Objects.equals(id, orgValue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
