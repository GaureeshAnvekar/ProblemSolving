package Prog4point5;

/**
 * Created by gaureesh on 26/8/17.
 */
public class Customer {
    private int id;
    private int processingTime;

    Customer(int custId, int procTime) {
        id = custId;
        processingTime = procTime;
    }

    public int getId() {
        return id;
    }

    public int getProcessingTime() {
        return processingTime;
    }
}
