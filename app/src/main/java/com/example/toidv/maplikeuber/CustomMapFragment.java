package com.example.toidv.maplikeuber;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by TOIDV on 6/10/2016.
 */
public class CustomMapFragment extends SupportMapFragment {

    private View mOriginalView;

    private MapWrapperLayout mMapWrapperLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mOriginalView = super.onCreateView(inflater, container, savedInstanceState);
        mMapWrapperLayout = new MapWrapperLayout(getActivity());
        mMapWrapperLayout.addView(mOriginalView);
        return mMapWrapperLayout;
    }

    @Nullable
    @Override
    public View getView() {
        return mOriginalView;
    }


    public void setOnDragListener(MapWrapperLayout.OnDragListener listener) {
        mMapWrapperLayout.setOnDragListener(listener);
    }
}
