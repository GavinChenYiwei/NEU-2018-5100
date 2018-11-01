public class Tool {
    protected int strength;
    protected char type;

    public void setStrength(int strength){
        this.strength = strength;
    }
}

class Rock extends Tool{

    public Rock(int strength){
        this.type = 'r';
        this.setStrength(strength);
    }

    public boolean fight (Tool tool){
        if (tool.type == 's')
            return (this.strength * 2) > tool.strength;
        else if (tool.type == 'p')
            return (this.strength / 2) > tool.strength;
        else
            return this.strength > tool.strength;
    }
}

class Scissors extends Tool{

    public Scissors(int strength){
        this.type = 's';
        this.setStrength(strength);
    }

    public boolean fight (Tool tool){
        if (tool.type == 'p')
            return (this.strength * 2) > tool.strength;
        else if (tool.type == 'r')
            return (this.strength / 2) > tool.strength;
        else
            return this.strength > tool.strength;
    }
}

class Paper extends Tool{

    public Paper(int strength){
        this.type = 'p';
        this.setStrength(strength);
    }

    public boolean fight (Tool tool){
        if (tool.type == 'r')
            return (this.strength * 2) > tool.strength;
        else if (tool.type == 's')
            return (this.strength / 2) > tool.strength;
        else
            return this.strength > tool.strength;
    }
}
class RockPaperScissorsGame{
    public static void main(String args[]){
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        System.out.println(s.fight(p) + " , "+ p.fight(s) );
        System.out.println(p.fight(r) + " , "+ r.fight(p) );
        System.out.println(r.fight(s) + " , "+ s.fight(r) );
    }
}



