public class Candy extends DessertItem {
    private double weight;
    private int price_per_pound;

    public Candy(String name, double weight, int price_per_pound){
        super(name);
        this.weight = weight;
        this.price_per_pound = price_per_pound;
    }

    @Override
    public int getCost() {
        return (int)(this.weight*this.price_per_pound +0.5);
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(weight+" lbs. @ "+ DessertShoppe.cents2dollarsAndCentsmethod(price_per_pound)+" /lb."+"\n"+getName());
        String price = DessertShoppe.cents2dollarsAndCentsmethod(this.getCost());
        for (int i = 0; i < DessertShoppe.width-getName().length()-price.length(); i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(price);
        return stringBuilder.toString();
    }
}
