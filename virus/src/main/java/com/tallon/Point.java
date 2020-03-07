package com.tallon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {
    private int x;
    private int y;

    /**
     * 位移
     */
    public void moveTo(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
