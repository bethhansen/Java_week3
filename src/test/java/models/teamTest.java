package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static models.Team.clearAllTeams;
import static org.junit.Assert.*;


public class teamTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void NewTeamPlayerObjectGetsCorrectlyCreated_true() throws Exception {
        Team team = setupNewTeam();
        assertEquals(true, team instanceof Team);
    }

    public Team setupNewTeam(){
        return new Team("Test Team", "Test Description", "Test Member 1", "Test Member 2", "Test Member 3", "Test Member 4");
    }


    @Test
    public void TeamInstantiatesWithTeamName_true() throws Exception {
        Team team = setupNewTeam();
        assertEquals("Test Team", team.getTeamName());
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() throws Exception {
        Team team = setupNewTeam();
        assertEquals(false, team.getPublished());
    }

//    @Test
//    public void AllTeamsContainsAllJobs_true() {
//        Team team = setupNewTeam();
//        Team otherTeam = setupNewTeam();
//        assertTrue(Team.getAll().contains(team));
//        assertTrue(Team.getAll().contains(otherTeam));
//    }


//    @Test
//    public void updateChangesPostContent() throws Exception {
//        Team team = setupNewTeam();
//        team.update("Alice", "Ava", "Beth", "Angel");
//        assertEquals("Ava" , team.getMember2());
//
//    }

    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception {
        clearAllTeams();
        Team team = setupNewTeam();
        assertEquals(1, team.getId());
    }

    @Test
    public void findReturnsCorrectPost() throws Exception {
        Team team = setupNewTeam();
        assertEquals(3, Team.findById(team.getId()).getId());
    }


}