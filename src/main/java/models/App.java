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

        // SHOW ALL POSTS (index) fixed
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Team> allTeams = Team.getAll();
            model.put("allTeams", allTeams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());




        //success
//        post("/posts/new", (req,res)->{
//            Map<String, Object> model = new HashMap<>();
//            String teamName = req.queryParams("team-name");
//            Team team = new Team(allTeams);
//            model.put("team",team);
//            return new ModelAndView(model,"success.hbs");
//        }, new HandlebarsTemplateEngine());


        //TEAM MEMBER FORM fixed
        get("/posts/new", (request, response) -> { // try memberList allTeams
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "add-team-member-form.hbs");
        }, new HandlebarsTemplateEngine());


        //SUCCESS
        get("/posts/:id", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


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


    }
}
