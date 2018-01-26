package dao;

import models.Organization;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class Sql2oOrganizationDao implements OrganizationDao {

    private final Sql2o sql2o;

    public Sql2oOrganizationDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Organization organization) {

        String sql = "INSERT INTO organizations (name, truename, location, membership, govtrelationship) VALUES (:name, :truename, :location, :membership, :govtrelationship)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(organization)
                    .executeUpdate()
                    .getKey();
            organization.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from organizations WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
