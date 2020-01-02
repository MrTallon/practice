package stream;

import java.util.ArrayList;
import java.util.List;

public class StreamFactory {

    private static StreamFactory peopleMap;

    private StreamFactory() {
    }

    public static StreamFactory getInstance() {
        if (peopleMap == null) {
            synchronized (StreamFactory.class) {
                if (peopleMap == null) {
                    peopleMap = new StreamFactory();
                }
            }
        }
        return peopleMap;
    }

    public List<People> getPeople() {
        People p1 = new People(1, "Leonardo di ser Piero da Vinci", 78, "Italia", "painter");
        People p2 = new People(2, "Shelley", 78, "British", "poet");
        People p3 = new People(3, "Bach", 55, "Germany", "musicians");
        People p4 = new People(4, "张大千", 60, "China", "painter");
        People p5 = new People(5, "Edison", 88, "America", "inventor");
        People p6 = new People(6, "Tallon", 93, "China", "inventor");
        People p7 = new People(7, "tesla", 84, "America", "inventor");
        People p8 = new People(8, "Washington", 55, "America", "politicians");
        People p9 = new People(9, "Osama", 37, "Italia", "Arab");
        People p10 = new People(10, "徐悲鸿", 87, "China", "painter");

        List<People> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);
        list.add(p9);
        list.add(p10);

        return list;
    }
}
