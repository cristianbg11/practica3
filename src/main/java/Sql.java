import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql {
    //Class.forName("org.h2.Driver");
    Sql2o sql2o = new Sql2o("jdbc:h2:~/practica3", "sa", "");
    public void insertUser (Usuario usuario) throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        String insertQuery =
                "INSERT INTO USUARIO (username, password, administrador, autor, nombre) " +
                        "VALUES (:username, :password, :administrador, :autor, :nombre)";

        try (Connection con = sql2o.beginTransaction()) {
            con.createQuery(insertQuery)
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

    public void insertArticulo (Articulo articulo) throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        String insertQuery =
                "INSERT INTO ARTICULO (titulo, cuerpo, usuario_id, fecha) " +
                        "VALUES (:titulo, :cuerpo, :usuario_id, :fecha)";

        try (Connection con = sql2o.beginTransaction()) {
            con.createQuery(insertQuery)
                    .addParameter("titulo", articulo.getTitulo())
                    .addParameter("cuerpo", articulo.getCuerpo())
                    .addParameter("usuario_id", articulo.getAutor().id)
                    .addParameter("fecha", articulo.getFecha())
                    .executeUpdate();
            // Remember to call commit() when a transaction is opened,
            // default is to roll back.
            con.commit();
        }

    }

    public void insertEtiqueta (Etiqueta etiqueta, List tag, int cant) throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        for(int i=0; i < cant; i++){
            String insertQuery =
                    "INSERT INTO ETIQUETA (etiqueta, articulo_id) " +
                            "VALUES (:etiqueta, :articulo_id)";

            try (Connection con = sql2o.beginTransaction()) {
                con.createQuery(insertQuery)
                        .addParameter("etiqueta", tag.get(i))
                        .addParameter("articulo_id", etiqueta.getArticulo_id())
                        .executeUpdate();
                // Remember to call commit() when a transaction is opened,
                // default is to roll back.
                con.commit();
            }
        }

    }
}
