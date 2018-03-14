package android.bignerdranch.com.less_5;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button buttPass,btnOthr;
private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adListenerOnButton();
    }
    public void adListenerOnButton(){
        pass = (EditText) findViewById(R.id.editTextPass);
        buttPass = (Button)findViewById(R.id.button_pass);
        btnOthr = (Button)findViewById(R.id.btnOther);
        buttPass.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View view) {
                        buttPass.setText("DONE");
                        buttPass.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                        Toast.makeText(MainActivity.this,pass.getText(),Toast.LENGTH_LONG).show();
                    }
                }
        );
        btnOthr.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View view) {
                         buttPass.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                      Toast.makeText(MainActivity.this,"Мы все поменяли",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
}
