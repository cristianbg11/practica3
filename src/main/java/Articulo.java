import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.List;

public class Articulo {
    long id;
    String titulo;
    String cuerpo;
    Usuario autor;
    Date fecha;
    List<Comentario> listaComentario;
    List<Etiqueta> listaEtiqueta;

    Sql2o sql2o = new Sql2o("jdbc:h2:~/practica3", "sa", "");
    public List<Articulo> getAllArticles(){
        String sql =
                "SELECT id, titulo, cuerpo, usuario_id, fecha " +
                        "FROM articulo";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Articulo.class);
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
