import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;
import spark.Session;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

import static spark.Spark.*;


public class Main {

    //public static ArrayList usuarios=new ArrayList<Usuario>();
    public static void main(String[] args) throws ClassNotFoundException {

        port(8080);
        staticFiles.location("/publico");
        Sql sql = new Sql();
        List<Usuario> admin = sql.getadmin();
        if (!admin.get(0).username.equals("admin")){
            sql.insertAdmin();
        }
        post("/insertar", (request, response) -> {
            Usuario usuario = new Usuario();
            usuario.username = request.queryParams("username");
            usuario.nombre = request.queryParams("nombre");
            usuario.password = request.queryParams("password");
            usuario.administrador = Boolean.parseBoolean(request.queryParams("administrador"));
            usuario.autor = Boolean.parseBoolean(request.queryParams("username"));
            sql.insertUser(usuario);
            response.redirect("/");
            return "Usuario Creado";
        });

        post("/crear-articulo", (request, response)-> {
            //int id = Integer.parseInt(request.queryParams("iduser"));
            Session session=request.session(true);
            Usuario usuario = (Usuario)(session.attribute("usuario"));
            Articulo articulo = new Articulo();
            Etiqueta etiqueta = new Etiqueta();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            articulo.titulo = request.queryParams("titulo");
            articulo.cuerpo = request.queryParams("cuerpo");
            articulo.autor = usuario;
            articulo.fecha = format.parse(request.queryParams("fecha"));
            sql.insertArticulo(articulo);
            //List <Articulo> articulos = articulo.getAllArticles();
            //etiqueta.etiqueta = request.queryParams("etiqueta");
            String[] tags = request.queryParams("etiqueta").split(",");
            List<String> tagList = Arrays.asList(tags);
            //etiqueta.articulo.id = articulo.getLastArticle();
            //etiqueta.articulo = articulos.get(articulos.size()-1);
            etiqueta.articulo_id = sql.getLastArticle();
            sql.insertEtiqueta(etiqueta, tagList, tagList.size());
            response.redirect("/index");
            return "Articulo Creado";
        });

        get("/delete", (request, response)-> {
            int id_articulo = Integer.parseInt(request.queryParams("id_post"));
            sql.deleteArticulo(id_articulo);
            response.redirect("/articulo");
            return "Articulo Borrado";
        });

        post("/update", (request, response)-> {
            Articulo articulo = new Articulo();
            Etiqueta etiqueta = new Etiqueta();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            articulo.titulo = request.queryParams("titulo");
            articulo.cuerpo = request.queryParams("cuerpo");
            articulo.fecha = format.parse(request.queryParams("fecha"));
            int id_articulo = Integer.parseInt(request.queryParams("id_post"));
            sql.editArticulo(id_articulo, articulo);
            sql.deleteEtiqueta(id_articulo);
            String[] tags = request.queryParams("etiqueta").split(",");
            List<String> tagList = Arrays.asList(tags);
            etiqueta.articulo_id = id_articulo;
            sql.insertEtiqueta(etiqueta, tagList, tagList.size());
            response.redirect("/post?id_post="+id_articulo);
            return "Articulo Actualizado";
        });

        get("/", (request, response)-> {
            //response.redirect("/login.html");
            return renderContent("publico/login.html");
        });

        get("/edita", (request, response)-> {
            int id = Integer.parseInt(request.queryParams("id_post"))-1;
            List<Articulo> articulos = sql.getArticle(id);
            Map<String, Object> attributes = new HashMap<>();
            Session session=request.session(true);
            Usuario usuario = (Usuario)(session.attribute("usuario"));
            attributes.put("usuario",usuario);
            attributes.put("post",articulos.get(0));
            return new ModelAndView(attributes, "articuloedit.ftl");

        } , new FreeMarkerEngine());

        post("/sesion", (request, response)-> {
            List<Usuario> users = sql.getAllUsers();
            String username = request.queryParams("user");
            String password = request.queryParams("pass");
            Session session=request.session(true);

            for(Usuario usuario : users){
                if (usuario.username.equals(username) && usuario.password.equals(password)){
                    session.attribute("usuario", usuario);
                    response.redirect("/index");
                }
            }
            response.redirect("/");
            return 0;
        });


        get("/index", (request, response)-> {
            Map<String, Object> attributes = new HashMap<>();
            Session session=request.session(true);
            Usuario usuario = (Usuario)(session.attribute("usuario"));
            List<Articulo> articulos = sql.getLastArticles();
            attributes.put("usuario",usuario);
            attributes.put("articulos",articulos);
            return new ModelAndView(attributes, "index.ftl");

        } , new FreeMarkerEngine());

        get("/salir", (request, response)->{
            //creando cookie en para un minuto
            Session session=request.session(true);
            session.invalidate();
            response.redirect("/");
            return "Sesion finalizada";
        });

        get("/user", (request, response)-> {
            List<Usuario> users = sql.getAllUsers();
            Session session=request.session(true);
            Usuario usuario = (Usuario)(session.attribute("usuario"));
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("users",users);
            attributes.put("usuario",usuario);
            return new ModelAndView(attributes, "usuarios.ftl");

        } , new FreeMarkerEngine());

        get("/articulo", (request, response)-> {
            List<Articulo> articulos = sql.getAllArticles();
            Map<String, Object> attributes = new HashMap<>();
            Session session=request.session(true);
            Usuario usuario = (Usuario)(session.attribute("usuario"));
            attributes.put("usuario",usuario);
            attributes.put("articulos",articulos);
            return new ModelAndView(attributes, "articulos.ftl");

        } , new FreeMarkerEngine());

        get("/post", (request, response)-> {
            int id = Integer.parseInt(request.queryParams("id_post"))-1;
            List<Articulo> articulos = sql.getArticle(id);
            Map<String, Object> attributes = new HashMap<>();
            Session session=request.session(true);
            Usuario usuario = (Usuario)(session.attribute("usuario"));
            attributes.put("usuario",usuario);
            attributes.put("post",articulos.get(0));
            return new ModelAndView(attributes, "post.ftl");

        } , new FreeMarkerEngine());

        get("/crear", (request, response)-> {
            Map<String, Object> attributes = new HashMap<>();
            Session session=request.session(true);
            Usuario usuario = (Usuario)(session.attribute("usuario"));
            attributes.put("usuario",usuario);
            return new ModelAndView(attributes, "crear.ftl");

        } , new FreeMarkerEngine());

        post("/comentar", (request, response) -> {
            Session session=request.session(true);
            Usuario usuario = (Usuario)(session.attribute("usuario"));
            Comentario comentario = new Comentario();
            comentario.comentario = request.queryParams("comentario");
            comentario.autor = usuario;
            comentario.articulo_id = Integer.parseInt(request.queryParams("articulo_id"));
            sql.insertComentario(comentario);
            response.redirect("/post?id_post="+(comentario.articulo_id));
            return "Comentario Creado";
        });

    }

    private static String renderContent(String htmlFile) throws IOException, URISyntaxException {
        URL url = Main.class.getResource(htmlFile);
        Path path = Paths.get(url.toURI());
        return new String(Files.readAllBytes(path), Charset.defaultCharset());
    }

}
