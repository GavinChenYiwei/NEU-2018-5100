public class Cookie extends DessertItem {
    private double number;
    private int price_per_dozen;

    public Cookie(String name, double number, int price_per_dozen){
        super(name);
        this.number = number;
        this.price_per_dozen = price_per_dozen;
    }

    @Override
    public int getCost() {
        return (int)((float)(this.number/12)*this.price_per_dozen + 0.5);
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(number+" @ "+ DessertShoppe.cents2dollarsAndCentsmethod(price_per_dozen)+" /dz."+"\n"+getName());
        String price = DessertShoppe.cents2dollarsAndCentsmethod(this.getCost());
        for (int i = 0; i < DessertShoppe.width-getName().length()-price.length(); i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(price);
        return stringBuilder.toString();
    }
}
