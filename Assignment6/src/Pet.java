public class Pet {
    private String petName;
    private String ownerName;
    private String color;
    protected int sex;

    public static final int MALE = 1;
    public static final int FEMALE = 0;
    public static final int SPAYED = 2;
    public static final int NEUTERED = 3;

    public Pet(String name, String ownerName, String color){
        this.petName = name;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getPetName(){
        return this.petName;
    }
    public String getOwnerName(){
        return this.ownerName;
    }
    public String getColor(){
        return this.color;
    }
    public void setSex(int sexid){
        this.sex = sexid;
    }
    public String getSex(){
        switch (this.sex){
            case MALE : return "MALE";
            case FEMALE : return "FEMALE";
            case SPAYED : return "SPAYED";
            case NEUTERED : return "NEUTERED";
        }
        return "";
    }
    public String toString(){
        String output = this.petName + " owned by " + this.ownerName + "\n"
                + "Color: " + this.color + "\n" + "Sex: " + this.getSex();
        return output;
    }

    public static void main(String[] args) {
        Pet pet = new Pet("Spot","Mary","Black and White");
        pet.setSex(1);
        System.out.println(pet.getSex());
        System.out.println(pet.getColor());
        System.out.println(pet.getOwnerName());
        System.out.println(pet.getPetName());
        System.out.println(pet.toString());
    }
}
