package dao;

import models.Individual;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class Sql2oIndividualDao implements IndividualDao {

    private final Sql2o sql2o;

    public Sql2oIndividualDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Individual individual) {

        String sql = "INSERT INTO individuals (name, description, organizationid) VALUES (:name, :description, :organizationid)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(individual)
                    .executeUpdate()
                    .getKey();
            individual.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from individuals WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
