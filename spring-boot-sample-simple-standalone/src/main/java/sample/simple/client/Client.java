package sample.simple.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.simple.store.IFastLane;
import sample.simple.store.IJustHaveALook;
import sample.simple.store.ILane;

@Component
public class Client implements IRun {
    @Autowired
    IFastLane fast;

    @Autowired
    ILane lane;

    @Autowired
    IJustHaveALook haveALook;

    @Override
    public void run() {
        System.out.println("lets go");
    }
}
