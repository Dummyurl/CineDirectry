package com.premsoft.cinedirectry;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 2/22/2018.
 */

public class NewsActivity extends Fragment{


//    List<DataAdapter> ListOfdataAdapter;
//
//    RecyclerView recyclerView;
//
//    String HTTP_JSON_URL = "http://androidblog.esy.es/ImageJsonData.php";
//
//    String Image_Name_JSON = "image_title";
//
//    String Image_URL_JSON = "image_url";
//
//    JsonArrayRequest RequestOfJSonArray ;
//
//    RequestQueue requestQueue ;
//
//    View view ;
//
//    int RecyclerViewItemPosition ;
//
//    RecyclerView.LayoutManager layoutManagerOfrecyclerView;
//
//    RecyclerView.Adapter recyclerViewadapter;
//
//    ArrayList<String> ImageTitleNameArrayListForClick;

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_news);
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitle("Hi Cinema Directory");

    public NewsActivity() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

      //  View rootView = inflater.inflate(R.layout.activity_news, container, false);
        View rootView = inflater.inflate(R.layout.faq_activity, container, false);
//        ImageTitleNameArrayListForClick = new ArrayList<>();
//
//        ListOfdataAdapter = new ArrayList<>();
//
//        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview1);
//
//        recyclerView.setHasFixedSize(true);
//
//        layoutManagerOfrecyclerView = new LinearLayoutManager(getActivity());
//
//        recyclerView.setLayoutManager(layoutManagerOfrecyclerView);
//
//        JSON_HTTP_CALL();
//
//        // Implementing Click Listener on RecyclerView.
//        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//
//            GestureDetector gestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {
//
//                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {
//
//                    return true;
//                }
//
//            });
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
//
//                view = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
//
//                if(view != null && gestureDetector.onTouchEvent(motionEvent)) {
//
//                    //Getting RecyclerView Clicked Item value.
//                    RecyclerViewItemPosition = Recyclerview.getChildAdapterPosition(view);
//
//                    // Showing RecyclerView Clicked Item value using Toast.
//                    Toast.makeText(getActivity(), ImageTitleNameArrayListForClick.get(RecyclerViewItemPosition), Toast.LENGTH_LONG).show();
//
//                    Intent intent = new Intent(getActivity(),Details_Activity.class);
//                    startActivity(intent);
//                }
//
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });
        return rootView;
    }



//    public void JSON_HTTP_CALL(){
//
//        RequestOfJSonArray = new JsonArrayRequest(HTTP_JSON_URL,
//
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//
//                        ParseJSonResponse(response);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                });
//
//        requestQueue = Volley.newRequestQueue(getActivity());
//        requestQueue.add(RequestOfJSonArray);
//    }
//
//    public void ParseJSonResponse(JSONArray array){
//
//        for(int i = 0; i<array.length(); i++) {
//
//            DataAdapter GetDataAdapter2 = new DataAdapter();
//
//            JSONObject json = null;
//            try {
//                json = array.getJSONObject(i);
//
//                GetDataAdapter2.setImageTitle(json.getString(Image_Name_JSON));
//
//                // Adding image title name in array to display on RecyclerView click event.
//                ImageTitleNameArrayListForClick.add(json.getString(Image_Name_JSON));
//
//                GetDataAdapter2.setImageUrl(json.getString(Image_URL_JSON));
//
//            } catch (JSONException e) {
//
//                e.printStackTrace();
//            }
//            ListOfdataAdapter.add(GetDataAdapter2);
//        }
//        recyclerViewadapter = new RecyclerViewAdapter(ListOfdataAdapter, getActivity());
//
//        recyclerView.setAdapter(recyclerViewadapter);
//    }
}
