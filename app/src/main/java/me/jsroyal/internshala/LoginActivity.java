package me.jsroyal.internshala;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by jsroyal on 16/4/17.
 */

public class LoginActivity extends AppCompatActivity {

    // Email, password edittext
    EditText txtUsername, txtPassword;

    // login button
    Button btnLogin;

    // Session Manager Class
    SessionManager session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Session Manager
        session = new SessionManager(getApplicationContext());

        // Email, Password input text
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);


        btnLogin = (Button) findViewById(R.id.btnLogin);
        // Login button click event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Get username, password from EditText
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                // Check if username, password is filled
                if(username.trim().length() > 0 && password.trim().length() > 0){
                    if(username.equals("test") && password.equals("test")){
                        session.createLoginSession("jsroyal", "jsroyal55@gmail.com");

                        // Staring MainActivity
                        Intent i = new Intent(getApplicationContext(), Notes.class);
                        startActivity(i);
                        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
                        // Login button
                        finish();

                    }else{
                        // username / password doesn't match
                        Toast.makeText(LoginActivity.this, "Login failed.."+"Username/Password is incorrect", Toast.LENGTH_LONG).show();
                    }
                }else{
                    // user didn't entered username or password
                    // Show alert asking him to enter the details
                   Toast.makeText(LoginActivity.this, "Login failed.." + "Please enter username and password", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}

