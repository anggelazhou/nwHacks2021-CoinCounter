package denominator.models;

public class Coin {

    private String name;
    private int val;

    public Coin(String name, int val) {
        this.name = name;
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public String getName() {
        return name;
    }

}
