package sg.edu.np.s10179199k.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import static sg.edu.np.s10179199k.myapplication.R.id.sign_in_button;

public class GoogleLogin extends AppCompatActivity {

    // TAG is for show some tag logs in LOG screen.
    public static final String TAG = "GoogleLogin";

    // Request sing in code. Could be anything as you required.
    public static final int RequestSignInCode = 2;

    // Firebase Auth Object.
    public FirebaseAuth firebaseAuth;

    // Google API Client object.
    public GoogleApiClient googleApiClient;

    // Sing out button.
    Button SignOutButton;

    // Google Sign In button .
    com.google.android.gms.common.SignInButton signInButton;

    private FirebaseAuth.AuthStateListener mAuthListner;

    @Override
    protected void onStart() {

        super.onStart();

        firebaseAuth.addAuthStateListener(mAuthListner);
    }

    // TextView to Show Login User Email and Name.
    TextView LoginUserName, LoginUserEmail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_login);


        signInButton = findViewById(sign_in_button);

        SignOutButton = findViewById(R.id.sign_out);

        //LoginUserName = (TextView) findViewById(R.id.textViewName);

        //LoginUserEmail = (TextView) findViewById(R.id.textViewEmail);

        signInButton = findViewById(sign_in_button);

        // Getting Firebase Auth Instance into firebaseAuth object.
        firebaseAuth = FirebaseAuth.getInstance();

        // Hiding the TextView on activity start up time.
        //LoginUserEmail.setVisibility(View.GONE);
        //LoginUserName.setVisibility(View.GONE);

        // Adding Click listener to User Sign in Google button.
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserSignInMethod();

            }
        });

        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(GoogleLogin.this, Mainboard.class));
                    finish();
                }
            }
        };

        // Creating and Configuring Google Sign In object.
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();


        // Creating and Configuring Google Api Client.
        googleApiClient = new GoogleApiClient.Builder(GoogleLogin.this)
                .enableAutoManage(GoogleLogin.this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Log.i("GOOGLE LOGIN", "Connection Failed");
                    }
                } /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();

        // Adding Click Listener to User Sign Out button.
        SignOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserSignOutFunction();

            }
        });

    }


    // Sign In function Starts From Here.
    public void UserSignInMethod() {

        // Passing Google Api Client into Intent.
        Intent AuthIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);

        startActivityForResult(AuthIntent, RequestSignInCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RequestSignInCode) {

            GoogleSignInResult googleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            int statusCode = googleSignInResult.getStatus().getStatusCode();

            if (googleSignInResult.isSuccess()) {

                GoogleSignInAccount googleSignInAccount = googleSignInResult.getSignInAccount();

                FirebaseUserAuth(googleSignInAccount);
            } else {
                Toast.makeText(GoogleLogin.this, "Auth Went Wrong", Toast.LENGTH_SHORT).show();
            }

        }
    }


    public void FirebaseUserAuth(GoogleSignInAccount googleSignInAccount) {

        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
        firebaseAuth.signInWithCredential(authCredential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("TAG", "signInWith:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                        } else {
                            Log.d("TAG", "signInWith:failure", task.getException());
                            Toast.makeText(GoogleLogin.this, "Wuthentication failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        // Toast.makeText(GoogleLogin.this,""+ authCredential.getProvider(), Toast.LENGTH_LONG).show();

    }

    public void UserSignOutFunction() {

        // Sing Out the User.
        firebaseAuth.signOut();


        // After logout Hiding sign out button.
        SignOutButton.setVisibility(View.GONE);

        // After logout setting up email and name to null.
        LoginUserName.setText(null);
        LoginUserEmail.setText(null);

        // After logout setting up login button visibility to visible.
        signInButton.setVisibility(View.VISIBLE);
    }


}
