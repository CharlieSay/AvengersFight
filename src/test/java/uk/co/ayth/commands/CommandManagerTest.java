package uk.co.ayth.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class CommandManagerTest {

    private CommandManager commandManager;

    @Before
    public void testSetup(){
        commandManager = new CommandManager();
    }

    @Test
    public void shouldNotHitCommand_WhenNotOp(){
        CommandSender commandSender = mockPlayer();
        String[] stringArray = new String[1];
        stringArray[0] = "thor";
        boolean avenger = commandManager.onCommand(commandSender, null, "avenger", stringArray);

        verify(commandSender, atMost(1)).isOp();
        assertFalse(avenger);
    }

    private Player mockPlayer(){
        Player player = mock(Player.class);
        when(player.getName()).thenReturn("foobar");
        when(player.getUniqueId()).thenReturn(UUID.randomUUID());
        return player;
    }
}