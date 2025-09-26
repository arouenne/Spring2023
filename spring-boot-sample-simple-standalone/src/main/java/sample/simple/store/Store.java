package sample.simple.store;

import sample.simple.bank.IBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.simple.provider.IProvider;

@Component
public class Store implements IFastLane, ILane, IJustHaveALook, IStore {
    private final String COMPTE_MAGASIN = "RIB_MAGASIN";

    @Autowired
    IBank bank;

    @Autowired
    IProvider provider;

    @Override
    public double getPrice(String product) {
        return 14;
    }

    @Override
    public boolean isAvailable(String product, int number) {
        return true;
    }

    @Override
    public boolean oneShotOrder(String product, int number, double price, String compte) {
        System.out.println("Commande de  : " + number + " " + product + " à " + price + "€ depuis le compte : " + compte);
        boolean paid = bank.transfert(compte, COMPTE_MAGASIN, number * price);
        if (paid) {
            provider.order(product, number);
            return true;
        }
        return false;
    }

    @Override
    public boolean addItemToCart(String product, int number) {
        System.out.println("Ajout de " + number + " " + product + " au panier.");
        return true;
    }

    @Override
    public boolean pay(String product, int number, String compte) {
        return bank.transfert(compte, COMPTE_MAGASIN, number * getPrice(product));
    }
}
