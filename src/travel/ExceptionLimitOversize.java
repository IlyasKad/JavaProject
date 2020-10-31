package travel;

public class ExceptionLimitOversize extends RuntimeException{

    public ExceptionLimitOversize(String message) {
        super(message);
    }

//    public ExceptionLimitOversize(double weight, double maxWeight) {
//        super("Oversize of limit. " + "maxweight" + maxWeight + "weight" + weight);
//    }
}
