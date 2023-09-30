package MedievalBattle.Characters.Monsters;

import MedievalBattle.Characters.Character;

public class Orc extends Character {
    public Orc(){
        this.lifePoints = 20;
        this.strength = 6;
        this.defense = 2;
        this.agility = 2;
        this.damage = "1d8";
    }
}
