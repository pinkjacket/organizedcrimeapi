package models;

import java.util.Objects;

public class Organization {
    private String name;
    private String truename;
    private String location;
    private String membership;
    private String govtrelationship;
    private int id;

    public Organization(String name, String truename, String location, String membership, String govtrelationship) {
        this.name = name;
        this.truename = truename;
        this.location = location;
        this.membership = membership;
        this.govtrelationship = govtrelationship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getGovtrelationship() {
        return govtrelationship;
    }

    public void setGovtrelationship(String govtrelationship) {
        this.govtrelationship = govtrelationship;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getTruename(), that.getTruename()) &&
                Objects.equals(getLocation(), that.getLocation()) &&
                Objects.equals(getMembership(), that.getMembership()) &&
                Objects.equals(getGovtrelationship(), that.getGovtrelationship());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getTruename(), getLocation(), getMembership(), getGovtrelationship(), getId());
    }
}
