package uas.haidarveraazzahra.registerlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    TextView userEmail,Sambut ,SambutAdmin;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    Button Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        userEmail = findViewById(R.id.tvEmail);
        Logout = findViewById(R.id.btnLogout);
        firebaseAuth =firebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        userEmail.setText(firebaseUser.getEmail());
        Sambut = findViewById(R.id.sambutan);
        SambutAdmin = findViewById(R.id.sambutanadmin);

        SambutAdmin.setVisibility(View.GONE);
        String Email = firebaseUser.getEmail();

        if(Email.equals("administrator@gmail.com")){
            Sambut.setVisibility(View.GONE);
            SambutAdmin.setVisibility(View.VISIBLE);
        }

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}