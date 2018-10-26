import java.util.Calendar;

public class Cat extends Pet implements Boardable{
    private String hairLength;
    private Calendar start = Calendar.getInstance();
    private Calendar end = Calendar.getInstance();

    public Cat(String name, String ownerName, String color, String hairLength) {
        super(name, ownerName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength(){
        return this.hairLength;
    }
    public String toString(){
        String output = "CAT:" + "\n" + super.toString()
                + "\n" + "Hair: " + getHairLength();
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
        if (current.after(start) && current.before(end))
            return false;
        else
            return true;
    }
}
