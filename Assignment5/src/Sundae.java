public class Sundae extends IceCream {
    private int sundaeCost;
    private String sundaeName;
    public Sundae(String iceCreamName, int iceCreamCost, String sundaeName, int sundaeCost){
       super(iceCreamName,iceCreamCost);
       this.sundaeName = sundaeName;
       this.sundaeCost = sundaeCost;
    }

    @Override
    public int getCost() {
        return super.getCost() +this.sundaeCost;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sundaeName+ " " + "with" + "\n" + getName());
        String price = DessertShoppe.cents2dollarsAndCentsmethod(this.getCost());
        for (int i = 0; i < DessertShoppe.width-getName().length()-price.length(); i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(price);
        return stringBuilder.toString();
    }
}
