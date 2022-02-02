package org.nowpat.command;

import lombok.AllArgsConstructor;
import org.nowpat.database.Database;
import org.nowpat.entity.Item;

public class CountCommand implements DatabaseCommand {

    private int value;

    public CountCommand(String value) {
        this.value = Integer.valueOf(value);
    }

    @Override
    public void run() {

        int count = 0;

        for(Item item : Database.data.values()) {
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
