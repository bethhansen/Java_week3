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
    public void NewTeamObjectGetsCorrectlyCreated_true() throws Exception {
        Team team = new Team("testing");
        assertEquals(true, team instanceof Team);
    }

    @Test
    public void TeamInstantiatesWithContent_true() throws Exception {
        Team team = new Team("testing");
        assertEquals("testing", team.getContent());
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Team team = new Team("Different teams");
        Team otherTeam = new Team ("Different teams");
        assertEquals(0, Team.getAll().size());
    }
}