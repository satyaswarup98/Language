package com.example.language;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumberFragment();
        }
//        else if (position == 1) {
//            return new PhrasesFragment();
//        } else if (position == 2) {
//            return new ColorsFragment();
//        }
        else {
            return new FamilyFragment();
        }
    }

    @Override
    public int getCount() {
        return 2; //change
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_numbers);
        }
//        else if (position == 1) {
//            return mContext.getString(R.string.category_phrases);
//        } else if (position == 2) {
//            return mContext.getString(R.string.category_colors);
//        }
        else {
            return mContext.getString(R.string.category_family);
        }
    }
}