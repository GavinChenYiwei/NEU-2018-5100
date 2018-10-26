import java.util.ArrayList;

public class Mreview implements Comparable<Mreview>{
    private String title;  // title of the movie
    private ArrayList<Integer> ratings;  //list of ratings stored in a Store object

    public static void main(String[] args) {
        Mreview theFirstMan = new Mreview("The First Man",5);
        theFirstMan.addRating(4);
        theFirstMan.addRating(5);
        System.out.println(theFirstMan.toString());
        System.out.println(theFirstMan.aveRating());
    }

    public Mreview(){
        this.title = "";
        this.ratings = new ArrayList<>();
    }

    public Mreview(String title){
        this.title = title;
        this.ratings = new ArrayList<>();
    }

    public Mreview(String title, int firstRating){
        this.title = title;
        this.ratings = new ArrayList<>();
        ratings.add(firstRating);
    }

    public String getTitle(){
        return this.title;
    }

    public void addRating(int r){
        this.ratings.add(r);
    }

    public double aveRating(){
        double ave = 0;
        int sum = 0;
        for (Integer rate: this.ratings){
            sum += rate;
        }
        ave = (double)sum/this.numRatings();
        return Double.valueOf(String.format("%.2f",ave));
    }

    public int numRatings(){
        return this.ratings.size();
    }

    @Override
    public int compareTo(Mreview o) {
        return this.title.compareTo(o.title);
    }

    public boolean equals(Mreview o){
        return this.title.equals(o.title);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.title + ", ");
        sb.append("average "+ this.aveRating() + " out of "
                + this.numRatings() + " ratings");
        return sb.toString();
    }
}
