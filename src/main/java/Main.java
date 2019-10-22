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
    public static void main(String[] args) {
        Usuario user = new Usuario();
        port(8080);
        staticFiles.location("/publico");
        Sql sql = new Sql();
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
            etiqueta.articulo_id = articulo.getLastArticle();
            sql.insertEtiqueta(etiqueta, tagList, tagList.size());
            response.redirect("/index");
            return "Articulo Creado";
        });

        get("/", (request, response)-> {
            //response.redirect("/login.html");
            return renderContent("publico/login.html");
        });

        get("/edita", (request, response)-> {
            List<Usuario> users = user.getAllUsers();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("usuario",users);
            return new ModelAndView(attributes, "articuloedit.ftl");

        } , new FreeMarkerEngine());

        post("/sesion", (request, response)-> {
            List<Usuario> users = user.getAllUsers();
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
            Session session=request.session(true);
            Map<String, Object> attributes = new HashMap<>();
            Usuario usuario = (Usuario)(session.attribute("usuario"));
            attributes.put("usuario",usuario);
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
            List<Usuario> users = user.getAllUsers();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("usuario",users);
            return new ModelAndView(attributes, "usuarios.ftl");

        } , new FreeMarkerEngine());

        get("/articulo", (request, response)-> {
            List<Usuario> users = user.getAllUsers();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("usuario",users);
            return new ModelAndView(attributes, "articulos.ftl");

        } , new FreeMarkerEngine());

        get("/crear", (request, response)-> {

            Session session=request.session(true);
            Map<String, Object> attributes = new HashMap<>();
            Usuario usuario = (Usuario)(session.attribute("usuario"));
            attributes.put("usuario",usuario);

            return new ModelAndView(attributes, "crear.ftl");

        } , new FreeMarkerEngine());

    }

    private static String renderContent(String htmlFile) throws IOException, URISyntaxException {
        URL url = Main.class.getResource(htmlFile);
        Path path = Paths.get(url.toURI());
        return new String(Files.readAllBytes(path), Charset.defaultCharset());
    }

}
