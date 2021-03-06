package tomerbu.edu.quizprep;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import tomerbu.edu.quizprep.gmail.GmailDataSource;
import tomerbu.edu.quizprep.gmail.GmailListener;
import tomerbu.edu.quizprep.gmail.models.GmailModel;

public class ScrollingActivity extends AppCompatActivity implements GmailListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GmailDataSource.getGmail(this, "https://api.androidhive.info/json/inbox.json");
    }

    @Override
    public void onResult(ArrayList<GmailModel> data) {
        Toast.makeText(this, data.toString()
                , Toast.LENGTH_SHORT).show();

        RecyclerView rvGmail = findViewById(R.id.rvGmail);
        rvGmail.setAdapter(new GmailAdapter(this, data));
        rvGmail.setLayoutManager(new LinearLayoutManager(null));

    }



    @Override
    public void onError(Exception e) {
        Toast.makeText(this, e.getMessage()
                , Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
