package Models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class Team {


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Team team = new Team("Does this work");
        assertEquals(true, team instanceof Team);
    }
}