package com.jwtest.mokada.jwapptest1;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends ListFragment {

    private int lastTop = 0;
    View headerView;
    ArrayAdapter<String> listAdapter;
    ImageView headerImage;


    public void parallax(final View v) {
        final Rect r = new Rect();
        v.getLocalVisibleRect(r);
        if (lastTop != r.top) {
            lastTop = r.top;
            v.post(new Runnable() {
                @Override
                public void run() {
                    v.setY((float)(r.top / 2.0));
                }
            });
        }

    }
    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        headerView = inflater.inflate(R.layout.about_header, null, false);
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        headerImage = (ImageView) headerView.findViewById(R.id.about_banner);

        String[] aboutContent = new String[] {getString(R.string.mission_title), getString(R.string.mission_statement)};

        ArrayList<String> aboutList = new ArrayList<String>();
        aboutList.addAll(Arrays.asList(aboutContent));
        listAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.simplerow, aboutList);

        getListView().addHeaderView(headerView);
        this.setListAdapter(listAdapter);
        this.getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                parallax(headerImage);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                parallax(headerImage);
            }
        });
    }

}
