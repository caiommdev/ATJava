import MedievalBattle.Battle.Battle;
import MedievalBattle.Characters.Character;
import MedievalBattle.Characters.Heros.Barbarian;
import MedievalBattle.Characters.Heros.Paladin;
import MedievalBattle.Characters.Heros.Warrior;
import MedievalBattle.Characters.Monsters.Kobold;
import MedievalBattle.Characters.Monsters.Orc;
import MedievalBattle.Characters.Monsters.Undead;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character hero = ChouseHero();
        Character monster = GenerateRandomMonster();
        Battle battle = new Battle(hero, monster);
        battle.StartBattle();
    }

    private static  Character ChouseHero(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha sua classe:");
        System.out.println("--- Guerreiro(1) ---");
        System.out.println("--- Barbaro(2) ---");
        System.out.println("--- Paladino(3) ---");
        String response = scanner.nextLine();
        switch (response){
            case "1":
                return new Warrior();
            case "2":
                return new Barbarian();
            case "3":
                return new Paladin();
        }
        return null;
    }

    private static Character GenerateRandomMonster(){
        Character[] monsters = {new Orc(), new Undead(), new Kobold()};
        int monsterInd = new Random().nextInt(monsters.length);
        System.out.println("Você lutara contra um "+ monsters[monsterInd].getName());
        return monsters[monsterInd];
    }
}
