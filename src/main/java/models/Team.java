package models;

import java.util.ArrayList;

/**
 * Created by Guest on 8/11/17.
 */
public class Team {

    private final String content;
    private static ArrayList<Team> instances = new ArrayList<>();

    public Team(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public static ArrayList<Team> getAll(){
        return instances;
    }
}
