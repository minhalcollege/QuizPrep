package tomerbu.edu.quizprep.gmail;

import android.os.Handler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
 import tomerbu.edu.quizprep.gmail.models.GmailModel;

/**
 * TODO: Internet Permission:
 */

public class GmailDataSource {
    // private final static String url = "https://api.androidhive.info/json/inbox.json";
    private final static OkHttpClient client = new OkHttpClient();

    public static void getGmail(final GmailListener listener, String url){
        Handler mainThread = new Handler();

        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                mainThread.post(()-> listener.onError(e));
            }

            public void onResponse(Call call, Response response) {
                try {
                    String json = response.body().string();
                    ArrayList<GmailModel> result = parseJson(json);
                    mainThread.post(()->listener.onResult(result));
                } catch (Exception e) {
                    mainThread.post(()-> listener.onError(e));
                }
            }
        });
    }

    private static ArrayList<GmailModel> parseJson(String json) throws JSONException {
        JSONArray arr = new JSONArray(json);
        ArrayList<GmailModel> gList = new ArrayList<>();

        for (int i = 0; i < arr.length(); i++) {
            JSONObject gmailObject = arr.getJSONObject(i);
            gList.add(new GmailModel(
                    gmailObject.getString("message"),
                    gmailObject.getString("picture")
            ));
        }
        return gList;
    }
}
