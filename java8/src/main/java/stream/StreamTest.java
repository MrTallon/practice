package stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 流式编程
 * http://www.importnew.com/22417.html
 * <p>
 * https://mp.weixin.qq.com/s/-bkB7Nje9ebQl3kiRc-I3w
 * https://www.cnblogs.com/invoker-/p/6896865.html
 *
 * @author YangBo
 * @date 2019/03/07
 */
public class StreamTest {

    public static void main(String[] args) {

        /**
         * 常用API
         *
         * 1.获取流对象
         * 2.collect(toList())
         * 3.筛选filter
         * 4.去重distinc
         * 5.截取limit
         * 6.跳过skip
         * 7.映射map
         * 8.flatMap
         * 9.max和min
         * 10.归约reduce
         * 11.Optional对象
         */

        List<People> list = StreamFactory.getInstance().getPeople();

        //过滤符合条件的数据
        long count = list.stream().filter(a -> "America".equals(a.getPlace()) && 18 == a.getAge()).count();
        List<People> collect = list.stream().filter(a -> "America".equals(a.getPlace()) && 18 == a.getAge()).collect(Collectors.toList());


        Integer x = null;
        Integer y = new Integer(10);
        Optional<Integer> a = Optional.ofNullable(x);
        System.out.println(a);
        System.out.println(a.isPresent());

    }


}
