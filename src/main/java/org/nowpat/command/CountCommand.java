package org.nowpat.command;

import lombok.AllArgsConstructor;
import org.nowpat.database.Database;
import org.nowpat.entity.Item;

public class CountCommand implements DatabaseCommand {

    private int value;

    public CountCommand(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public void run(Database database) {

        int count = 0;

        for(Item item : database.getData().values()) {
            if(item.getValue() == value) {
                count ++;
            }
        }

        System.out.println(count);
    }

    @Override
    public String getItemName() {
        return null;
    }
}
