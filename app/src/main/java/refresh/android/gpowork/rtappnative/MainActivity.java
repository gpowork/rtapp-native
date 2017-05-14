package refresh.android.gpowork.rtappnative;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import refresh.android.gpowork.rtappnative.activities.LoginActivity;
import refresh.android.gpowork.rtappnative.activities.QcProjectsActivity;
import refresh.android.gpowork.rtappnative.settings.GlobalSettings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runDispatcher();
    }

    protected void runDispatcher() {
        if (checkIfUserAuthorized()) {
            startQcProjectsPage();
        } else {
            startLoginActivity();
        }
    }

    protected void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    protected void startQcProjectsPage(){
        Intent intent = new Intent(this, QcProjectsActivity.class);
        startActivity(intent);
    }

    protected boolean checkIfUserAuthorized() {
        Map<String, Object> settings = retrieveDataFromStorage();
        if (settings != null && settings.get(GlobalSettings.USER_LOGIN) != null && settings.get(GlobalSettings.USER_HASHED_PASSWORD) != null)
            return true;
        return false;
    }

    protected Map<String, Object> retrieveDataFromStorage() {
        SharedPreferences settings = getPreferences(Context.MODE_PRIVATE);
        if (settings != null) {
            Map<String, Object> map = new HashMap<>();
            map.put(GlobalSettings.USER_LOGIN, settings.getString(GlobalSettings.USER_LOGIN, null));
            map.put(GlobalSettings.USER_HASHED_PASSWORD, settings.getString(GlobalSettings.USER_HASHED_PASSWORD, null));
            map.put(GlobalSettings.SERVER_URL, settings.getString(GlobalSettings.SERVER_URL, null));
            return map;
        }
        return null;
    }
}
