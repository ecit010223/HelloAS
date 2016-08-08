package zyh.year16;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zyh.year16.fragment.FragmentLayout;
import zyh.year16.fragment.MainFragment;
import zyh.year16.service.LocalActivity;
import zyh.year16.service.MessengerActivity;
import zyh.year16.service.RemoteActivity;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = (Button)findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent =null;
        switch (view.getId()){
            case R.id.btn1:
                intent = new Intent(MainActivity.this, MainFragment.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(MainActivity.this, FragmentLayout.class);
                startActivity(intent);
                break;
            case R.id.btn3:
                intent = new Intent(MainActivity.this, RemoteActivity.class);
                startActivity(intent);
                break;
            case R.id.btn4:
                intent = new Intent(MainActivity.this, LocalActivity.class);
                startActivity(intent);
                break;
            case R.id.btn5:
                intent = new Intent(MainActivity.this, MessengerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
