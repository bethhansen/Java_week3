package models;

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

    public static Team findById(int id){
        return memberList.get(id-1);
    }

    public static ArrayList<Team> getAll() {
        return memberList;
    }

    // test-clear-all-method//

    public static void clearAllPosts(){
        memberList.clear();
    }
    //                     //


    public boolean getPublished(){
        return this.published;
    }

    public int getId() {
        return id;
    }

    /// getter methods ///
    //////////////////////

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
    ////////////////////////
    ////////////////////////




//    private final String content;
//    private static ArrayList<Team> instances = new ArrayList<>();
//
//    public Team(String content){
//        this.content = content;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public static ArrayList<Team> getAll(){
//        return instances;
//    }
}
