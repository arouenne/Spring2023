package sample.simple.provider;

public interface IProvider {
    public double getPrice(String article);

    public void order(String article, int quantity);
}
