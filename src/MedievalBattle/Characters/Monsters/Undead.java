package MedievalBattle.Characters.Monsters;

import MedievalBattle.Characters.Character;

public class Undead extends Character {
    public Undead(){
        this.lifePoints = 25;
        this.strength = 4;
        this.defense = 0;
        this.agility = 1;
        this.damage = "2d4";
    }
}
