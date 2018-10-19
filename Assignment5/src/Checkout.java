import java.util.LinkedList;
import java.util.List;

public class Checkout {
    private List<DessertItem> dessertItemList;

    public Checkout(){
        dessertItemList = new LinkedList<>();
    }

    public int numberOfItems(){
        return dessertItemList.size();
    }

    public void enterItem(DessertItem item){
        dessertItemList.add(item);
    }

    public void clear(){
        dessertItemList.clear();
    }

    public int totalCost(){
        int totalCost = 0;
        for (DessertItem dessertItem:dessertItemList){
            totalCost += dessertItem.getCost();
        }
        return totalCost;
    }

    public int totalTax(){
        return (int)(this.totalCost() * DessertShoppe.taxRate +0.5);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int i = 0; i < (DessertShoppe.width - DessertShoppe.name.length())/2 ; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(DessertShoppe.name);
        stringBuilder.append("\n");
        for (int i = 0; i < (DessertShoppe.width - DessertShoppe.name.length())/2 ; i++) {
            stringBuilder.append(" ");
        }
        for (int i = 0; i < DessertShoppe.name.length(); i++) {
            stringBuilder.append("-");
        }
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        for (DessertItem dessertItem: dessertItemList){
            stringBuilder.append(dessertItem.toString());
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append("Tax");
        for (int i = 0; i < DessertShoppe.width - 3 - DessertShoppe.cents2dollarsAndCentsmethod(this.totalTax()).length(); i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(DessertShoppe.cents2dollarsAndCentsmethod(this.totalTax()));
        stringBuilder.append("\n");
        stringBuilder.append("Total Cost");
        for (int i = 0; i < DessertShoppe.width - 10 - DessertShoppe.cents2dollarsAndCentsmethod(this.totalCost()+this.totalTax()).length(); i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(DessertShoppe.cents2dollarsAndCentsmethod(this.totalCost()+this.totalTax()));
        stringBuilder.append("\n\n");
        return stringBuilder.toString();
    }
}
