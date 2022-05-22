package org.nowpat.database;

import lombok.Getter;
import org.nowpat.entity.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionData {

    @Getter
    private HashMap<String, Item> transactionMembers = new HashMap<>();

    public List<Item> getMembers() {

        return new ArrayList<>(transactionMembers.values());
    }


    public void addMember(Item item) {

        if(!transactionMembers.containsKey(item.getName())) {
            transactionMembers.put(item.getName(), item);
        }
    }
}
