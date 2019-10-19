package com.example.project1;

import android.os.Parcel;
import android.os.Parcelable;

public class UpdateData implements Parcelable {
    String start ;
    String end ;

    public UpdateData() {
    }

    public UpdateData(String start, String end) {
        this.start = start;
        this.end = end;
    }

    protected UpdateData(Parcel in) {
        start = in.readString();
        end = in.readString();
    }

    public static final Creator<UpdateData> CREATOR = new Creator<UpdateData>() {
        @Override
        public UpdateData createFromParcel(Parcel in) {
            return new UpdateData(in);
        }

        @Override
        public UpdateData[] newArray(int size) {
            return new UpdateData[size];
        }
    };

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
        parcel.writeString(start);
        parcel.writeString(end);
    }
}
