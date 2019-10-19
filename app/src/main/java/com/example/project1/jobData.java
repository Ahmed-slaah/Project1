package com.example.project1;

import android.os.Parcel;
import android.os.Parcelable;

public class jobData implements Parcelable {
    String name ;
    String start ;
    String end ;

    public jobData() {
    }

    public jobData(String name, String start, String end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    protected jobData(Parcel in) {
        name = in.readString();
        start = in.readString();
        end = in.readString();
    }

    public static final Creator<jobData> CREATOR = new Creator<jobData>() {
        @Override
        public jobData createFromParcel(Parcel in) {
            return new jobData(in);
        }

        @Override
        public jobData[] newArray(int size) {
            return new jobData[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(start);
        parcel.writeString(end);
    }
}
