package com.utility;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


public class VazirBoldTextView extends TextView {
    Context context;
    String ttfName;

    String TAG = getClass().getName();

    public VazirBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;


        init();


    }

    private void init() {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/vazirbold.ttf");
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
