package com.utility;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by amirk on 9/20/2016.
 */
public class VazirTextView extends TextView {

    Context context;
    String ttfName;

    String TAG = getClass().getName();

    public VazirTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;


            init();


    }

    private void init() {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/vazir.ttf");
        setTypeface(font);
    }

    @Override
    public void setTypeface(Typeface tf) {

        // TODO Auto-generated method stub
        super.setTypeface(tf);
    }
    @Override
    public void setText(CharSequence text, BufferType type) {
        if (text != null)
            text = FormatHelper.toPersianNumber(text.toString());
        super.setText(text, type);
    }

}
