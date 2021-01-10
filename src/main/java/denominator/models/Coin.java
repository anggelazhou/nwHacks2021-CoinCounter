package denominator.models;

public class Coin {

    private String name;
    private int val;    // in cents
    double diameter;    // in mm

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

    public double getDiameter() {
        return diameter;
    }
}
