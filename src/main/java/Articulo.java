import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.List;

public class Articulo {
    long id;
    String titulo;
    String cuerpo;
    Usuario autor;
    int usuario_id;
    Date fecha;
    List<Comentario> listaComentario;
    List<Etiqueta> listaEtiqueta;

    Sql2o sql2o = new Sql2o("jdbc:h2:~/practica3", "sa", "");
    public List<Articulo> getAllArticles(){
        Usuario usuario = new Usuario();
        try (Connection con = sql2o.open()) {
            List<Articulo> articulos = con.createQuery("Select * from Articulo").executeAndFetch(Articulo.class);
            for(Articulo articulo: articulos)
            {
                articulo.setAutor(usuario.getUser(articulo.usuario_id).get(0));
            }
            return articulos;
        }
    }
    public Articulo getArticulo(int id){
        String sql =
                "SELECT usuario_id" +
                        "FROM articulo WHERE id="+id;

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeScalar(Articulo.class);
        }
    }

    public Integer getLastArticle() {
        String sql =
                "SELECT top 1 id " +
                        "FROM articulo order by id desc";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeScalar(Integer.class);
        }
    }

    public List<Usuario> getAllUsers(){
        String sql =
                "SELECT id, username, password, administrador, autor, nombre " +
                        "FROM usuario";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Usuario.class);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Comentario> getListaComentario() {
        return listaComentario;
    }

    public void setListaComentario(List<Comentario> listaComentario) {
        this.listaComentario = listaComentario;
    }

    public List<Etiqueta> getListaEtiqueta() {
        return listaEtiqueta;
    }

    public void setListaEtiqueta(List<Etiqueta> listaEtiqueta) {
        this.listaEtiqueta = listaEtiqueta;
    }
}
