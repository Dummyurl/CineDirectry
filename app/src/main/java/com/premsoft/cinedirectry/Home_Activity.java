package com.premsoft.cinedirectry;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 2/22/2018.
 */

public class Home_Activity extends Fragment {
//    private static ViewPager mPager;
//    private static int currentPage = 0;
//    private static int NUM_PAGES = 0;
//    private static final Integer[] IMAGES= {R.drawable.c7};
//    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
//
//
   View view ;
//    CirclePageIndicator indicator;
//
////    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);


    public Home_Activity() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         view = inflater.inflate(R.layout.activity_home, container, false);


//        mPager = (ViewPager) view.findViewById(R.id.pager);
//         indicator = (CirclePageIndicator)
//                view.findViewById(R.id.indicator);

     //   init();



        return view;
    }



//    private void init() {
//        for(int i=0;i<IMAGES.length;i++)
//            ImagesArray.add(IMAGES[i]);
//
//
//
//        mPager.setAdapter(new SlidingImage_Adapter(getActivity(),ImagesArray));
//
//
//
//        indicator.setViewPager(mPager);
//
//        final float density = getResources().getDisplayMetrics().density;
//
////Set circle indicator radius
//        indicator.setRadius(3 * density);
//
//        NUM_PAGES =IMAGES.length;
//
//        // Auto start of viewpager
//        final Handler handler = new Handler();
//        final Runnable Update = new Runnable() {
//            public void run() {
//                if (currentPage == NUM_PAGES) {
//                    currentPage = 0;
//                }
//                mPager.setCurrentItem(currentPage++, true);
//            }
//        };
//        Timer swipeTimer = new Timer();
//        swipeTimer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        }, 1500, 1500);
//
//        // Pager listener over indicator
//        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            @Override
//            public void onPageSelected(int position) {
//                currentPage = position;
//
//            }
//
//            @Override
//            public void onPageScrolled(int pos, float arg1, int arg2) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int pos) {
//
//            }
//        });
//
//    }
}
