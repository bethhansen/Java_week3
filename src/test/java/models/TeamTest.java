package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TeamTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void NewTeamPlayerObjectGetsCorrectlyCreated_true() throws Exception {
        Team team = new Team("testing");
        assertEquals(true, team instanceof Team);
    }

    @Test
    public void TeamPlayerInstantiatesWithContent_true() throws Exception {
        Team team = new Team("testing");
        assertEquals("testing", team.getContent());
    }

    @Test
    public void AllTeamPlayersAreCorrectlyReturned_true() {
        Team team = new Team("Different player");
        Team otherTeam = new Team ("Different player");
        assertEquals(0, Team.getAll().size());
    }


}