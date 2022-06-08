package org.nowpat;

import org.junit.Test;
import org.nowpat.command.CommitCommand;
import org.nowpat.database.Database;

import static org.mockito.Mockito.*;

public class CommitCommandTest {

    @Test
    public void simpleTest() {

        Database database = spy(new Database());

        CommitCommand commitCommand = new CommitCommand();

        commitCommand.run(database);

        verify(database, times(1)).transactionEnd();
    }
}
