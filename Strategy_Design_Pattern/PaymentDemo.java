import java.util.*;
interface PaymentStrategy{
    void processPayment(double amount);
}
class CreditCardPayment implements PaymentStrategy{
    public void processPayment(double amount){
        System.out.println("Processing the Credit Card Payment of Rupees: "+amount);
    }
}
class PaypalPayment implements PaymentStrategy{
    public void processPayment(double amount){
        System.out.println("Processing the Paypal Payment of Rupees: "+amount);
    }
}
class CryptocurrencyPayment implements PaymentStrategy{
    public void processPayment(double amount){
        System.out.println("Processing the Crypto Currency payment of Rupees: "+amount);
    }
}
class PaymentProcessor{
    private PaymentStrategy paymentstrategy;
    public PaymentProcessor(){
        paymentstrategy=null;
    }
    public void setStrategy(PaymentStrategy strategy){
        if(paymentstrategy!=null){
            paymentstrategy=null;
        }
        paymentstrategy=strategy;
    }
    public void processPayment(double amount){
        if(paymentstrategy!=null){
            paymentstrategy.processPayment(amount);
        }
        else{
            System.out.println("Payment Strategy is not set yet.");
        }
    }
    public void finalizeStrategy(){
        if(paymentstrategy!=null){
            paymentstrategy=null;
        }
    }
}
public class PaymentDemo{
    public static void main(String args[]){
        PaymentProcessor processor=new PaymentProcessor();
        PaymentStrategy strategy=new CreditCardPayment();
        processor.setStrategy(strategy);
        processor.processPayment(10000.00);
        strategy=new CryptocurrencyPayment();
        processor.setStrategy(strategy);
        processor.processPayment(2000000.0);
    }
}