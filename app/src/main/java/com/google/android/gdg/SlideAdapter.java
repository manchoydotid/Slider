package com.google.android.gdg;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by MANCHOY on 12/17/2017.
 */

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    //list of image
    public int[] list_image = {
            R.drawable.nur1,
            R.drawable.nur2,
            R.drawable.nur2,
    };

    //list of title
    public String[] list_title ={
            "COSMIC",
            "SATELITE",
            "GRAVITY",
    };

    //list of desc
    public String[] list_desc = {
            "Cosmic is the best",
            "Satelite is the best",
            "Gravity of earth",
    };

    //list background
    public int[] list_backgroundcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(1,188,212),
    };

    public SlideAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);

        LinearLayout layoutslide = view.findViewById(R.id.slidelayout);
        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);
        TextView textslide = (TextView) view.findViewById(R.id.txttitle);
        TextView textdesc = (TextView) view.findViewById(R.id.textdesc);

        layoutslide.setBackgroundColor(list_backgroundcolor[position]);
        imgslide.setImageResource(list_image[position]);
        textslide.setText(list_title[position]);
        textdesc.setText(list_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);

    }
}
