

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import models.Team;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
       staticFileLocation("/public");

        //new post form
        get("/teams/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "add-team-member-form.hbs");
        }, new HandlebarsTemplateEngine());


//        //process new form
//        post("/teams/new", (request, response) -> { //URL to make new post on POST route
//            Map<String, Object> model = new HashMap<String, Object>();
//            String content = request.queryParams("content");
//            Team newTeam = new Team(team);
//            model.put("team", newTeam);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());

        //get: show all posts
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Team> allTeams = Team.getAll();
            model.put("memberList", allTeams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show an individual post
        get("/teams/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Team foundTeam = Team.findById(idOfTeamToFind); //use it to find post
            model.put("team", foundTeam); //add it to model for template to display
            return new ModelAndView(model, "team-member.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());





    }
}
