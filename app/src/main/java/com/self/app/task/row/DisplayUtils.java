package com.self.app.task.row;

import android.graphics.Rect;
import android.text.TextPaint;

import java.util.Date;

/**
 * Created by ditesh on 1/11/14.
 */
public class DisplayUtils {

    public static String getTextOfLength (String text , TextPaint maxPaint, float maxWidth){

        Rect bound = new Rect();
        maxPaint.getTextBounds(text,0,text.length(),bound);
        float textLen = maxPaint.measureText(text,0,text.length()-1) ;
        if ( textLen <= maxWidth ){
            return text;
        }else {
            int start = 0;
            int j = text.length()-1;
            int end = j;
            while(!(maxPaint.measureText(text,start,j-1) <= maxWidth && maxPaint.measureText(text,start,j) >= maxWidth)){
                if (maxPaint.measureText(text,start,j) > maxWidth)
                    end = j;
                if (maxPaint.measureText(text,start,j) >= maxWidth){
                    j = (start+j)/2;
                }else {
                    j = (end+j)/2;
                }
            }
            return text.substring(start,j-3)+"...";
        }
    }

    public static String getSubtitleFromDeadline(Long deadline) {
        //TODO
        return (deadline == null) ? "" : new Date(deadline).toString();
    }
}
