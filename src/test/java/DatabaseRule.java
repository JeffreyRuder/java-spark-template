import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/databasename_test", null, null);

  }

  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      con.createQuery("TRUNCATE the tables you eant to delete").executeUpdate();
    }
  }
}
