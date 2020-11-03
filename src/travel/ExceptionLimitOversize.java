package travel;

public class ExceptionLimitOversize extends RuntimeException{

//    public ExceptionLimitOversize(String message) {
//        super(message);
//    }

    public ExceptionLimitOversize(double weight, double maxWeight) {
        super("Oversize of limit. Max of weight = " + maxWeight + ", current weight = " + weight + ", reminder of weight = "
                + (maxWeight - weight) );
    }
}
