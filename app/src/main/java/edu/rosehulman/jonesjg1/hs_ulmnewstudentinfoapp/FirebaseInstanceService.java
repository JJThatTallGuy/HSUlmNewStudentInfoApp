package edu.rosehulman.jonesjg1.hs_ulmnewstudentinfoapp;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import static android.content.ContentValues.TAG;

/**
 * Created by jonesjg1 on 12/16/2018.
 */

public class FirebaseInstanceService extends com.google.firebase.iid.FirebaseInstanceIdService {


    @Override
    public void onTokenRefresh() {

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

    }
}
