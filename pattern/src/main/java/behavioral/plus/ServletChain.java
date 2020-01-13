package behavioral.plus;

import java.util.ArrayList;
import java.util.List;

/**
 * Servlet责任链模式
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2020-01-13 09:25
 */
public class ServletChain {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:)，<script> ，大家都是996 ";
        Response response = new Response();
        response.str = "response";

        FilterChain chain = new FilterChain();
        chain.add(new HTMLFilter()).add(new SensitiveFilter());
        chain.doFilter(request, response);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}

class Request {
    String str;
}

class Response {
    String str;
}

class FilterChain {
    private List<Filter> filters = new ArrayList<>();
    private int index = 0;

    FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    void doFilter(Request request, Response response) {
        if (index == filters.size()) {
            return;
        }
        Filter f = filters.get(index);
        index++;
        f.doFilter(request, response, this);
    }
}

interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}

class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replace("<", "[").replace(">", "]") + "HTMLFilter()";
        chain.doFilter(request, response);
        response.str += "--HTMLFilter()";
    }
}

class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("996", "955") + " SensitiveFilter()";
        chain.doFilter(request, response);
        response.str += "--SensitiveFilter()";
    }
}