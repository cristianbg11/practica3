import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Etiqueta {
    long id;
    String etiqueta;
    Articulo articulo;

    Sql2o sql2o = new Sql2o("jdbc:h2:~/practica3", "sa", "");
    public List<Etiqueta> getAllEtiquetas(){
        String sql =
                "SELECT id, etiqueta, articulo_id " +
                        "FROM etiqueta";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Etiqueta.class);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
