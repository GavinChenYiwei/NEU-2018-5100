public class DessertShoppe {
    public final static float taxRate = 0.065f;
    public final static String name = "M & M Dessert Shoppe";
    public final static int maximumsize = 25;
    public final static int width = 30;

    public static String cents2dollarsAndCentsmethod(int cents){
        double dollarCent = cents/100.0;
        return String.valueOf(dollarCent);
    }
}
