package tomerbu.edu.quizprep.gmail.models;

public class GmailModel {
    String pictureUrl = "https://api.androidhive.info/json/google.png";
    String message;

    public GmailModel(String message, String pictureUrl) {
        this.message = message;
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "GmailModel{" +
                "pictureUrl='" + pictureUrl + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}