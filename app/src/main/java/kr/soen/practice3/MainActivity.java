package kr.soen.practice3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b8 ,b9, b10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b8 = (Button)findViewById(R.id.button8);
        b9 = (Button)findViewById(R.id.button9);
        b10 = (Button)findViewById(R.id.button10);

    }

    public void onMyClick(View v){

        switch (v.getId()){

            case  R.id.button8:

                b8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent bb1 = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(bb1);
                    }
                });
                break;

            case  R.id.button9:

                b9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent bb2 = new Intent(MainActivity.this, Main3Activity.class);
                        startActivity(bb2);
                    }
                });
                break;
            case  R.id.button10:

                b10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent bb3 = new Intent(MainActivity.this, Main4Activity.class);
                        startActivity(bb3);
                    }
                });
                break;

        }

    }

}
