package com.example.bpnsa.parsingtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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

public class GalleryActivity extends AppCompatActivity {
    GalleryAdapter madapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        RecyclerView galleryRecycle= (RecyclerView) findViewById(R.id.galleryRc);
        galleryRecycle.setLayoutManager(new LinearLayoutManager(this));

        madapter=new GalleryAdapter(this);
        galleryRecycle.setAdapter(madapter);

        sendJsonGalleryObjectRequest();


    }

    private void sendJsonGalleryObjectRequest() {

        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET,
                "http://cm.yarshastudio.com/api/gallery/photoalbums",
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("tag",response.toString());

                        ArrayList<GallerySingleRow> data=parseData(response);

                       madapter.setData(data);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().getQueue().add(request);
    }

    private ArrayList<GallerySingleRow> parseData(JSONObject response) {
        ArrayList<GallerySingleRow> temp=new ArrayList<>();
        try {
            JSONArray data = response.getJSONArray("data");

            for (int i=0;i<data.length();i++)
            {
                JSONObject item=data.getJSONObject(i);
                String galleryName=item.getString("albumName");
                String galleryDate=item.getString("albumCreated");
                String galleryImage=item.getString("albumImage");
                temp.add(new GallerySingleRow(galleryImage,galleryName,galleryDate));


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return  temp;
    }
}
