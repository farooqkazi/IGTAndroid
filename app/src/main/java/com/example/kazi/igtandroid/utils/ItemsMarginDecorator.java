package com.example.kazi.igtandroid.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Kazi on 5/12/2017.
 */

public class ItemsMarginDecorator extends RecyclerView.ItemDecoration {

    private final int mSpaceSize;

    public ItemsMarginDecorator(int spaceSize) {
        mSpaceSize = spaceSize;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);

        if (position < 1) {
            outRect.top = mSpaceSize;
        } else {
            outRect.top = 0;
        }
        outRect.left = mSpaceSize;
        outRect.right = mSpaceSize;
        outRect.bottom = mSpaceSize;
    }
}
