package kr.soen.practice3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    Button b11,b12;
    EditText e1,e2,e3;
    TextView tv4, tv6;
    String kor, math, eng;
    int Intkor, Intmath, Inteng, total;
    double avg;
    ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("학점 계산기");


        init();

    }
    void init(){

        b11 = (Button)findViewById(R.id.button11);
        b12 = (Button)findViewById(R.id.button12);
        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText3);
        tv4 = (TextView)findViewById(R.id.textView4);
        tv6 = (TextView)findViewById(R.id.textView6);
        img2 = (ImageView)findViewById(R.id.imageView2);

        img2.setVisibility(View.INVISIBLE);

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                kor = e1.getText().toString();
                math = e2.getText().toString();
                eng = e3.getText().toString();

                //국어, 수학, 영어 값이 비어있는지 확인후, 없으면 0으로 설정해 줍니다!
                if(kor.equals("")){
                    Intkor = 0;
                }else{
                    Intkor = Integer.parseInt(kor);
                }

                if(math.equals("")){
                    Intmath =0;
                }else{
                    Intmath = Integer.parseInt(math);
                }

                if(eng.equals("")){
                    Inteng =0;
                }else{
                    Inteng = Integer.parseInt(eng);
                }
                total = Intkor + Intmath + Inteng;
                avg = total/3;

                tv4.setText(String.valueOf(total+"점"));
                tv6.setText(String.valueOf((int) avg+"점"));

                if(avg>=90){
                    img2.setImageResource(R.drawable.score_a);
                }else if(avg>=80 && avg<90){
                    img2.setImageResource(R.drawable.score_b);
                }else if(avg>=70 && avg<80){
                    img2.setImageResource(R.drawable.score_c);
                }else if(avg>=60 && avg<70){
                    img2.setImageResource(R.drawable.score_d);
                }else{
                    img2.setImageResource(R.drawable.score_f);

                }
                img2.setVisibility(View.VISIBLE);

            }
        });
        b12.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intkor=0;
                Intmath=0;
                Inteng=0;
                total=0;
                avg=0;
                tv4.setText(String.valueOf(total+"점"));
                tv6.setText(String.valueOf((int) avg+"점"));
                e1.setText("");
                e2.setText("");
                e3.setText("");

                Toast.makeText(getApplicationContext(),"초기화 되었습니다.",Toast.LENGTH_SHORT).show();
                //화면에서 보이지 않게 설정합니다.
                img2.setVisibility(View.GONE);
            }
        });


    }

}
