package com.soccer.myapplication;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class CustomPageAdapter extends PagerAdapter {
    private Context mContext;

    public CustomPageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ModelObject modelObject=ModelObject.values()[position];
        LayoutInflater inflater=LayoutInflater.from(mContext);
        ViewGroup layout=(ViewGroup)
                inflater.inflate(modelObject.getmLayoutResId(),container,false);
        container.addView(layout);
        return layout;

       // return super.instantiateItem(container, position);
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return ModelObject.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
    public CharSequence getPageTitle(int position){
        ModelObject customPagerEnum=ModelObject.values()[position];
        return mContext.getString(customPagerEnum.getmTitleResId());
    }


}
