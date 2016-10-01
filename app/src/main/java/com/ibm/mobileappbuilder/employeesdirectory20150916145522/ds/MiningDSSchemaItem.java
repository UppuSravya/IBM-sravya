
package com.ibm.mobileappbuilder.employeesdirectory20150916145522.ds;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class MiningDSSchemaItem implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;

    @Override
    public String getIdentifiableId() {
      return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
    }

    public static final Creator<MiningDSSchemaItem> CREATOR = new Creator<MiningDSSchemaItem>() {
        @Override
        public MiningDSSchemaItem createFromParcel(Parcel in) {
            MiningDSSchemaItem item = new MiningDSSchemaItem();

            item.id = in.readString();
            return item;
        }

        @Override
        public MiningDSSchemaItem[] newArray(int size) {
            return new MiningDSSchemaItem[size];
        }
    };

}


