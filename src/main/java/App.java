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


        //show a home page with all teams
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Team> teams = Team.getTeamList();
            model.put("teams", teams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        //get: show new team form
        get("/posts/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newpost-form.hbs");
        }, new HandlebarsTemplateEngine());


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


//        //show all posts (teams added)
//        get("/", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            ArrayList<Team> teams = Team.getTeamList();
//            model.put("teams", teams);
//
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());


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


//        //update a team
//            post("/teams/:id/update", (request, res) -> {
//                Map<String, Object> model = new HashMap<>();
//                String nameOfTeam = request.queryParams("nameOfTeam");
//                int idOfPostToEdit = Integer.parseInt(request.params("id"));
//                Team editTeams = Team.findById(idOfPostToEdit);
//                editTeams.update(nameOfTeam);
//                res.redirect("/");
//                return null;
//
//            });


        //add a team member
//        get("/teams/:id/addMember", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "member-form.hbs");
//        }, new HandlebarsTemplateEngine());

        //all members on a team
//        get("/members/:id/update", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfMemberToEdit = Integer.parseInt(req.params("id"));
//            Member memberAdded = Member.findById(idOfMemberToEdit);
//            model.put("editMembers", memberAdded);
//            return new ModelAndView(model, "membersonteam.hbs");
//        }, new HandlebarsTemplateEngine());


        //update member
//        post("/teams/:id/update", (request, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            String name = request.queryParams("name");
//            int age = Integer.parseInt(request.queryParams("age"));
//            String description = request.queryParams("description");
//            int idOfPostToEdit = Integer.parseInt(request.params("id"));
//            Member editMember = Member.findById(idOfPostToEdit);
//            editMember.update(name, age, description);
//            res.redirect("/");
//            return null;
//        });
    }
}
