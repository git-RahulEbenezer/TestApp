package rahul.com.retrotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class JobActivity extends AppCompatActivity {
    EditText extxtinput;
    Button btnstartservice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        extxtinput=findViewById(R.id.extxtinput);
        btnstartservice=findViewById(R.id.startintentservice);

        btnstartservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=extxtinput.getText().toString();
                Intent intent= new Intent(JobActivity.this,MyJobIntentService.class);
                intent.putExtra("input",input);
                MyJobIntentService.enquework(JobActivity.this,intent);
            }
        });

    }
}
