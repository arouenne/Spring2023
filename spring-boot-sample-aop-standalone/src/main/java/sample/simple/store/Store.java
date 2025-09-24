package sample.simple.store;

import sample.simple.bank.IBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.simple.provider.IProvider;

@Component
public class Store implements IFastLane, ILane, IJustHaveALook {

    @Autowired
    IBank bank;

    @Autowired
    IProvider provider;
}
