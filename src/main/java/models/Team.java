package models;


import java.util.ArrayList;


public class Team {

    private String member1;
    private String member2;
    private String member3;
    private int id;
    private boolean published;
    private static ArrayList<Team> allMembers = new ArrayList<>();

    public Team(String member1, String member2, String member3){
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
        this.published = false;
        allMembers.add(this);
        this.id = allMembers.size();
    }

    public Team() {
        member1 = member1;
        member2 = member2;
        member3 = member3;
    }


    public ArrayList<Team> getContent(){
        return allMembers;
    }
    public void update(String member1, String member2, String member3){
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
    }


    // find by the id //
    public static Team findById(int id){
        return allMembers.get(id-1);
    }
    public static Team findTeamById(int id) {
        return allMembers.get(id-1);
    }

    // get all of the array list
    public static ArrayList<Team> getAll() {
            return allMembers;
    }

    // test-clear-all-method//
    public static void clearAllTeams(){
        allMembers.clear();

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
    public static ArrayList<Team> getMemberList() {
        return allMembers;
    }


    public static ArrayList<Team> allMembers() {
        return allMembers;
    }



    public void setMember(String member) {
        this.member1 = member;
    }

//    public void addMember(String member) {
//        String newMember = member1;
//        allMembers.add(member1);
//    }
}

