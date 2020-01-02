package fp;

/**
 * @author yangbo
 */
public class Soft implements Strategy {

    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}
