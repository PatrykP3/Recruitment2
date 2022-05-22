package org.nowpat.database;

import lombok.Getter;
import org.nowpat.command.DatabaseCommand;
import org.nowpat.entity.Item;

import java.util.HashMap;

public class Database {

    public static HashMap<String, Item> data = new HashMap<>();

    @Getter
    private static TransactionData transactionData;

    public static void runCommand(DatabaseCommand command) {

        if (transactionData != null) {
            if (command.getItemName() != null) {

                Item transactionMember = data.get(command.getItemName());
                if(transactionMember == null) {
                    transactionMember = new Item(command.getItemName(), null);
                }
                transactionData.addMember(transactionMember);
            }
        }

        command.run();
    }

    public static void transactionStart() {
        transactionData = new TransactionData();
    }

    public static void transactionEnd() {
        transactionData = null;
    }

    public static void transactionRollback() {

        for(Item transactionMember : transactionData.getMembers()) {
            if(transactionMember.getValue() != null) {
                data.put(transactionMember.getName(), transactionMember);
            }
            else {
                data.remove(transactionMember.getName());
            }
        }
        transactionData = null;
    }
}
