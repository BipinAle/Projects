package com.example.bpnsa.parsingtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.bpnsa.parsingtest.volley.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FotoCollnActivity extends AppCompatActivity {
    private  static final String TAG=FotoCollnActivity.class.getSimpleName();
    FotoCollnAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_colln);
        RecyclerView FotoCollnRc= (RecyclerView) findViewById(R.id.fotocollnRc);
        FotoCollnRc.setLayoutManager(new GridLayoutManager(this,2));
        madapter=new FotoCollnAdapter(this);
        FotoCollnRc.setAdapter(madapter);

        sendJsonFotoCollnRequest();


    }

    private void sendJsonFotoCollnRequest() {

        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET,
                "http://cm.yarshastudio.com/api/gallery/allimages/7",
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ArrayList<FotoCollnSingleRow> data=parseData(response);
                        madapter.setData(data);


                    }
                },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        VolleySingleton.getInstance().getQueue().add(request);
    }

    private ArrayList<FotoCollnSingleRow> parseData(JSONObject response) {
        Log.v(TAG,response.toString());
        ArrayList<FotoCollnSingleRow> temp = new ArrayList<>();
        try {

            JSONArray data = response.getJSONArray("data");
            for (int i=0;i<data.length();i++)
            {
                JSONObject item=data.getJSONObject(i);
                String image=item.getString("image");
                temp.add(new FotoCollnSingleRow(image));
                Log.v(TAG, image);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return temp;
    }
}
