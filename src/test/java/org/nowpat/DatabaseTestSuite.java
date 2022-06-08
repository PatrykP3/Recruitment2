package org.nowpat;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BeginCommandTest.class,
        CommitCommandTest.class,
        DeleteCommandTest.class,
        GetCommandTest.class,
        RollbackCommandTest.class,
        SetCommandTest.class
})
public class DatabaseTestSuite {
}
