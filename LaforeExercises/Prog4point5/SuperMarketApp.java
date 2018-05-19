package Prog4point5;
import java.util.Scanner;


/**
 * Created by gaureesh on 26/8/17.
 */
public class SuperMarketApp {
    public static void main(String[] args) {
        Queue q1 = new Queue(20, 1);
        Queue q2 = new Queue(20, 2);
        Queue q3 = new Queue(20, 3);
        Queue q4 = new Queue(20, 4);
        int minutes = 0;


        while (true) {
            System.out.println("Enter 1 to enter new customer, 2 to simulate time, 3 to quit");
            Scanner sc = new Scanner(System.in);
            int mode = sc.nextInt();
            if( mode == 1 ) {
                System.out.println("Enter Customer Id");
                int custId = sc.nextInt();
                Customer c = new Customer(custId,(int)(Math.round(Math.random() * 4) + 1));

                if( q1.noOfCustomers() <= q2.noOfCustomers() && q1.noOfCustomers() <= q3.noOfCustomers() && q1.noOfCustomers() <= q4.noOfCustomers()) {
                    q1.insert(c);
                } else if( q2.noOfCustomers() <= q1.noOfCustomers() && q2.noOfCustomers() <= q3.noOfCustomers() && q2.noOfCustomers() <= q4.noOfCustomers()) {
                    q2.insert(c);
                } else if( q3.noOfCustomers() <= q1.noOfCustomers() && q3.noOfCustomers() <= q4.noOfCustomers() && q3.noOfCustomers() <= q1.noOfCustomers()) {
                    q3.insert(c);
                } else{
                    q4.insert(c);
                }

                q1.display();
                q2.display();
                q3.display();
                q4.display();

            } else if( mode == 2 ) {
                if( minutes == 5 ) {
                    minutes = 1;
                } else {
                    minutes++;
                }
                if( !q1.isEmpty() && q1.peek().getProcessingTime() == minutes ) {
                    System.out.println("The processing for customer " + q1.peek().getId() + " from Q1 is done");
                    q1.remove();
                    q1.display();
                }

                if( !q2.isEmpty() && q2.peek().getProcessingTime() == minutes ) {
                    System.out.println("The processing for customer " + q2.peek().getId() + " from Q2 is done");
                    q2.remove();
                    q2.display();
                }

                if( !q3.isEmpty() && q3.peek().getProcessingTime() == minutes ) {
                    System.out.println("The processing for customer " + q3.peek().getId() + " from Q3 is done");
                    q3.remove();
                    q3.display();
                }

                if( !q4.isEmpty() && q4.peek().getProcessingTime() == minutes ) {
                    System.out.println("The processing for customer " + q4.peek().getId() + " from Q4 is done");
                    q4.remove();
                    q4.display();
                }
            } else {
                break;
            }
        }
    }
}
