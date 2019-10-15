import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static spark.Spark.*;


public class Main {
    public static ArrayList usuarios=new ArrayList<Usuario>();
    public static void main(String[] args) {
        port(8080);
        staticFiles.location("/publico");

        get("/", (request, response)-> {
            // return renderContent("publico/index.html");
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listado",usuarios);
            return new ModelAndView(attributes, "login.ftl");

        } , new FreeMarkerEngine());

        get("/index", (request, response)-> {
            // return renderContent("publico/index.html");
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listado",usuarios);
            return new ModelAndView(attributes, "index.ftl");

        } , new FreeMarkerEngine());

        get("/user", (request, response)-> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listado",usuarios);
            return new ModelAndView(attributes, "usuarios.ftl");

        } , new FreeMarkerEngine());

        get("/articulo", (request, response)-> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listado",usuarios);
            return new ModelAndView(attributes, "articulos.ftl");

        } , new FreeMarkerEngine());
    }

    private static String renderContent(String htmlFile) throws IOException, URISyntaxException {
        URL url = Main.class.getResource(htmlFile);
        Path path = Paths.get(url.toURI());
        return new String(Files.readAllBytes(path), Charset.defaultCharset());
    }

}
