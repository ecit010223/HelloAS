package zyh.year16.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import zyh.year16.R;

public class LocalActivity extends Activity {
    private LocalService mService;
    private boolean mBind = false;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LocalService.LocalBinder mBinder = (LocalService.LocalBinder)iBinder;
            mService = mBinder.getService();
            mBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mBind = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,LocalService.class);
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mBind){
            unbindService(mConnection);
            mBind = false;
        }
    }

    public void getRandomNumber(View v){
        if(mBind){
            Toast.makeText(this,mService.getRandomNumber(),Toast.LENGTH_SHORT).show();
        }
    }
}
