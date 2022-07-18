package org.nowpat;

import org.junit.Test;
import org.nowpat.command.RollbackCommand;
import org.nowpat.database.Database;
import org.nowpat.database.TransactionData;

import static org.mockito.Mockito.*;

public class RollbackCommandTest {

    @Test
    public void noTransactionTest() {

        Database database = spy(new Database());
        when(database.getTransactionData()).thenReturn(new TransactionData());

        RollbackCommand rollbackCommand = new RollbackCommand();
        rollbackCommand.run(database);

        verify(database, times(1)).isTransactionRunning();
        verify(database, times(0)).transactionRollback();
    }

    @Test
    public void existingTransactionTest() {

        Database database = spy(new Database());
        database.transactionStart();

        RollbackCommand rollbackCommand = new RollbackCommand();
        rollbackCommand.run(database);

        verify(database, times(1)).isTransactionRunning();
        verify(database, times(1)).transactionRollback();
    }
}
