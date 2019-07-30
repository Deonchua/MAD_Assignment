package sg.edu.np.s10179199k.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextView tvNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNewUser = findViewById(R.id.textView4);

        tvNewUser.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(MainActivity.this, CreateNewUser.class);
                startActivity(intent);
                return false;
            }
        });

    }

    public void onLoginClick(View v) {
        EditText userName = findViewById(R.id.etUsername);
        EditText passWord = findViewById(R.id.etPassword);

        String txtUser = userName.getText().toString();
        String txtPass = passWord.getText().toString();

        Pattern userPattern = Pattern.compile("^[A-Za-z0-9]{6,12}$");
        Matcher userMatcher = userPattern.matcher(txtUser);

        Pattern passPattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$");
        Matcher passMatcher = passPattern.matcher(txtPass);

        if (userMatcher.matches() && passMatcher.matches()) {
            SharedPreferences sharedPref = getSharedPreferences("MY_GLOBAL_PREFS", MODE_PRIVATE);
            String user = sharedPref.getString("User_name", "");
            String pass = sharedPref.getString("Pass_word", "");
            Log.d("04L", "User: " + user + " Pass: " + pass);
            if (txtUser.equals(user) && txtPass.equals(pass)) {
                Toast.makeText(MainActivity.this, "Valid", Toast.LENGTH_LONG).show();
                Intent in = new Intent(MainActivity.this, Mainboard.class);
                startActivity(in);
            }
        } else {
            Toast tt = Toast.makeText(MainActivity.this, "Invalid Login", Toast.LENGTH_LONG);
            tt.show();

    }
}}
