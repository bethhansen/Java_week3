package models;
import java.time.LocalDateTime;

import java.util.ArrayList;

/**
 * Created by Guest on 8/8/17.
 */
public class Team {
    private String teamName;
    private String teamDescription;
    private String member1;
    private String member2;
    private String member3;
    private String member4;
    private static ArrayList<Team> instances = new ArrayList<>();
    private boolean published;
    private LocalDateTime createdAt;
    private int id;

    public Team(String teamName, String teamDescription, String member1, String member2, String member3, String member4) {
        this.teamName = teamName;
        this.teamDescription= teamDescription;
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
        this.member4 = member4;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();
    }


    public static ArrayList<Team> getAll(){
        return instances;
    }

    public String getTeamName(){
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

    public static void clearAllPosts(){
        instances.clear();
    }

    public boolean getPublished(){
        return this.published;
    }
    public LocalDateTime getCreatedAt() {
        return  createdAt;
    }
    public int getId() {
        return id;
    }
    public static Team findById(int id){
        return instances.get(id-1);
    }
    public void update(String teamName) {
        this.teamName = teamName;
    }
}
