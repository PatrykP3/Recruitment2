package org.nowpat.database;

import lombok.Getter;
import lombok.Setter;
import org.nowpat.entity.Item;

import java.util.HashMap;
import java.util.List;

public class TransactionData {

    @Getter
    @Setter
    private boolean transactionRunning;

    @Getter
    private HashMap<String, Item> transactionMembers = new HashMap<>();

    public List<Item> getMembers() {

        return (List<Item>) transactionMembers.values();
    }


    public void addMember(Item item) {

        if(!transactionMembers.containsKey(item.getName())) {
            transactionMembers.put(item.getName(), item);
        }
    }
}
