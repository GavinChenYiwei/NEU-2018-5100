public class Main{
    public static void main(String[] args) {
        MoodyObject sad = new SadObject();
        HappyObject happy = new HappyObject();
        PsychiatristObject test = new PsychiatristObject();
        test.examine(happy);
        test.observe(happy);
        test.examine(sad);
        test.observe(sad);
    }
}

class PsychiatristObject {
    public void examine(MoodyObject moodyObject){
        System.out.println("How are you feeling today?");
        moodyObject.queryMood();
    }

    public void observe(MoodyObject moodyObject){
        moodyObject.expressFeelings();
        System.out.println("Observation: " + moodyObject.toString());
        System.out.println();
    }
}
abstract class MoodyObject{
    protected abstract String getMood();
    protected abstract void expressFeelings();

    public void  queryMood(){
        if (this.getMood() == "happy") {
            System.out.println("I feel happy today!");
            System.out.println();
        }
        else if (this.getMood() == "sad") {
            System.out.println("I feel sad today!");
            System.out.println();
        }
    }
}

class SadObject extends MoodyObject{
    @Override
    protected String getMood(){
        return "sad";
    }

    @Override
    protected void expressFeelings() {
        System.out.println("'wah' 'boo hoo' 'weep' 'sob' 'weep'");
    }

    public String toString(){
        return "Subject cries a lot";
    }
}

class HappyObject extends MoodyObject{
    @Override
    protected String getMood(){
        return "happy";
    }

    @Override
    protected void expressFeelings() {
        System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
    }

    public String toString(){
        return "Subject laughs a lot";
    }
}