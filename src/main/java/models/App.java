package models;

import static spark.Spark.staticFileLocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


import spark.Request;
//import spark.Response;

public class App {

    public static void main(String[] args) {
       staticFileLocation("/public");

        // INDEX fixed HOME LANDING PAGE THE FIRST PAGE THE USER SEES
        get("/", (request, response) -> { //request for route happens at this location
            Map<String, Object> model = new HashMap<String, Object>(); // new model is made to store information
            return new ModelAndView(model, "index.hbs"); // assemble individual pieces and render
        }, new HandlebarsTemplateEngine());

        //ADD-A-TEAM-FORM WORKS
        get("/posts/new", (request,response)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "add-a-team-form.hbs");
        }, new HandlebarsTemplateEngine());

//        //See All Members
//        get("/posts/new", (request,response)->{
//            Map<String, Object> model = new HashMap<>();
//            String content = request.queryParams("content");
//            Team newTeam = new Team();
//            model.put("team", newTeam);
//            return new ModelAndView(model, "team-detail.hbs");
//        }, new HandlebarsTemplateEngine());


    //     show an individual post D
        get("/posts/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int teamId = Integer.parseInt(req.params("id"));
            Team foundTeam = Team.findTeamById(teamId);
            model.put("team", foundTeam);
            return new ModelAndView(model, "team-details.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());
















//        // show a form to update a post
//        get("/teams/:id/update-name", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int teamId = Integer.parseInt(req.params("id"));
//            Team editTeam = Team.findTeamById(teamId);
//            model.put("editTeam", editTeam);
//            return new ModelAndView(model, "team-form.hbs");
//        }, new HandlebarsTemplateEngine());

//        //process a form to update a post D
//        post("/teams/:id/update-name", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            int teamId = Integer.parseInt(request.params("id"));
//            Team editTeam = Team.findTeamById(teamId);
//            String name = request.queryParams("name");
//            editTeam.setMember(name);
//            model.put("newName", editTeam);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());





















//        // process new post form D
//        post("/posts/teams", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            ArrayList<Team> teams = Team.allMembers();
//            String member1 = request.queryParams("item1");
//            String member2 = request.queryParams("item2");
//            String member3 = request.queryParams("item3");
//            Team newpost = new Team(member1, member2, member3);
//            model.put("raccoon", newpost);
//            return new ModelAndView(model, "success.hbs");
//        },new HandlebarsTemplateEngine());
//
        // show all posts D
//        get("/", (request, response) -> { //request for route happens at this location
//            Map<String, Object> model = new HashMap<String, Object>(); // new model is made to store information
//            ArrayList<Team> teams = Team.allMembers();
//            model.put("team", teams); //add it to model for template to display
//            return new ModelAndView(model, "index.hbs"); // assemble individual pieces and render
//        }, new HandlebarsTemplateEngine());

        // works D
//        post("/posts/teams", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            ArrayList<Team> teams = Team.allMembers();
//            model.put("team", teams);  //model.put("raccoon", newpost); (this was originally in there)
//            return new ModelAndView(model, "team-member-details.hbs");
//        },new HandlebarsTemplateEngine());


//


//        // not sure
//        get("/teams/:id/add-member", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int teamId = Integer.parseInt(req.params("id"));
//            Team editTeam = Team.findTeamById(teamId);
//            model.put("addMember", editTeam);
//            return new ModelAndView(model, "team-form.hbs");
//        }, new HandlebarsTemplateEngine());





//        post("/teams/:id/add-member", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            int teamId = Integer.parseInt(request.params("id"));
//            Team editTeam = Team.findTeamById(teamId);
//            String member = request.queryParams("member");
//            editTeam.allMembers();
//            model.put("addMember", editTeam);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());



//        //LAYOUT fixed
//        get("/favorite_photos", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            return new ModelAndView(model, "favorite_photos.hbs");
//        }, new HandlebarsTemplateEngine());

//        //FORM fixed
//        get("/form", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            return new ModelAndView(model, "add-team-form.hbs");
//        }, new HandlebarsTemplateEngine());





//        get("/posts/:id", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfTeamToFind = Integer.parseInt(request.params("id")); //pull id - must match route segment
//            Team foundTeam = Team.findById(idOfTeamToFind); //use it to find post
//            model.put("team", foundTeam); //add it to model for template to display
//            return new ModelAndView(model, "success.hbs"); //individual post page.
//        }, new HandlebarsTemplateEngine());
//
//
//        //TEAM MEMBER DETAIL fixed
//        get("/teams/:id", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfTeamToFind = Integer.parseInt(request.params("id")); //pull id - must match route segment
//            Team foundTeam = Team.findById(idOfTeamToFind); //use it to find post
//            model.put("team", foundTeam); //add it to model for template to display
//            return new ModelAndView(model, "team-member-detail.hbs"); //individual post page.
//        }, new HandlebarsTemplateEngine());

        //success
//        post("/posts/new", (req,res)->{
//            Map<String, Object> model = new HashMap<>();
//            String teamName = req.queryParams("team-name");
//            Team team = new Team(allTeams);
//            model.put("team",team);
//            return new ModelAndView(model,"success.hbs");
//        }, new HandlebarsTemplateEngine());



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
