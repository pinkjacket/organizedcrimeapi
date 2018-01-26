package dao;

import models.Individual;
import models.Organization;

import java.util.List;

public interface IndividualDao {

    //create
    void add (Individual individual);
    //void addIndividualToOrganization(Individual individual, Organization organization);

    //read
    //List<Individual> getAll();

    //update
    //later

    //destroy
    void deleteById(int id);

}
