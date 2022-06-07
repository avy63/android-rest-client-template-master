package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    public  String name;
    public  String img_url;
    public  String displayname;
    public  static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.name = jsonObject.getString("name");
        user.displayname = jsonObject.getString("screen_name");
        user.img_url = jsonObject.getString("profile_image_url_https");
        //I am new here
        return user;
    }
}
