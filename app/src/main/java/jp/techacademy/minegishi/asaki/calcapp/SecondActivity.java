package jp.techacademy.minegishi.asaki.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();  // ActivityのgetIntentメソッドでIntentのインスタンスを取得

        String value1 = intent.getStringExtra("VALUE1");  // 初期値は"VALUE1"として、mEditText1に入力された値を受け取り、doubleに変換
        double data1 = Double.parseDouble(value1);

        String value2 = intent.getStringExtra("VALUE2");  // 初期値は"VALUE2"として、mEditText2に入力された値を受け取り、doubleに変換
        double data2 = Double.parseDouble(value2);

        int value3 = intent.getIntExtra("VALUE3", 0); //どのボタンが押されたかの情報を受け取る

        TextView textView = (TextView) findViewById(R.id.textView);

        if (value3 == 1){  // 押されたボタンの判別
            textView.setText(String.valueOf (data1 + data2));
        }else if (value3 == 2){
            textView.setText(String.valueOf (data1 - data2));
        }else if (value3 == 3){
            textView.setText(String.valueOf (data1 * data2));
        }else if (value3 == 4){
            textView.setText(String.valueOf (data1 / data2));
        }
    }
}
