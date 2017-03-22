package kr.soen.practice3;

import android.content.Intent;
import static android.R.attr.calendarTextColor;
import static android.R.attr.value;
import android.support.v7.widget.LinearLayoutCompat;

import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Build;
import android.os.Handler;
import android.os.Message;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Main4Activity extends AppCompatActivity {

    int value = 0;
    int page = 1;

    LinearLayout page1,page2,page4;
    GridLayout page3;
    FrameLayout framelayout;
    EditText adult,teenager,kid;
    TimePicker timePicker;

    TextView textview;
    Switch aSwitch;
    Button b1,b2;
    DatePicker datePicker;

    TextView text1,text2,text3,text4,text5;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setTitle("레스토랑 예약시스템");

        init();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    void init(){
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        datePicker =(DatePicker)findViewById(R.id.datePicker);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        page1 = (LinearLayout)findViewById(R.id.page1);
        page2 = (LinearLayout)findViewById(R.id.page2);
        page3 = (GridLayout)findViewById(R.id.page3);
        page4 = (LinearLayout)findViewById(R.id.page4);
        adult = (EditText)findViewById(R.id.editText1);
        teenager = (EditText)findViewById(R.id.editText2);
        kid = (EditText)findViewById(R.id.editText3);
        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        text3 = (TextView)findViewById(R.id.text3);
        text4 = (TextView)findViewById(R.id.text4);
        text5 = (TextView)findViewById(R.id.text5);
        aSwitch = (Switch)findViewById(R.id.switch1);
        textview = (TextView)findViewById(R.id.textView);
        framelayout = (FrameLayout)findViewById(R.id.framlayout);


        final GregorianCalendar gregorianCalendar = new GregorianCalendar();
        datePicker.init(gregorianCalendar.get(Calendar.YEAR),gregorianCalendar.get(Calendar.MONTH)+1
                ,gregorianCalendar.get(Calendar.DAY_OF_MONTH),null);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){

                    page1.setVisibility(View.VISIBLE);

                    b1.setVisibility(View.VISIBLE);
                    b2.setVisibility(View.VISIBLE);
                    timeHandler.sendEmptyMessage(0);
                    framelayout.setVisibility(View.VISIBLE);
                    b1.setEnabled(false);
                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(page == 1){
                                page1.setVisibility(View.INVISIBLE);
                                page2.setVisibility(View.VISIBLE);
                                page++;
                                b1.setEnabled(true);
                            } else if(page ==2) {
                                page2.setVisibility(View.INVISIBLE);
                                page3.setVisibility(View.VISIBLE);
                                page++;
                            } else if(page == 3) {
                                //inputs
                                String inputadult,inputteenager,inputkid;
                                inputadult = adult.getText().toString();
                                inputteenager = teenager.getText().toString();
                                inputkid = kid.getText().toString();


                                if (inputadult.getBytes().length <=0) inputadult = "0";
                                if (inputteenager.getBytes().length<=0) inputteenager = "0";
                                if (inputkid.getBytes().length <=0) inputkid = "0";
                                if(Integer.parseInt(inputadult) == 0 && Integer.parseInt(inputkid)
                                        == 0 && Integer.parseInt(inputteenager) == 0){
                                    Toast.makeText(getApplication(), "0명은 예약할 수 없습니다. 다시입력해 주세요."
                                            ,Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                page3.setVisibility(View.INVISIBLE);
                                page4.setVisibility(View.VISIBLE);
                                page++;
                                b2.setEnabled(false);
                                text1.setText(datePicker.getYear()+"년 "+datePicker.getMonth()+"월 "
                                        +datePicker.getDayOfMonth()+"일");
                                text2.setText(timePicker.getHour()+"시 "+timePicker.getMinute()+"분");
                                text3.setText(Integer.parseInt(inputadult)+"명");
                                text4.setText(Integer.parseInt(inputteenager)+"명");
                                text5.setText(Integer.parseInt(inputkid)+"명");


                            }
                        }
                    });

                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(page == 2){
                                page2.setVisibility(View.INVISIBLE);
                                page1.setVisibility(View.VISIBLE);
                                page--;
                                b1.setEnabled(false);
                            } else if(page ==3) {
                                page3.setVisibility(View.INVISIBLE);
                                page2.setVisibility(View.VISIBLE);
                                page--;
                            } else if(page == 4) {
                                page4.setVisibility(View.INVISIBLE);
                                page3.setVisibility(View.VISIBLE);
                                page--;
                                b2.setEnabled(true);

                            }
                        }
                    });



                }
                else{

                    timeHandler.removeMessages(0);
                    value = 0;
                    page = 1;
                    page1.setVisibility(View.INVISIBLE);
                    datePicker.init(gregorianCalendar.get(Calendar.YEAR),gregorianCalendar.get(Calendar.MONTH)+1
                            ,gregorianCalendar.get(Calendar.DAY_OF_MONTH),null);
                    page2.setVisibility(View.INVISIBLE);
                    timePicker.setCurrentHour(gregorianCalendar.get(Calendar.HOUR));
                    timePicker.setCurrentMinute(gregorianCalendar.get(Calendar.MINUTE));
                    page3.setVisibility(View.INVISIBLE);
                    adult.setText(null);
                    teenager.setText(null);
                    kid.setText(null);

                    page4.setVisibility(View.INVISIBLE);
                    framelayout.setVisibility(View.INVISIBLE);
                    b1.setVisibility(View.INVISIBLE);
                    b2.setVisibility(View.INVISIBLE);
                    b1.setEnabled(false);
                    b2.setEnabled(true);
                    textview.setText("예약시작 경과시간 : 00:00");

                }

            }
        });


    }
    Handler timeHandler = new Handler() {
        public void handleMessage(Message msg) {
            String mint,sect;
            int sec = value%60;
            int min = value/60;
            sect = String.format("%02d",sec);
            mint = String.format("%02d",min);
            textview.setText("예약시작경과시간 : "+mint+":"+sect);
            value = value+1;
            timeHandler.sendEmptyMessageDelayed(0,1000);
        }
    };



}


