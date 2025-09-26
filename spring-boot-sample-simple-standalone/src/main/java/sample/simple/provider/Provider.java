package sample.simple.provider;

import org.springframework.stereotype.Component;

@Component
public class Provider implements IProvider {

    @Override
    public double getPrice(String article) {
        System.out.println(article + " price: 14");
        return 14;
    }

    @Override
    public void order(String article, int quantity) {
        System.out.println("Réapprovisionne " + quantity + " " + article);
    }
}
