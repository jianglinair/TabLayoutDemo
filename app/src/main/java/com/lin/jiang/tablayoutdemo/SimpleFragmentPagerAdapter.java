package com.lin.jiang.tablayoutdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Driver;

/**
 *
 * @author jianglin
 * @date 17-10-31
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    public static final int PAGE_COUNT = 3;

    private String[] titles = {"推荐", "新闻", "视频"};
    private int[] imgs = {R.drawable.ic_one, R.drawable.ic_two, R.drawable.ic_three};
    private Context mContext;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
//        Drawable image = mContext.getResources().getDrawable(imgs[position], null);
//        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
//        SpannableString sapn = new SpannableString(" " + titles[position]);
//        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//        sapn.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return sapn;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position);
    }

    public View getTabView(int position){
        View view = LayoutInflater.from(mContext).inflate(R.layout.tab_item, null);
        TextView tv= view.findViewById(R.id.textView);
        tv.setText(titles[position]);
        ImageView img = view.findViewById(R.id.imageView);
        img.setImageResource(imgs[position]);
        return view;
    }
}
