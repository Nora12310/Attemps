package net.example.pager;

import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private OnPagerAdapterCallback callback;
    private List<TabItem> mItems;
    private SparseArray<Fragment> mSparseArray;
    private boolean isShowTitle = true;

    public PagerAdapter(FragmentManager fm, OnPagerAdapterCallback callback) {
        super(fm);
        mSparseArray = new SparseArray<>();
        this.callback = callback;
        mItems = new ArrayList<>();
    }

    @NotNull
    @Override
    public Fragment getItem(int position) {
        return callback.getItem(mItems.get(position), position);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Object object = super.instantiateItem(container, position);
        mSparseArray.put(position, (Fragment) object);
        return object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        mSparseArray.remove(position);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return isShowTitle
                ? mItems.get(position).getName()
                : super.getPageTitle(position);
    }

    public List<TabItem> getItems() {
        return mItems;
    }

    public void setItems(List<TabItem> mItems) {
        this.mItems = mItems;
        notifyDataSetChanged();
    }

    public boolean isShowTitle() {
        return isShowTitle;
    }

    public void setShowTitle(boolean isShowTitle) {
        this.isShowTitle = isShowTitle;
    }

    public Fragment findFragmentByPosition(int position){
        return mSparseArray.get(position);
    }
}
