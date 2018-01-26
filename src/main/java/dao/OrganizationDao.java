package dao;

import models.Individual;
import models.Organization;

import java.util.List;

public interface OrganizationDao {

    //create
    void add(Organization organization);


    //read
    List<Organization> getAll();
    List<Individual> getAllIndividualsForOrganization();

    //update

    //destroy
    void deleteById(int id);
}
