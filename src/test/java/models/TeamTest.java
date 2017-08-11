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
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Team team = new Team("testing");
        assertEquals(true, team instanceof Team);
    }

    @Test
    public void PostInstantiatesWithContent_true() throws Exception {
        Team team = new Team("testing");
        assertEquals("testing", team.getContent());
    }
}