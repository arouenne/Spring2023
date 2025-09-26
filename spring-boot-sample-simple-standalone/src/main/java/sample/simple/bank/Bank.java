package sample.simple.bank;

import org.springframework.stereotype.Component;
import sample.simple.client.Client;

@Component
public class Bank implements IBank {
    @Override
    public boolean transfert(String client1, String client2, double montant){
        System.out.println("Transfert de " + montant + "€ depuis " + client1 + " vers " + client2);
        return true;
    }
}
