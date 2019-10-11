package com.tiunida.courierapp.ActivityMain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tiunida.courierapp.ActivityLogin.View.LoginActivity;
import com.tiunida.courierapp.FragmentBiasa.BiasaFragment;
import com.tiunida.courierapp.FragmentExpress.ExpressFragment;
import com.tiunida.courierapp.FragmentKilat.KilatFragment;
import com.tiunida.courierapp.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;
    private String user_id;
    private String name;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        getFragmentPage(new BiasaFragment());

        BottomNavigationView mBottomNavigationView = findViewById(R.id.bnb_tab);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);

        user_id = firebaseAuth.getCurrentUser().getUid();
        firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {

                    if (task.getResult().exists()) {
                        name = task.getResult().getString("user_level");
                        if (name.equals("1")) {
                            sendToLogin();
                            showMessage("Maaf akun ini hanya dapat digunakan oleh pelanggan");
                        }
                    }
                } else {
                    String errorMessage = task.getException().getMessage();
                    Log.d("error ngambil data : ", "" + errorMessage);
                }
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.navigation_biasa:
                fragment = new BiasaFragment();
                break;
            case R.id.navigation_express:
                fragment = new ExpressFragment();
                break;
            case R.id.navigation_kilat:
                fragment = new KilatFragment();
                break;
            case R.id.navigation_profile:
                showDialogOnLogoutBtnOnClick();
                break;
        }
        return loadFragment(fragment);
    }

    private boolean getFragmentPage(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private void sendToLogin() {
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

    public void showDialogOnLogoutBtnOnClick() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title dialog
        alertDialogBuilder.setTitle("Apakah antum yakin ingin LogOut dari aplikasi ini ?");

        // set pesan dari dialog
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        mAuth.signOut();
                        sendToLogin();
                    }
                })
                .setNegativeButton("tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();

    }

    public void showMessage(String message) {
        Toast.makeText(MainActivity.this, "Error : " + message, Toast.LENGTH_LONG).show();

    }
}
