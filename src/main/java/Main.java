import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
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

        get("/", (request, response)-> {
            List<Usuario> users = user.getAllUsers();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("usuario",users);
            return new ModelAndView(attributes, "login.ftl");

        } , new FreeMarkerEngine());

        get("/edita", (request, response)-> {
            List<Usuario> users = user.getAllUsers();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listado",users);
            return new ModelAndView(attributes, "articuloedit.ftl");

        } , new FreeMarkerEngine());

        post("/sesion", (request, response)-> {
            List<Usuario> users = user.getAllUsers();
            String username = request.queryParams("user");
            String password = request.queryParams("pass");
            Map<String, Object> attributes = new HashMap<>();
            for(Usuario usuario : users){
                if (usuario.username.equals(username) && usuario.password.equals(password)){
                    attributes.put("usuario",users.get(usuario.id));
                    return new ModelAndView(attributes, "index.ftl");
                    //response.redirect("/index");
                }
            }
            return new ModelAndView(attributes, "login.ftl");
        }, new FreeMarkerEngine());

        get("/index", (request, response)-> {
            List<Usuario> users = user.getAllUsers();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listado",users);
            return new ModelAndView(attributes, "index.ftl");

        } , new FreeMarkerEngine());

        get("/user", (request, response)-> {
            List<Usuario> users = user.getAllUsers();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listado",users);
            return new ModelAndView(attributes, "usuarios.ftl");

        } , new FreeMarkerEngine());

        get("/articulo", (request, response)-> {
            List<Usuario> users = user.getAllUsers();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listado",users);
            return new ModelAndView(attributes, "articulos.ftl");

        } , new FreeMarkerEngine());

        get("/crear", (request, response)-> {
            List<Usuario> users = user.getAllUsers();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listado",users);
            return new ModelAndView(attributes, "crear.ftl");

        } , new FreeMarkerEngine());

    }

    private static String renderContent(String htmlFile) throws IOException, URISyntaxException {
        URL url = Main.class.getResource(htmlFile);
        Path path = Paths.get(url.toURI());
        return new String(Files.readAllBytes(path), Charset.defaultCharset());
    }

}
