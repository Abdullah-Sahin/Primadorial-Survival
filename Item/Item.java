package Item;

public abstract class Item {

    private String name;
    private double Price;
    private int upgradeLevel = 0;
    public int ruquiredMoneyToUpgrade;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setUpgradeLevel(int upgradeLevel){
        this.upgradeLevel = upgradeLevel;
    }

    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    public int getRuquiredMoneyToUpgrade(){
        return (getUpgradeLevel() * getUpgradeLevel() * 2) + 5;
    }
    
}
