package tomerbu.edu.quizprep.gmail.models;

import android.text.TextUtils;

public class GmailModel {
    final String pictureUrl;
    final String message;


    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getMessage() {
        return message;
    }

    public GmailModel(String message, String pictureUrl) {
        this.message = message;
        if (!TextUtils.isEmpty(pictureUrl))
            this.pictureUrl = pictureUrl;
        else
            this.pictureUrl = "https://api.androidhive.info/json/google.png";
    }

    @Override
    public String toString() {
        return "GmailModel{" +
                "pictureUrl='" + pictureUrl + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}