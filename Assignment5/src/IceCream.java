public class IceCream extends DessertItem {
    private int iceCreamCost;

    public IceCream(String name, int iceCreamCost){
        super(name);
        this.iceCreamCost = iceCreamCost;
    }
    @Override
    public int getCost() {
        return this.iceCreamCost;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getName());
        String price = DessertShoppe.cents2dollarsAndCentsmethod(this.getCost());
        for (int i = 0; i < DessertShoppe.width-getName().length()-price.length(); i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(price);
        return stringBuilder.toString();
    }
}
