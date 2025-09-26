package sample.simple.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.simple.store.IFastLane;
import sample.simple.store.IJustHaveALook;
import sample.simple.store.ILane;

@Component
public class Client implements IRun, IClient{
    @Autowired
    IFastLane fast;
    @Autowired
    private IJustHaveALook iJustHaveALook;
    @Autowired
    private ILane iLane;

    @Override
    public void run() {
        System.out.println("Scénario 1");
        this.scenario1();
        System.out.println("Scénario 2");
        this.scenario2();
    }

    private void scenario1(){
        if (iJustHaveALook.isAvailable("chaise", 3) && iJustHaveALook.getPrice("chaise")<20){
            boolean ordered = fast.oneShotOrder("chaise", 3, iJustHaveALook.getPrice("chaise"), "RIB_CLIENT");

            if (ordered){
                System.out.println("Commande réussi");
            }
            else{
                System.out.println("Commande échoué");
            }
        } else {
            System.out.println("Product not available or too expensive.");
        }
    }

    private void scenario2(){
        if (iJustHaveALook.isAvailable("chaise", 3) && iJustHaveALook.getPrice("chaise")<20){
            iLane.addItemToCart("chaise", 3);
            boolean ordered = iLane.pay("chaise", 3, "RIB_CLIENT");

            if (ordered){
                System.out.println("Commande réussi");
            }
            else{
                System.out.println("Commande échoué");
            }
        } else {
            System.out.println("Product not available or too expensive.");
        }
    }
}
