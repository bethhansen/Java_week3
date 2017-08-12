package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class teamTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public Team setupNewTeam() {
        return new Team("Scout", "Elise", "Nekaia", "Sovarae");
    }

    public Team setupNewTeam2() {
        return new Team("Scout", "Elise", "Nekaia", "Sovarae");
    }

    @Test
    public void NewTeamPlayerObjectGetsCorrectlyCreated_true() throws Exception {
        Team team = setupNewTeam();
        assertEquals(true, team instanceof Team);
    }

    @Test
    public void AllTeamPlayersAreCorrectlyReturned_true() {
        Team team = setupNewTeam();
        Team team2 = setupNewTeam2();
        assertEquals(5, Team.getAll().size());
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() throws Exception {
        Team team = setupNewTeam();
        assertEquals(false, team.getPublished());
    }

    @Test
    public void updateChangesPostContent() throws Exception {
        Team team = setupNewTeam();
        team.update("Alice", "Ava", "Beth", "Angel");
        assertEquals("Ava" , team.getMember2());

    }

    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception {
        Team.clearAllTeams();
        Team team = setupNewTeam();
        assertEquals(1, team.getId());
    }

    @Test
    public void findReturnsCorrectPost() throws Exception {
        Team team = setupNewTeam();
        assertEquals(3, Team.findById(team.getId()).getId());
    }
}