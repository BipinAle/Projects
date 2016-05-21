package com.example.bpnsa.parsingtest;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.bpnsa.parsingtest.volley.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BlogActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private BlogListAdapter mAdapter;
    private SwipeRefreshLayout pullToRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        pullToRef= (SwipeRefreshLayout) findViewById(R.id.pullToRef);
        pullToRef.setOnRefreshListener(this);

        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.rc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter=new BlogListAdapter(this);
        recyclerView.setAdapter(mAdapter);



        sendJsonRequest();

    }


    private void sendJsonRequest() {

        enableProgress();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                "http://cmprachanda.com/app/api/blog/bloglist",
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        disableProgress();
                        Log.i("Tag", "api data" + response.toString());
                        ArrayList<BlogSingleRow> data=parseData(response);
                        mAdapter.setData(data);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                disableProgress();
                Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_LONG).show();

            }
        });

        VolleySingleton.getInstance().getQueue().add(request);
    }


    private void enableProgress(){
        pullToRef.post(new Runnable() {
            @Override
            public void run() {
                pullToRef.setEnabled(true);
            }
        });
    }
    private void disableProgress(){
        pullToRef.post(new Runnable() {
            @Override
            public void run() {
                pullToRef.setEnabled(false);
            }
        });
    }
    private ArrayList<BlogSingleRow> parseData(JSONObject response) {

        ArrayList<BlogSingleRow> tmp=new ArrayList<>();
        try {
            JSONArray data =response.getJSONArray("data");
            for (int i=0;i<data.length();i++)
            {
                JSONObject item=data.getJSONObject(i);
                String blogtitle=item.getString("blogTitle");
                String blogimage=item.getString("blogImage");
                JSONObject date=item.getJSONObject("blogDate");
                String blogdate=date.getString("date");
                tmp.add(new BlogSingleRow(blogimage,blogtitle,blogdate));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tmp;

    }

    @Override
    public void onRefresh() {
        sendJsonRequest();
    }



}
