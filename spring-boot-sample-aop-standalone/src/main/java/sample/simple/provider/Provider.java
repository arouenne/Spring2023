package sample.simple.provider;

import org.springframework.stereotype.Component;

@Component
public class Provider implements IProvider {

    @Override
    public double getPrice() {
        System.out.println("Class Provider: Method getPrice: Article price: 50");
        return 50;
    }

    @Override
    public void order(int quantity) {
        System.out.println("Class Provider: Method order "+ quantity +" articles.");
    }
}
