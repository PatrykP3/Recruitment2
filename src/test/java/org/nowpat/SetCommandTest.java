package org.nowpat;

import org.junit.Test;
import org.nowpat.command.SetCommand;
import org.nowpat.database.Database;
import org.nowpat.entity.Item;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SetCommandTest {

    @Test
    public void setNewTest() {

        Database database = new Database();
        assertThat(database.getData().size(), is(0));

        SetCommand setCommand = new SetCommand("a", 10);
        database.runCommand(setCommand);
        assertThat(database.getData().size(), is(1));
        assertThat(database.getData().get("a"), is(new Item("a", 10)));
    }

    @Test
    public void setExistingTest() {

        Database database = new Database();
        assertThat(database.getData().size(), is(0));

        SetCommand setCommand = new SetCommand("a", 10);
        database.runCommand(setCommand);
        setCommand = new SetCommand("a", 20);
        database.runCommand(setCommand);
        assertThat(database.getData().size(), is(1));
        assertThat(database.getData().get("a"), is(new Item("a", 20)));
    }
}
