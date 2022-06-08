package org.nowpat.database;

import lombok.Getter;
import org.nowpat.command.DatabaseCommand;
import org.nowpat.entity.Item;

import java.util.HashMap;

public class Database {

    @Getter
    private HashMap<String, Item> data = new HashMap<>();

    @Getter
    private TransactionData transactionData;

    public void runCommand(DatabaseCommand command) {

        if (transactionData != null) {
            if (command.getItemName() != null) {

                Item transactionMember = data.get(command.getItemName());
                if(transactionMember == null) {
                    transactionMember = new Item(command.getItemName(), null);
                }
                transactionData.addMember(transactionMember);
            }
        }

        command.run(this);
    }

    public void transactionStart() {
        transactionData = new TransactionData();
    }

    public void transactionEnd() {
        transactionData = null;
    }

    public void transactionRollback() {

        if(getTransactionData() == null) {
            throw new IllegalStateException();
        }

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
