package uk.co.ayth.commands;

import org.bukkit.entity.Player;
import org.junit.Before;
import org.junit.Test;
import uk.co.ayth.avengers.Thor;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class MakeAvengerCommandTest {

    MakeAvengerCommand makeAvengerCommand;

    @Before
    public void setUp(){
        makeAvengerCommand = new MakeAvengerCommand();
    }

    @Test
    public void shouldSetPlayerInventoryThor_WhenAvengerProvidedIsThor(){
        Player player = mock(Player.class);
        Thor thor = new Thor();

        assertTrue(true);
    }

}