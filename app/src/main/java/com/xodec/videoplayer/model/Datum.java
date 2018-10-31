package com.xodec.videoplayer.model;

import android.net.Uri;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.URL;

public class Datum {

@SerializedName("id")
@Expose
private String id;
@SerializedName("image")
@Expose
private String image;
@SerializedName("video")
@Expose
private String video;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getImage() {
return image;
}

public void setImage(String image) {
this.image = image;
}

public String getVideo() {
return video;
}

public void setVideo(String video) {
this.video = video;
}

}