package com.tallon;

import lombok.Data;

/**
 * 城市描述对象
 */
@Data
public class City {
    private int centerX;
    private int centerY;

    public City(int centerX, int centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }
}
