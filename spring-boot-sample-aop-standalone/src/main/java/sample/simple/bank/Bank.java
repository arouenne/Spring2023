package sample.simple.bank;

import org.springframework.stereotype.Component;

@Component
public class Bank implements IBank {
    @Override
    public boolean transfert(Client client1, Client client2, double montant){
        System.out.println("Class Bank : Method transfert: " + montant + " from " + client1 + " to " + client2);
        return true;
    }
}
