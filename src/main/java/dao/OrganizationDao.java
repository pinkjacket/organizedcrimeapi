package dao;

import models.Individual;
import models.Organization;

import java.util.List;

public interface OrganizationDao {

    //create
    void add(Organization organization);


    //read
    List<Organization> getAll();
    //List<Individual> getAllIndividualsForOrganization();
    Organization findById(int id);

    //update
    //later

    //destroy
    void deleteById(int id);
}
