package jp.techacademy.minegishi.asaki.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);  // 足し算用ボタン
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);  // 引き算用ボタン
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);  // 掛け算用ボタン
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);  // 割り算用ボタン
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);  // 入力数値１
        mEditText2 = (EditText) findViewById(R.id.editText2);  // 入力数値２
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, SecondActivity.class);

        String putExtraData1 = mEditText1.getText().toString();
        String putExtraData2 = mEditText2.getText().toString();

        if (putExtraData1.length() != 0 && putExtraData2.length() != 0) {  // EditTextに値が入力されているかチェック
            intent.putExtra("VALUE1", putExtraData1);  // mEditText1に入力された値を渡す
            intent.putExtra("VALUE2", putExtraData2);  // mEditText2に入力された値を渡す
        }else {   // EditTextに値が入力されていなければ0を渡す
            intent.putExtra("VALUE1", "0");
            intent.putExtra("VALUE2", "0");
        }

        if (v.getId() == R.id.button1) {  // どのボタンを押されたかの情報を渡す
            intent.putExtra("VALUE3", 1);
        }else if (v.getId() == R.id.button2){
            intent.putExtra("VALUE3", 2);
        }else if (v.getId() == R.id.button3){
            intent.putExtra("VALUE3", 3);
        }else if (v.getId() == R.id.button4){
            intent.putExtra("VALUE3", 4);
        }
        startActivity(intent);
    }
}
