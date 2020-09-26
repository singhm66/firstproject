package in.co.ldx.ldx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class login extends AppCompatActivity {
    //variables
    private EditText stname;
    private EditText stmobile;
    private RadioGroup radioGroup;
    private Button Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Signup = findViewById(R.id.signup);

        radioGroup = findViewById(R.id.malefemalebtn);


        stname = findViewById(R.id.stname);
        stmobile = findViewById(R.id.stmobile);
        String name = stname.getText().toString();
       final String number = "+91" + stmobile.getText().toString();

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (stname.length() < 1) {
                    stname.setError("!");
                    stname.requestFocus();
                    Toasty.warning(login.this, "enter name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (stmobile.length() != 10) {
                    stmobile.setError("!");
                    stmobile.requestFocus();
                    Toasty.warning(login.this, "enter 10 digit number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toasty.warning(login.this, "choose gender", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(login.this,phoneotp.class);
                intent.putExtra("stnumber",number);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }

        });


    }
}