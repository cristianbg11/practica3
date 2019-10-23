import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Usuario {
    int id;
    String username;
    String password;
    boolean administrador;
    boolean autor;
    String nombre;

    Sql2o sql2o = new Sql2o("jdbc:h2:~/practica3", "sa", "");
    public List<Usuario> getAllUsers(){
        String sql =
                "SELECT id, username, password, administrador, autor, nombre " +
                        "FROM usuario";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Usuario.class);
        }
    }

    public List<Usuario> getUser(int id){
        String sql =
                "SELECT * FROM usuario " + "WHERE id="+id;

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Usuario.class);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public boolean isAutor() {
        return autor;
    }

    public void setAutor(boolean autor) {
        this.autor = autor;
    }
}
