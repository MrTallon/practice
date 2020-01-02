package fp;

/**
 * @author yangbo
 */
public class Strategize {

    private Strategy strategy;
    private String msg;

    private Strategize(String msg) {
        strategy = new Soft();
        this.msg = msg;
    }

    private void communicate() {
        System.out.println(strategy.approach(msg));
    }

    private void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                msg -> msg.toUpperCase() + "!",
                msg -> msg.substring(0, 5),
                Unrelated::twice
        };
        Strategize s = new Strategize("Hello there");
        s.communicate();

        for (Strategy newStrategy : strategies) {
            s.changeStrategy(newStrategy);
            s.communicate();
        }
    }
}
