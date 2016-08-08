package zyh.year16.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;

import zyh.year16.IRemoteService;

public class RemoteService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {
        @Override
        public int getPid() throws RemoteException {
            return Process.myPid();
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
