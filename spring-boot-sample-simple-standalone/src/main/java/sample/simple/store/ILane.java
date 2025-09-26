package sample.simple.store;

public interface ILane {
    public boolean addItemToCart(String product, int number);
    public boolean pay(String product,  int number, String compte);
}
