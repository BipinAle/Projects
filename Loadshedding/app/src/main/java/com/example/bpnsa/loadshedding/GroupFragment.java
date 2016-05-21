package com.example.bpnsa.loadshedding;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.bpnsa.loadshedding.volley.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private int gid;
    private SwipeRefreshLayout pullToRef;
    private static final String URL="https://raw.githubusercontent.com/javanux/garbage/master/loadshedding.json";
    private GroupAdapter gAdapter;

    public GroupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        gid = b.getInt("gid");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_group, container, false);

        pullToRef = (SwipeRefreshLayout) view.findViewById(R.id.swipeToRefresh);
        pullToRef.setOnRefreshListener(this);

        gAdapter = new GroupAdapter(getContext());

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rc);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(gAdapter);

        sendJSONRequest();
        return  view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

    }

    private void sendJSONRequest() {


        enableProgress();
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,URL
                ,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Log.e("response",response.toStrin
                        // g());
                        try {

                            disableProgress();
                            ArrayList<RoutineItem> data = parseData(response);//whole arraylist
                            gAdapter.setData(filterGroup(data, gid));


//                            for(int i=0;i<filteredData.size();i++)
//                            {
//                               RoutineItem DayItem=filteredData.get(i);
//                                String rDay=DayItem.getDay();
//
//
//
//                                Calendar calendar=Calendar.getInstance();
//                                int cDay=calendar.get(Calendar.DAY_OF_WEEK);
//
//                                if(rDay==cDay+"")
//                                {
//                                    TextView  textView= (TextView) getActivity().findViewById(R.id.day);
//                                    textView.setBackgroundColor(0x0000FF00 );
//                                    textView.invalidate();
//                                }
//                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }


                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        disableProgress();

                        Toast.makeText(getActivity(), "something went wrong", Toast.LENGTH_LONG).show();

                    }
                }


        );
        VolleySingleton.getInstance().getQueue().add(request);
    }


    private void enableProgress() {
        pullToRef.post(new Runnable() {
            @Override
            public void run() {
                pullToRef.setEnabled(true);
            }
        });
    }

    private void disableProgress() {
        pullToRef.post(new Runnable() {
            @Override
            public void run() {
                pullToRef.setEnabled(false);
            }
        });
    }

    private ArrayList<RoutineItem> filterGroup(ArrayList<RoutineItem> data, int gid) {


        ArrayList<RoutineItem> fData = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            RoutineItem routineItem = data.get(i);
            String group = routineItem.getGroup();
            int groupN = Integer.parseInt(group);


            if (groupN == gid) {
                fData.add(routineItem);
            }
        }

        return fData;
    }

    private ArrayList<RoutineItem> parseData(JSONObject response) throws JSONException {
        ArrayList<RoutineItem> tmp = new ArrayList<>();
        JSONObject routine = response.getJSONObject("routine");
        JSONArray group = routine.getJSONArray("group");

        for (int i = 0; i < group.length(); i++) {
            JSONObject groupItem = group.getJSONObject(i);
            String samuhaNumber = groupItem.getString("-name");

            JSONArray days = groupItem.getJSONArray("day");

            for (int j = 0; j < days.length(); j++) {
                JSONObject day = days.getJSONObject(j);
                String dayName = day.getString("-name");
                JSONArray timeTables = day.getJSONArray("item");

                String time1 = timeTables.getString(0);
                String time2 = timeTables.getString(1);
                tmp.add(new RoutineItem(samuhaNumber, dayName, time1, time2));


            }
        }


        return tmp;
    }

    @Override
    public void onRefresh() {
        sendJSONRequest();
    }
}
