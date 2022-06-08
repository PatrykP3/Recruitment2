package org.nowpat;

import org.junit.Test;
import org.nowpat.command.BeginCommand;
import org.nowpat.database.Database;

import static org.mockito.Mockito.*;

public class BeginCommandTest {

    @Test
    public void simpleTest() {

        Database database = spy(new Database());

        BeginCommand beginCommand = new BeginCommand();

        beginCommand.run(database);

        verify(database, times(1)).transactionStart();
    }
}
