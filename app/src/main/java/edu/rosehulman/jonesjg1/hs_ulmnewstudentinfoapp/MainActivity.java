package edu.rosehulman.jonesjg1.hs_ulmnewstudentinfoapp;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity
        implements MessagingFragment.OnFragmentInteractionListener, HealthInsuranceFragment.OnFragmentInteractionListener,EberhardstrasseMapFragmnet.OnFragmentInteractionListener,EinsteinMapFragment.OnFragmentInteractionListener,PritwitzstrasseMapFragment.OnFragmentInteractionListener,fundingFragment.OnFragmentInteractionListener,cityLawsFragment.OnFragmentInteractionListener,JobsFragment.OnFragmentInteractionListener,transportFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener,NavigationView.OnNavigationItemSelectedListener,LoginFragment.OnFragmentInteractionListener{

    private GoogleSignInAccount maccount;
    private FirebaseAuth mAuth;
    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 1;
    private GoogleSignInClient mGoogleSignInClient;
    private LoginFragment.OnFragmentInteractionListener mListener;
    private TextView memail;
    private TextView musername;
    private ImageView mProfilePic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        maccount = GoogleSignIn.getLastSignedInAccount(this);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();


        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        mAuth = FirebaseAuth.getInstance();

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);

        musername = header.findViewById(R.id.username);

        memail = header.findViewById(R.id.email);
        mProfilePic = header.findViewById(R.id.profilepic);
        setText();
        musername.setOnClickListener(new goToProfile());
        memail.setOnClickListener(new goToProfile());
        mProfilePic.setOnClickListener(new goToProfile());


        navigationView.setNavigationItemSelectedListener(this);
    }

    public class goToProfile implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ProfileFragment profilefrag = new ProfileFragment();
            ft.replace(R.id.content_main, profilefrag , "profile");
            ft.commit();
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public GoogleSignInAccount getaccount(){
        return maccount;
    }

    class getBitmapFromURL extends AsyncTask<String, Void, Bitmap>

    {

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (IOException e) {
                // Log exception
                return null;
            }

        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            mProfilePic.setImageBitmap(bitmap);
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            //Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                maccount = task.getResult(ApiException.class);
                setText();
                firebaseAuthWithGoogle(maccount);

                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.commit();
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        maccount = GoogleSignIn.getLastSignedInAccount(this);
        setText();
        //updateUI(currentUser);
    }
    public GoogleSignInAccount getGoogleAccount(){
        return this.maccount;
    }

    public void setText(){
        if(maccount!=null) {
            musername.setVisibility(View.VISIBLE);
            memail.setVisibility(View.VISIBLE);
            mProfilePic.setVisibility(View.VISIBLE);
            musername.setText(maccount.getDisplayName());
            memail.setText(maccount.getEmail());
            (new getBitmapFromURL()).execute(maccount.getPhotoUrl().toString());
//            mProfilePic.setImageURI(maccount.getPhotoUrl());
            Log.d("TAG", maccount.getPhotoUrl().toString());
        }

        else{
            musername.setText("NULL");
            memail.setText("NULL");
            mProfilePic.setVisibility(View.GONE);
            musername.setVisibility(View.GONE);
            memail.setVisibility(View.GONE);
            mProfilePic.setVisibility(View.GONE);
        }
    }

    public void signOut() {
        // Firebase sign out
        mAuth.signOut();

        // Google sign out
        mGoogleSignInClient.signOut().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });
        maccount = null;
        setText();
    }


    public void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        int id = item.getItemId();

        if (id == R.id.jobsbutton) {
            JobsFragment jobsFragment = new JobsFragment();
            ft.replace(R.id.content_main, jobsFragment, "jobs");
            ft.commit();
            // Handle the camera action
        } else if (id == R.id.fundingbutton) {
            fundingFragment fundingFragment = new fundingFragment();
            ft.replace(R.id.content_main,fundingFragment,"funding");
            ft.commit();
        } else if (id == R.id.transportbutton) {
           transportFragment transportFragment = new transportFragment();
            ft.replace(R.id.content_main,transportFragment,"transport");
            ft.commit();
        } else if (id == R.id.messagingbutton) {

            if(maccount != null) {

                MessagingFragment messagingFragment = new MessagingFragment();
                ft.replace(R.id.content_main, messagingFragment , "messaging");
                ft.commit();
            }
            else {
                LoginFragment loginFragment = new LoginFragment();
                ft.replace(R.id.content_main, loginFragment, "login");
                ft.commit();
            }



        } else if (id == R.id.nav_share) {

        } else if (id == R.id.lawsbutton) {
            cityLawsFragment cityLawsFragment = new cityLawsFragment();
            ft.replace(R.id.content_main, cityLawsFragment, "city laws");
            ft.commit();


        }
        else if(id==R.id.pritwasse_map){
            PritwitzstrasseMapFragment Pmap = new PritwitzstrasseMapFragment();
            ft.replace(R.id.content_main,Pmap,"Pritwasse map");
            ft.commit();
        }
        else if(id ==R.id.eberhardstrasse_map){
            EberhardstrasseMapFragmnet Emap = new EberhardstrasseMapFragmnet();
            ft.replace(R.id.content_main,Emap,"Edberstrasse Map");
            ft.commit();
        }
        else if(id==R.id.Einstein_map){
            EinsteinMapFragment AEMap = new EinsteinMapFragment();
            ft.replace(R.id.content_main,AEMap,"Albert Map");
            ft.commit();
        }
        else if(id == R.id.healthbutton){
            HealthInsuranceFragment HFrag = new HealthInsuranceFragment();
            ft.replace(R.id.content_main,HFrag,"Health Insurance");
            ft.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
