package org.nowpat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.nowpat.command.GetCommand;
import org.nowpat.database.Database;
import org.nowpat.entity.Item;

import java.util.HashMap;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GetCommandTest {

    @Test
    public void getExistingTest() {

        Database database = spy(new Database());

        HashMap<String, Item> data = spy(new HashMap<>());
        when(data.containsKey("a")).thenReturn(true);
        when(data.get("a")).thenReturn(new Item("a", 10));

        when(database.getData()).thenReturn(data);

        GetCommand getCommand = new GetCommand("a");
        database.runCommand(getCommand);

        verify(database, times(2)).getData();
        verify(data).get("a");
    }
}
