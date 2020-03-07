package com.tallon;

import lombok.Data;

/**
 * 位移目标对象
 */
@Data
public class MoveTarget {
    private int x;
    private int y;
    /**
     * 是否到达目标点
     */
    private boolean arrived=false;

    public MoveTarget(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
