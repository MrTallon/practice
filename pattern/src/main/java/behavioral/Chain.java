package behavioral;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链设计模式
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2020-01-08 01:04
 */
public class Chain {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setM("测试用例：<责任链调用模式>，反动言论");
        FilterChain fc = new FilterChain();
        fc.add(new HtmlFilter()).add(new TxtFilter());
        fc.doFilter(msg);
        System.out.println(msg);
    }
}

@Data
class Msg {
    private String m;
}

interface Filter {
    boolean doFilter(Msg msg);
}

class HtmlFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String m = msg.getM();
        m = m.replace("<", "[");
        m = m.replace(">", "]");
        msg.setM(m);
        return true;
    }
}

class UrlFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String m = msg.getM();
        m = m.replace("baidu.com", "https://www.baidu.com");
        msg.setM(m);
        return true;
    }
}

class TxtFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String m = msg.getM();
        m = m.replace("反动", "爱国");
        msg.setM(m);
        return true;
    }
}

class FilterChain implements Filter {

    private List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg msg) {
        for (Filter f : filters) {
            if (!f.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }
}
