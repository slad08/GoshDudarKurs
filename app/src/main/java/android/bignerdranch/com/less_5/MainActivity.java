package android.bignerdranch.com.less_5;

import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
private Button buttPass,btnOthr,btnChange;
private EditText pass;
private RatingBar ratBar;
private TextView txtRes;
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
        btnChange = (Button)findViewById(R.id.btnChange);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
            }
        });


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
        //Создаем RatingBar и выводим значение в txtRes
        ratBar =(RatingBar) findViewById(R.id.ratingBar);
        txtRes = (TextView) findViewById(R.id.result_txtV);

        ratBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txtRes.setText("Значение: " + String.valueOf(rating));
               // txtRes.setText(String.valueOf(ratingBar.getRating()));
            }
        });


        btnOthr.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View view) {
                         buttPass.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                   //   Toast.makeText(MainActivity.this,"Мы все поменяли",Toast.LENGTH_LONG).show();

                        AlertDialog.Builder a_build = new AlertDialog.Builder(MainActivity.this);
                        a_build.setMessage("Вы хотите закрыть приложение,а?")
                                .setCancelable(false)
                                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int wich) {
                                        finish();
                                        // /Toast.makeText(MainActivity.this,"Да",Toast.LENGTH_LONG).show();
                                    }
                                })
                                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int wich) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = a_build.create();
                        alert.setTitle("Закрытие приложения");
                        alert.show();

                    }
                }

        );
    }
}
