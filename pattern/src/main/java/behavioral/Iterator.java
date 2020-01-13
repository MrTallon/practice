package behavioral;

/**
 * 迭代器
 *
 * @author yangbo
 * @version v1.0.0
 * @date 2020-01-12 16:14
 */
public interface Iterator {
    Object next();

    boolean hasNext();
}

interface Aggregate{
    Iterator createIterator();
}

class StringArray implements Aggregate{

    private String[] values;

    public StringArray(String[] values) {
        this.values = values;
    }

    @Override
    public Iterator createIterator() {
        return new StringArrayIterator();
    }

    private class StringArrayIterator implements Iterator {

        private int position;
        @Override
        public Object next() {
            return this.hasNext() ? values[position++] : null;
        }

        @Override
        public boolean hasNext() {
            return (position < values.length);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d"};
        StringArray array = new StringArray(arr);
        for (Iterator it = array.createIterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}
