package net.example.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import net.example.R;

public class MaxHeightRecyclerView extends RecyclerView {
    public MaxHeightRecyclerView(@NonNull Context context) {
        super(context);
    }

    public MaxHeightRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MaxHeightRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int maxHeight = getContext().getResources().getDimensionPixelOffset(R.dimen._300sdp);
        heightSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, heightSpec);
    }
}
