package com.tallon;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Hospital extends Point {

    public static final int HOSPITAL_X = 720;
    public static final int HOSPITAL_Y = 80;
    private int width;
    private int heigh = 600;

    public int getWidth() {
        return width;
    }

    public int getHeigh() {
        return heigh;
    }

    private static Hospital hospital = new Hospital();

    public static Hospital getInstance() {
        return hospital;
    }

    // 第一个床位所在坐标，用于给其他床位定绝对坐标
    private Point point = new Point(HOSPITAL_X, HOSPITAL_Y);

    private List<Bed> beds = new ArrayList<>();

    public Hospital(int x, int y) {
        super(x, y);
    }

    /**
     * 获取所有床位
     * @return
     */
    public List<Bed> getBeds() {
        return beds;
    }

    private Hospital() {
        // 医院矩形所在坐标
        super(HOSPITAL_X, HOSPITAL_Y + 10);
        // 根据床位数量调整医院矩形大小
        if (Constants.BED_COUNT == 0) {
            width = 0;
            heigh = 0;
        }
        // 根据医院床位数量计算医院宽度
        // 因为高度定了只能装载100个床位
        int column = Constants.BED_COUNT / 100;
        width = column * 6;
        // 根据第一个床位坐标初始化其他床位的坐标
        for (int i = 0; i < column; i++) {

            for (int j = 10; j <= 606; j += 6) {

                Bed bed = new Bed(point.getX() + i * 6, point.getY() + j);
                beds.add(bed);
                // 确定医院床位承载数量
                if (beds.size() >= Constants.BED_COUNT) {
                    break;
                }
            }
        }
    }

    /**
     * 使用床位
     * @return
     */
    public Bed pickBed() {
        for (Bed bed : beds) {
            if (bed.isEmpty()) {
                return bed;
            }
        }
        return null;
    }

    /**
     * 死亡或痊愈空出床位
     * @param bed
     * @return
     */
    public Bed returnBed(Bed bed) {
        if (bed != null) {
            bed.setEmpty(true);
        }
        return bed;
    }
}
