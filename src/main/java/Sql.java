import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Sql {
    //Class.forName("org.h2.Driver");
    Sql2o sql2o = new Sql2o("jdbc:h2:~/practica3", "sa", "");
    public void insertUser (Usuario usuario) throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        String insertQuery =
                "INSERT INTO USUARIO (id, username, password, administrador, autor, nombre) " +
                        "VALUES (:id, :username, :password, :administrador, :autor, :nombre)";

        try (Connection con = sql2o.beginTransaction()) {
            con.createQuery(insertQuery)
                    .addParameter("id", 2)
                    .addParameter("username", usuario.getUsername())
                    .addParameter("password", usuario.getPassword())
                    .addParameter("administrador", usuario.isAdministrador())
                    .addParameter("autor", usuario.isAutor())
                    .addParameter("nombre", usuario.getNombre())
                    .executeUpdate();
            // Remember to call commit() when a transaction is opened,
            // default is to roll back.
            con.commit();
        }

    }
}
