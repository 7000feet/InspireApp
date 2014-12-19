package com.mrapps.inspire;

import android.app.Application;

import com.mrapps.inspire.utils.ParseConstants;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

/**
 * Created by Mason Reaves on 11/25/2014.
 */
public class InspireApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "gIKupEWbPAPbVeTCPBC1UCqCjicSWPOv3MHmWFac" , "CjUy8vlc2P7pO5R61EHE9RXFGnCRdRTxfQO42YDi");

        ParseInstallation.getCurrentInstallation().saveInBackground();

        //create a testobject below to check communication with parse backend
        //ParseObject testObject = new ParseObject("TestObject");
        //testObject.put("foo", "bar");
        //testObject.saveInBackground();
    }

    public static void updateParseInstallation(ParseUser user){
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());
        installation.saveInBackground();

    }

}
