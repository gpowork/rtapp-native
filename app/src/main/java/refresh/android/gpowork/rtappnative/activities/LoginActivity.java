package refresh.android.gpowork.rtappnative.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import refresh.android.gpowork.rtappnative.R;
import refresh.android.gpowork.rtappnative.settings.GlobalSettings;

/**
 * Created by gpowork on 14/05/2017.
 */

public class LoginActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
    }

    public void runLoginProccess(View view) {
        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password = (EditText)findViewById(R.id.password);
        final ProgressBar loginProgress = (ProgressBar)findViewById(R.id.loginProgress);

        if (password.getText() != null && password.getText().length() > 0
                && username.getText() != null && username.getText().length() > 0) {
            RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    GlobalSettings.getLoginURL(),
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            loginProgress.setVisibility(View.INVISIBLE);
                            JSONObject responseInJSON = null;
                            try {
                                responseInJSON = new JSONObject(response);
                                if (responseInJSON != null && responseInJSON.getBoolean("success")) {
                                    Toast.makeText(getApplicationContext(), "Login successful.", Toast.LENGTH_LONG).show();
                                    return;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(getApplicationContext(), "Wrong login name or password.", Toast.LENGTH_LONG).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            loginProgress.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "Connection between server and you device is not stable. Please check your Internet settings and try again.", Toast.LENGTH_LONG).show();
                        }
                    }
            ){
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> map = new HashMap<>();
                    map.put("logo", username.getText().toString());
                    map.put("password", password.getText().toString());
                    return map;
                }
            };
            loginProgress.setVisibility(View.VISIBLE);
            queue.add(stringRequest);
        } else {
            Toast.makeText(getApplicationContext(), "Data you put is not correct. Check it and press 'Login' button again.", Toast.LENGTH_LONG).show();
        }
    }
}
