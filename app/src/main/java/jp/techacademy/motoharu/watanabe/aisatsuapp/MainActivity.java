package jp.techacademy.motoharu.watanabe.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.TimePickerDialog;
import android.widget.Button;
import android.view.View;
import android.util.Log;
import android.widget.TextView;
import android.widget.TimePicker;
import android.support.v7.app.AlertDialog;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;
    TimePickerDialog timePickerDialog;
    int hourOfDay;
    int minute;
    String comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.button1){
            showTimePickerDialog();
            Log.d("UI-PARTS",hourOfDay+":"+minute);
        }else if(v.getId()==R.id.button2){
            mTextView.setText(comment);
        }
    }


    public void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS3", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        if(2 <= hourOfDay && hourOfDay < 10 ) {
                            comment = "「おはよう」";
                        }else if(10 <= hourOfDay && hourOfDay < 18 ) {
                            comment = "「こんにちは」";
                        }else if(hourOfDay<2 || 18 <=hourOfDay){
                            comment = "「こんばんは」";
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}
