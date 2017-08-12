package models;

import static spark.Spark.staticFileLocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


//import spark.Request;
//import spark.Response;

public class App {
    public static void main(String[] args) {
       staticFileLocation("/public");

        // INDEX fixed
        get("/", (request, response) -> { //request for route happens at this location
            Map<String, Object> model = new HashMap<String, Object>(); // new model is made to store information
            return new ModelAndView(model, "index.hbs"); // assemble individual pieces and render
        }, new HandlebarsTemplateEngine()); //

        //LAYOUT fixed
        get("/favorite_photos", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "favorite_photos.hbs");
        }, new HandlebarsTemplateEngine());

        //FORM fixed
        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "add-team-member-form.hbs");
        }, new HandlebarsTemplateEngine());


        //SUCCESS fixed
        get("/posts/:id", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());



        get("/posts/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = Integer.parseInt(request.params("id")); //pull id - must match route segment
            Team foundTeam = Team.findById(idOfTeamToFind); //use it to find post
            model.put("team", foundTeam); //add it to model for template to display
            return new ModelAndView(model, "success.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());


        //TEAM MEMBER DETAIL fixed
        get("/teams/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = Integer.parseInt(request.params("id")); //pull id - must match route segment
            Team foundTeam = Team.findById(idOfTeamToFind); //use it to find post
            model.put("team", foundTeam); //add it to model for template to display
            return new ModelAndView(model, "team-member-detail.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());

        //success
//        post("/posts/new", (req,res)->{
//            Map<String, Object> model = new HashMap<>();
//            String teamName = req.queryParams("team-name");
//            Team team = new Team(allTeams);
//            model.put("team",team);
//            return new ModelAndView(model,"success.hbs");
//        }, new HandlebarsTemplateEngine());


        //SUCCESS
//        post("/posts/teams", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            String member1 = request.queryParams("item1");
//            String member2 = request.queryParams("item2");
//            String member3 = request.queryParams("item3");
//            String member4 = request.queryParams("item4");
//            Team newpost = new Team(member1, member2, member3, member4);
//            model.put("raccoon", newpost);
//            return new ModelAndView(model, "success.hbs");
//        },new HandlebarsTemplateEngine());

//        get("/posts/:id",(request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            Team team = Integer.parseInt(request.params(".id");
//            model.put("team", team);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine();


        //success
//        post("/posts/new", (req,res)->{
//            Map<String, Object> model = new HashMap<>();
//            String teamName = req.queryParams("team-name");
//            Team team = new Team(allTeams);
//            model.put("team",team);
//            return new ModelAndView(model,"success.hbs");
//        }, new HandlebarsTemplateEngine());



    }
}
