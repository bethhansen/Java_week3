package models;

import spark.route.HttpMethod;

import java.util.ArrayList;


public class Team {

    private String member1;
    private String member2;
    private String member3;
    private String member4;
    private int id;
    private boolean published;
    private static ArrayList<Team> memberList = new ArrayList<>();

    public Team(String member1, String member2, String member3, String member4){
        this.member1 =member1;
        this.member2 = member2;
        this.member3 = member3;
        this.member4 = member4;
        this.published = false;
        memberList.add(this);
        this.id = memberList.size();
    }


    public ArrayList<Team> getContent(){
        return memberList;
    }
    public void update(String member1, String member2, String member3, String member4){
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
        this.member4 = member4;
    }


    // find by the id //
    public static Team findById(int id){
        return memberList.get(id-1);
    }


    // get all of the array list
    public static ArrayList<Team> getAll() {
        return memberList;
    }

    // test-clear-all-method//
    public static void clearAllTeams(){
        memberList.clear();

    }


    public boolean getPublished(){
        return this.published;
    }

    // get by id
    public int getId() {
        return id;
    }

    /// getter methods ///
     public String getMember1() {
        return member1;
    }
    public String getMember2() {
        return member2;
    }
    public String getMember3() {
        return member3;
    }
    public String getMember4() {
        return member4;
    }
    public static ArrayList<Team> getMemberList() {
        return memberList;
    }


}

