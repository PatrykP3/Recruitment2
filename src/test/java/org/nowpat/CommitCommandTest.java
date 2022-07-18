package org.nowpat;

import org.junit.Test;
import org.nowpat.command.CommitCommand;
import org.nowpat.database.Database;

import static org.mockito.Mockito.*;

public class CommitCommandTest {

    @Test
    public void commitExistingTransactionTest() {

        Database database = spy(new Database());
        database.transactionStart();

        CommitCommand commitCommand = new CommitCommand();
        commitCommand.run(database);

        verify(database, times(1)).isTransactionRunning();
        verify(database, times(1)).transactionEnd();
    }

    @Test
    public void commitNonexistentTransactionTest() {

        Database database = spy(new Database());

        CommitCommand commitCommand = new CommitCommand();

        commitCommand.run(database);

        verify(database, times(1)).isTransactionRunning();
        verify(database, times(0)).transactionEnd();
    }
}
