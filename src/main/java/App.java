import com.google.gson.Gson;
import dao.Sql2oIndividualDao;
import dao.Sql2oOrganizationDao;
import models.Organization;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.get;
import static spark.Spark.post;

public class App {
    public static void main(String[] args) {
        Sql2oOrganizationDao organizationDao;
        Sql2oIndividualDao individualDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/crimes.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        organizationDao = new Sql2oOrganizationDao(sql2o);
        individualDao = new Sql2oIndividualDao(sql2o);
        conn = sql2o.open();

        post("/organizations/new", "application/json", (req, res) -> {
            Organization organization = gson.fromJson(req.body(), Organization.class);
            organizationDao.add(organization);
            res.status(201);
            res.type("application/json");
            return gson.toJson(organization);
        });

        get("/organizations", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(organizationDao.getAll());
        });

        get("/organizations/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int organizationId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(organizationDao.findById(organizationId));
        });
    }
}
