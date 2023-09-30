package MedievalBattle.Battle.Dices;

public class Dices {
    public int RollD10(){
        return (int)Math.floor(Math.random() *(10 - 1 + 1) + 1);
    }
    public int RollD8(){
        return (int)Math.floor(Math.random() *(8 - 1 + 1) + 1);
    }
    public int Roll2D4(){
        int roll1 = (int)Math.floor(Math.random() *(4 - 1 + 1) + 1);
        int roll2 = (int)Math.floor(Math.random() *(4 - 1 + 1) + 1);
        return roll1+roll2;
    }
    public int Roll2D6(){
        int roll1 = (int)Math.floor(Math.random() *(6 - 1 + 1) + 1);
        int roll2 = (int)Math.floor(Math.random() *(6 - 1 + 1) + 1);
        return roll1+roll2;
    }

    public int Roll3D2(){
        int roll1 = (int)Math.floor(Math.random() *(2 - 1 + 1) + 1);
        int roll2 = (int)Math.floor(Math.random() *(2 - 1 + 1) + 1);
        int roll3 = (int)Math.floor(Math.random() *(2 - 1 + 1) + 1);
        return roll1+roll2+roll3;
    }
}
