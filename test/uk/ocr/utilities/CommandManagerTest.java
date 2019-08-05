package uk.ocr.utilities;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.junit.Before;
import org.junit.Test;
import uk.ocr.commands.CommandManager;

import static org.mockito.Mockito.*;

public class CommandManagerTest {

    private CommandSender commandSender;
    private Command command;
    private CommandManager commandManager;

    @Before
    public void setUpClass() {
        commandSender = mock(CommandSender.class);
        command = mock(Command.class);
        commandManager = new CommandManager();
    }

    @Test
    public void testACommandIsSent(){
        when(commandSender.getName()).thenReturn("player1");
        when(command.getName()).thenReturn("startGame");

        String[] arguments = new String[1];
        arguments[0] = "noargs";

        commandManager.performCommand(commandSender,command,"sg",arguments);

        verify(commandSender).getName();
        verify(command).getName();
    }

}