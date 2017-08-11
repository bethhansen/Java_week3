import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
       staticFileLocation("/public");

        get("/posts/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "add-team-member-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/posts/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToFind = Integer.parseInt(req.params("id"));
            Team foundPost = Team.findById(idOfPostToFind);
            model.put("post", foundPost);
            return new ModelAndView(model, "post-detail.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
