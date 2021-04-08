package com.soccer.myapplication;

public enum ModelObject {

    RED(R.string.red, R.layout.view_red1),
    BLUE(R.string.blue, R.layout.view_blue1),
    GREEN(R.string.green, R.layout.view_green);
    private int mTitleResId;
    private int mLayoutResId;

    public int getmLayoutResId() {
        return mLayoutResId;
    }

    public int getmTitleResId() {
        return mTitleResId;
    }

    ModelObject(int titleResId, int layoutResId){
        mTitleResId = titleResId;
        mLayoutResId=layoutResId;

    }
}
