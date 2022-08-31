package com.example.practicafragmentos20.data.dao;


import javax.annotation.Nullable;

import io.realm.Realm;

public class BaseDAO {
    protected static void performTransaction(final Realm.Transaction transaction) {
        // Hold a reference to the Realm default instance.
        Realm realm = null;
        try {
            //Get the default realm instance.
            realm = Realm.getDefaultInstance();
            // Execute the transaction.
            realm.executeTransaction(transaction);
        } finally {
            // Close the realm instance if it is not null.
            if (realm != null) {
                realm.close();
            }
        }
    }


    protected static void performTransactionCallback(Realm.Transaction transaction,
                                                     Realm.Transaction.OnSuccess onSuccess,
                                                     @Nullable final Realm.Transaction.OnError onError) {
        // Hold a reference to the Realm default instance.
        Realm realm = null;
        try {
            //Get the default realm instance.
            realm = Realm.getDefaultInstance();
            // Execute the transaction.
            realm.executeTransactionAsync(
                    transaction,
                    onSuccess,
                    onError
            );
        } finally {
            // Close the realm instance if it is not null.
            if (realm != null) {
                realm.close();
            }
        }
    }
}
