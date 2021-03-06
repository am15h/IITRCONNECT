package com.theimprovisers.iitrconnect;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class SignInActivity extends AppCompatActivity implements
        View.OnClickListener,ResultTrigger
{
    private String userEmail;
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "GoogleActivity";


    private TextView mStatusTextView;
    private TextView mDetailTextView;
    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Button listeners
        findViewById(R.id.sign_in_button).setOnClickListener(this);
        // Views
        mStatusTextView = findViewById(R.id.status);
        mDetailTextView = findViewById(R.id.detail);
        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)) //check this
                .requestEmail()
                .build();
        // [END config_signin]


        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]
    }

    // [START on_start_check_user]
    @Override
    public void onStart()
    {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);

    }
    // [END on_start_check_user]

    // [START onactivityresult]
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN)
        {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try
            {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            }
            catch (ApiException e)
            {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // [START_EXCLUDE]int
                updateUI(null);
                // [END_EXCLUDE]
            }
        }
    }
    // [END onactivityresult]

    // [START auth_with_google]
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct)
    {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        // [START_EXCLUDE silent]
        //progressDialog.show();
        // [END_EXCLUDE]

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }
                        else
                        {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // [START_EXCLUDE]
                        //             progressDialog.hide();
                        // [END_EXCLUDE]
                    }
                });
    }
    // [END auth_with_google]

    // [START signin]
    private void signIn()
    {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    // [END signin]

    private void updateUI(FirebaseUser user)
    {
        //progressDialog.hide();
        if (user != null)
        {
            mStatusTextView.setText(getString(R.string.google_status_fmt, user.getEmail()));
            mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));

            findViewById(R.id.sign_in_button).setVisibility(View.GONE);
            OnSignInSuccess(user);
        }
        else
        {
            mStatusTextView.setText("Signed out !!!");
            mDetailTextView.setText(null);

            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);

        }
    }

    private void OnSignInSuccess(FirebaseUser user)
    {
        NetworkMethods.Initialise(FirebaseFirestore.getInstance());
        NetworkMethods.ReadProfile(user.getEmail(),this);
        userEmail = user.getEmail();
    }

    @Override
    public void onClick(View v)
    {
        int i = v.getId();
        if (i == R.id.sign_in_button)
        {
            signIn();
        }
    }

    @Override
    public void OnFailure()
    {

    }

    @Override
    public void OnSuccess()
    {
        Profile profile = NetworkMethods.profileCache;
        if (profile == null)
        {
            SetProfile(new Profile());
            PersonalInfoAnctivity.profile.Print();
            PersonalInfoAnctivity.profile.email = mAuth.getCurrentUser().getEmail();
            Intent intent = new Intent(this,PersonalInfoAnctivity.class);
            startActivity(intent);
        }
        else
        {
            profile.Print();
            SetProfile(profile);
            Print.print("Changing to Loading");
            Intent intent = new Intent(this,LoadingActivity.class);
            startActivity(intent);
        }
    }

    void SetProfile(Profile profile)
    {
        AddConnectionsFragment.profile = profile;
        HomeActivity.profile = profile;
        LoadingActivity.profile = profile;
        MainActivity.profile = profile;
        MyConnectionsFragment.profile = profile;
        MyIntrestsActivity.profile = profile;
        MyProfileFragment.profile = profile;
        PersonalInfoAnctivity.profile = profile;
        ViewProfileActivity.profile = profile;
        ProfileListGenerator.profile = profile;
        StorageClass.mPref = getPreferences(MODE_PRIVATE);
        MyConnectionsFragment.profileArrayList = StorageClass.Read();


/*
        Profile p1 = new Profile("sdgk","awojf","saf",2);
        Profile p2 = new Profile("aflsal","sfsf","sfkhn",3);
        ArrayList<Profile> list = new ArrayList<Profile>();
        //ArrayList<Profile> list = StorageClass.Read(getPreferences(MODE_PRIVATE));

        list.add(p1);
        list.add(p2);
        StorageClass.Write(list,getPreferences(MODE_PRIVATE));*/

    }

}
