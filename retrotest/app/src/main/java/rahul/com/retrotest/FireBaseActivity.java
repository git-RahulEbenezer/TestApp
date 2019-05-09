package rahul.com.retrotest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FireBaseActivity extends AppCompatActivity {
    Button btn;
    EditText emial,password;
    TextView textView;
    FirebaseAuth firebaseAuth;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base);

        firebaseAuth=FirebaseAuth.getInstance();

        emial=findViewById(R.id.editTextEmail);
        password=findViewById(R.id.editTextPassword);
        btn=findViewById(R.id.btnsubmitfirebase);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFIrebase(emial.getText().toString(),password.getText().toString());
            }
        });
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
    }

    private void callFIrebase(String email,String password) {
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(FireBaseActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(FireBaseActivity.this, "Sorry", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}
