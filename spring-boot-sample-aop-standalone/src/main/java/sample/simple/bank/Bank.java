package sample.simple.bank;

import org.springframework.stereotype.Component;
import sample.simple.client.Client;

@Component
public class Bank implements IBank {
    @Override
    public boolean transfert(Client client1, Client client2, double montant) {
        if (client1.getMontant() >= client2.getMontant()) {
            System.out.println("Class Bank : Method transfert: " + montant + " from " + client1 + " to " + client2);
            return true;
        } else{
            return false;
        }

    }

    public String getBankName() {
        return "Bank";
    }
}
