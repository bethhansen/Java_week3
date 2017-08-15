import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import models.Team;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    private static String success;

    public static void main(String[] args) { //type “psvm + tab” to auto create this :)
        staticFileLocation("/public");


        //show a home page (make an about page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Team> teams = Team.getTeamList();
            model.put("teams", teams);
            return new ModelAndView(model, "home.hbs");
        }, new HandlebarsTemplateEngine());


        //show a home page (make an about page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Team> teams = Team.getTeamList();
            model.put("teams", teams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        //show new team form
        get("/posts/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newpost-form.hbs");
        }, new HandlebarsTemplateEngine());


//        //show list
//        get("/", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Team> teams = Team.getTeamList();
//            model.put("teams", teams);
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());

        // post: process new post form
        post("/posts/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String teamName = request.queryParams("teamName");
            String teamDescription = request.queryParams("teamDescription");
            String member1 = request.queryParams("member1");
            String member2 = request.queryParams("member2");
            String member3 = request.queryParams("member3");
            String member4 = request.queryParams("member4");
            Team newTeam = new Team(teamName, teamDescription, member1, member2, member3, member4);
            model.put("post", newTeam);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //get: show an individual post
        get("/posts/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Team foundPost = Team.findById(idOfPostToFind); //use it to find post
            model.put("post", foundPost); //add it to model for template to display
            return new ModelAndView(model, "post-detail.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());


        //get: show a form to update a post
        get("/posts/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToEdit = Integer.parseInt(req.params("id"));
            Team editTeam = Team.findById(idOfPostToEdit);
            model.put("editPost", editTeam);
            return new ModelAndView(model, "newpost-form.hbs");
        }, new HandlebarsTemplateEngine());


        //show all posts (teams added)
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Team> teams = Team.getTeamList();
            model.put("teams", teams);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        //delete
//        get("/post/:id/delete", (request,response)-> {
//            int idOfTeamToDelete = Integer.parseInt(request.params("id")); //pull id - must match route segment
//            Team.deleteById(idOfTeamToDelete);
//            response.redirect("/");
//            return null;
//        });



    }
}
