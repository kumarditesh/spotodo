package com.self.app.enums;

import android.graphics.Color;

import com.self.app.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ditesh on 1/11/14.
 */
public enum Priority {
    HIGH(0, R.color.PRIO_HIGH_COLOR),
    MEDIUM(1,R.color.PRIO_MEDIUM_COLOR),
    LOW(2, R.color.PRIO_LOW_COLOR);

    private static Map<Integer,Priority> priorityMap= new HashMap<Integer, Priority>();

    static {
        for (Priority prio: values()){
            priorityMap.put(prio.getValue(),prio);
        }
    }

    private final int value;
    private final int color;

    private Priority(final int newValue, int color) {
        value = newValue;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public static Priority getPriorityFromValue(int value){
        return priorityMap.get(value);
    }

    public int getValue() { return value; }
}
