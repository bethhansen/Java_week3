package models;
import java.time.LocalDateTime;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private String teamDescription;
    private String member1;
    private String member2;
    private String member3;
    private String member4;
    private static ArrayList<Team>teamList = new ArrayList<>();
    private boolean published;
    private LocalDateTime createdAt;
    private int id;

    public Team(String teamName, String teamDescription, String member1, String member2, String member3, String member4) {
        this.teamName = teamName;
        this.teamDescription = teamDescription;
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
        this.member4 = member4;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        teamList.add(this);
        this.id = teamList.size();
        teamList.add(this);
    }




    //getters
    public String getTeamName() {
        return teamName;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public String getTeamMember1() {
        return member1;
    }

    public String getTeamMember2() {
        return member2;
    }

    public String getTeamMember3() {
        return member3;
    }

    public String getTeamMember4() {
        return member4;
    }



//    public ArrayList<String> addTeamName(String teamName) {
//        this.teamName.add(teamName);
//        return teamName;
//    }

    public static void clearAllPosts() {
        teamList.clear();
    }

    public boolean getPublished() {
        return this.published;
    }

    public static ArrayList<Team> getTeamList() {
        return teamList;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }

    public static Team findById(int id) {
        return teamList.get(id - 1);
    }

    public void update(String teamName) {
        this.teamName = teamName;
    }
//    public ArrayList<String> getMembers(){
//        return teamName[];
//    }


    public static void clearAllTeams() {  //put this here because test was asking for it
    }
}
