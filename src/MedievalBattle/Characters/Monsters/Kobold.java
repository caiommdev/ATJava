package MedievalBattle.Characters.Monsters;

import MedievalBattle.Characters.Character;

public class Kobold extends Character {
    public Kobold(){
        this.lifePoints = 20;
        this.strength = 4;
        this.defense = 2;
        this.agility = 4;
        this.damage = "3d2";
        this.Name = "Kobold";
    }
}
