package zyh.year16.service;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Wang on 2016/8/8.
 */
public final class Rect implements Parcelable{
    public int left;
    public int top;
    public int right;
    public int bottom;

    public Rect() {
    }

    protected Rect(Parcel in) {
        left = in.readInt();
        top = in.readInt();
        right = in.readInt();
        bottom = in.readInt();
    }

    public static final Creator<Rect> CREATOR = new Creator<Rect>() {
        @Override
        public Rect createFromParcel(Parcel parcel) {
            return new Rect(parcel);
        }

        @Override
        public Rect[] newArray(int i) {
            return new Rect[i];
        }
    };

    public void readFromParcel(Parcel in) {
        left = in.readInt();
        top = in.readInt();
        right = in.readInt();
        bottom = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flag) {
        dest.writeInt(left);
        dest.writeInt(top);
        dest.writeInt(right);
        dest.writeInt(bottom);
    }
}
