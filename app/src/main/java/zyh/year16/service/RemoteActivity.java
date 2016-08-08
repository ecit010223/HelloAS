package zyh.year16.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import zyh.year16.IRemoteService;
import zyh.year16.R;

public class RemoteActivity extends Activity {
    private IRemoteService mIRemoteService;
    private boolean mBound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            /**
             * Following the example above for an AIDL interface,
             * this gets an instance of the IRemoteInterface, which we can use to call on the service
             */
            mIRemoteService = IRemoteService.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mIRemoteService = null;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this,RemoteService.class),mConnection, Context.BIND_AUTO_CREATE);
        mBound = true;
    }

    public void getPid(View v) {
        if (!mBound) return;
        try {
            Toast.makeText(RemoteActivity.this,mIRemoteService.getPid(),Toast.LENGTH_SHORT).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
