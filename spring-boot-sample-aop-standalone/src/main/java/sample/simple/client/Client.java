package sample.simple.client;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.simple.bank.Bank;
import sample.simple.store.IFastLane;
import sample.simple.store.IJustHaveALook;
import sample.simple.store.ILane;

@Component
public class Client implements IRun {
    @Autowired
    Bank bank;

    @Autowired
    IFastLane fast;

    @Autowired
    ILane lane;

    @Autowired
    IJustHaveALook haveALook;

    private double montant = 0;

    @Override
    public void run() {
        bank.getBankName();
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
