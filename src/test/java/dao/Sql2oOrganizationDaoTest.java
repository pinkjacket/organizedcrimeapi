package dao;

import models.Organization;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oOrganizationDaoTest {

    private Connection conn;
    private Sql2oOrganizationDao organizationDao;
    private Sql2oIndividualDao individualDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        organizationDao = new Sql2oOrganizationDao(sql2o);
        individualDao = new Sql2oIndividualDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingOrganizationSetsId() throws Exception {
        Organization testOrganization = setupOrganization();
        organizationDao.add(testOrganization);
        assertEquals(1,testOrganization.getId());
    }

    @Test
    public void deleteByIdDeletesProperly() throws Exception {
        Organization testOrganization = setupOrganization();
        organizationDao.add(testOrganization);
        organizationDao.deleteById(testOrganization.getId());
        assertEquals(0, organizationDao.getAll().size());
    }
    

    @Test
    public void getAllGetsAll() throws Exception {
        Organization testOrganization = setupOrganization();
        Organization testOrganization2 = setupAltOrganization();
        organizationDao.add(testOrganization);
        organizationDao.add(testOrganization2);
        assertEquals(2, organizationDao.getAll().size());
    }

    public Organization setupOrganization() {
        return new Organization("Yakuza", "The Extreme Path", "Japan", "102,000", "cozy");
    }

    public Organization setupAltOrganization() {
        return new Organization("Mafia", "Our Thing", "North America and Italy", "declining", "Estranged");
    }
}