package refresh.android.gpowork.rtappnative.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import refresh.android.gpowork.rtappnative.R;

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
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);
        if (password.getText() != null && password.getText().length() > 0
                && username.getText() != null && username.getText().length() > 0) {

        } else {
            CharSequence text = "Data you put is not correct. Check it and press 'Login' button again.";
            Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
