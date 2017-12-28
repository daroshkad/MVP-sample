package com.example.rxmvpdagger.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListCinema {

    private List<Cinema> list;

    public List<Cinema> getList() {
        return list;
    }

    public static class Cinema implements Parcelable {

        private String image;
        private String name;
        @SerializedName("name_eng")
        private String nameEng;
        private String premiere;
        private String description;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNameEng() {
            return nameEng;
        }

        public void setNameEng(String nameEng) {
            this.nameEng = nameEng;
        }

        public String getPremiere() {
            return premiere;
        }

        public void setPremiere(String premiere) {
            this.premiere = premiere;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.image);
            dest.writeString(this.name);
            dest.writeString(this.nameEng);
            dest.writeString(this.premiere);
            dest.writeString(this.description);
        }

        public Cinema() {
        }

        protected Cinema(Parcel in) {
            this.image = in.readString();
            this.name = in.readString();
            this.nameEng = in.readString();
            this.premiere = in.readString();
            this.description = in.readString();
        }

        public static final Parcelable.Creator<Cinema> CREATOR = new Parcelable.Creator<Cinema>() {
            @Override
            public Cinema createFromParcel(Parcel source) {
                return new Cinema(source);
            }

            @Override
            public Cinema[] newArray(int size) {
                return new Cinema[size];
            }
        };
    }
}
