package uk.ocr.utilities;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.junit.Before;
import org.junit.Test;

import uk.co.ocr.commands.CommandManager;

import static junit.framework.TestCase.assertTrue;
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
    public void testACommandIsSent() {
        assertTrue(true);
    }

}