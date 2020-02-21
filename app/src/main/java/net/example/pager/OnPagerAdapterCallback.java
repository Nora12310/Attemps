package net.example.pager;


import androidx.fragment.app.Fragment;

public interface OnPagerAdapterCallback {
    Fragment getItem(TabItem item, int position);
}
