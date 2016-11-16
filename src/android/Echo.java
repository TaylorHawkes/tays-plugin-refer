package org.apache.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;

/**
* This class echoes a string called from JavaScript.
*/
public class Echo extends CordovaPlugin {

@Override
public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView); 
}

@Override
public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

     if (action.equals("echo")) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.cordova.getActivity());
        String answer=  sharedPreferences.getString("referrer",null);
        callbackContext.success(answer);
        return true;
    }
    return false;
}

private void echo(String message, CallbackContext callbackContext) {
    if (message != null && message.length() > 0) {
        callbackContext.success(message);
    } else {
        callbackContext.error("Expected one non-empty string argument.");
    }
}
}
