import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.core.ReturnInstruction.Return;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
public class App {
	
    public static void main(String[] args) {
    	Logger log = LoggerFactory.getLogger(App.class); 
        
        
        get("/casa",(req, res)-> {
        Map<String, Object> model = new HashMap<>();
        User user=new User("misael","jimenez");
        model.put("user", user);
        model.put("titulo", "Datos");
        return new ModelAndView(model, "casa.ftl");
        }, new FreeMarkerEngine());
        
       
        
        get("/home", (req , res) ->{
        	Map<String, Object> model = new HashMap<>();
        	model.put("titulo", "Datos");
        	return new ModelAndView(model, "home.ftl");
        }, new FreeMarkerEngine());
        
        post("/userinfo",(req, res)->{
        	 
        	 String nombre = req.queryParamOrDefault("nombre", "misael");
        	 String apellido = req.queryParamOrDefault("apellido", "jimenez");
        	 Map<String, Object> model = new HashMap<>();
        	 model.put("titulo", "Datos");
        	 User user = new User(nombre, apellido);
        	 model.put("user", user);
        	 return new ModelAndView(model, "userinfo.ftl");
        },new FreeMarkerEngine());
        // infinitos usuarios
        get("/contact", (req, res) -> {
    		res.redirect("/contact.html");
    		return null;
    	});
    	
        post("/contact", (req, res)-> {
        	String nombres = req.queryParams("nombres");
        	String apellidos = req.queryParams("apellidos");
        	
        	
        	User user = new User(nombres, apellidos);
        	ArrayList<User> lista1 = req.session().attribute("usuarios");
        	
        	if (lista1 == null) { // Si el usuario1 NO existe, lo agregamos:
        		lista1 = new ArrayList<User>();
        	} 
        	lista1.add(user);
        	req.session().attribute("usuarios",lista1);
        	
        	return user.getInfo();
        });
        
        
        get("/usuario", (req, res) -> {
        	ArrayList<User> lista1 = req.session().attribute("usuarios");
        	if(lista1 == null) {return "no hay usuario";}
        	for (User use : lista1) {
        		log.info((String) use.getInfo());
        	}
        	
        	return "Paran!";
        });
        ///**************/////////****//**/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*
    }
}
