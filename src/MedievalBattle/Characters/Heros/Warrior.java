package MedievalBattle.Characters.Heros;

import MedievalBattle.Characters.Character;

public class Warrior extends Character {
    public Warrior(){
        this.lifePoints = 12;
        this.strength = 4;
        this.defense = 3;
        this.agility = 3;
        this.damage = "2d4";
    }
}
