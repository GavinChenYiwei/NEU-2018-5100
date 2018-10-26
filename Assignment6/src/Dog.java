import java.util.Calendar;

public class Dog extends Pet implements Boardable {
    private String size;
    private Calendar start = Calendar.getInstance();
    private Calendar end = Calendar.getInstance();

    public Dog(String name, String ownerName, String color,String size) {
        super(name, ownerName, color);
        this.size = size;
    }
    public String getSize(){
        return this.size;
    }
    public String toString(){
        String output = "DOG: \n" + super.toString() + "\n Size: " + getSize();
        return output;
    }
    @Override
    public void setBoardStart(int month, int day, int year) {
        start.set(year,month,day);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        end.set(year,month,day);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        Calendar current = Calendar.getInstance();
        current.set(year,month,day);
        if (current.after(start) && current.before(end) || current.equals(start) || current.equals(end))
            return true;
        else
            return false;
    }

}
