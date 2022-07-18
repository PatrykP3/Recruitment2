package org.nowpat;

import org.junit.Test;
import org.nowpat.command.BeginCommand;
import org.nowpat.command.CommandResult;
import org.nowpat.database.Database;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BeginCommandTest {

    @Test
    public void simpleTest() {

        Database database = spy(new Database());

        BeginCommand beginCommand = new BeginCommand();

        beginCommand.run(database);

        verify(database, times(1)).transactionStart();
    }

    @Test
    public void resultSimpleTest() {

        Database database = new Database();
        BeginCommand beginCommand = new BeginCommand();

        assertFalse(database.isTransactionRunning());
        assertEquals(beginCommand.run(database), CommandResult.createSuccess());
        assertTrue(database.isTransactionRunning());
    }
}
