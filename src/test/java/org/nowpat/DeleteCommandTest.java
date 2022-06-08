package org.nowpat;

import org.junit.Test;
import org.nowpat.command.DeleteCommand;
import org.nowpat.command.GetCommand;
import org.nowpat.database.Database;
import org.nowpat.entity.Item;

import java.util.HashMap;

import static org.mockito.Mockito.*;

public class DeleteCommandTest {
    @Test
    public void deleteExistingTest() {

        Database database = spy(new Database());

        HashMap<String, Item> data = spy(new HashMap<>());
        when(data.containsKey("a")).thenReturn(true);
        when(data.get("a")).thenReturn(new Item("a", 10));

        when(database.getData()).thenReturn(data);

        DeleteCommand deleteCommand = new DeleteCommand("a");
        database.runCommand(deleteCommand);

        verify(database, times(1)).getData();
        verify(data).remove("a");
    }
}
