import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;


import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
public class App {
	
    public static void main(String[] args) {
    	//Logger log = LoggerFactory.getLogger(App.class); 
        
        
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
        ///////////tarea////////////////////////////
        post("/userinfo",(req, res)->{
        	 
        	 String nombre = req.queryParamOrDefault("nombre", "misael");
        	 String apellido = req.queryParamOrDefault("apellido", "jimenez");
        	 Map<String, Object> model = new HashMap<>();
        	 model.put("titulo", "Datos");
        	 User user = new User(nombre, apellido);
        	 model.put("user", user);
        	 return new ModelAndView(model, "userinfo.ftl");
        },new FreeMarkerEngine());
        
    }
}
