package dao;

import models.Individual;
import models.Organization;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oIndividualDaoTest {

    private Connection conn;
    private Sql2oIndividualDao individualDao;
    private Sql2oOrganizationDao organizationDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        individualDao = new Sql2oIndividualDao(sql2o);
        organizationDao = new Sql2oOrganizationDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingIndividualSetsId() throws Exception {
        Organization testOrganization = setupOrganization();
        organizationDao.add(testOrganization);
        Individual testIndividual = new Individual("Kiryu Kazuma", "The Dragon of Dojima", testOrganization.getId());
        individualDao.add(testIndividual);
        assertEquals(1, testIndividual.getId());
    }

    @Test
    public void deleteByIdDeletesCorrectly() throws Exception {
        Organization testOrganization = setupOrganization();
        organizationDao.add(testOrganization);
        Individual testIndividual = new Individual("Kiryu Kazuma", "The Dragon of Dojima", testOrganization.getId());
        individualDao.add(testIndividual);
        individualDao.deleteById(testIndividual.getId());
        assertEquals(0, individualDao.getAllIndividualsForOrganization(testOrganization.getId()).size());
    }

    @Test
    public void getAllIndividualsForOrganizationProperly() throws Exception {
        Organization testOrganization = setupOrganization();
        organizationDao.add(testOrganization);
        Individual testIndividual = new Individual("Kiryu Kazuma", "The Dragon of Dojima", testOrganization.getId());
        individualDao.add(testIndividual);
        Individual secondIndividual = new Individual("Goro Majima", "The Mad Dog of Shimano", testOrganization.getId());
        individualDao.add(secondIndividual);
        assertEquals(testIndividual, individualDao.getAllIndividualsForOrganization(testOrganization.getId()).get(0));
    }

    public Organization setupOrganization() {
        return new Organization("Yakuza", "The Extreme Path", "Japan", "102,000", "cozy");
    }
}