import Exceptions.InvalidClassException;
import Logging.GameLog;
import MedievalBattle.Battle.Battle;
import MedievalBattle.Characters.Character;
import MedievalBattle.Characters.Heros.Barbarian;
import MedievalBattle.Characters.Heros.Paladin;
import MedievalBattle.Characters.Heros.Warrior;
import MedievalBattle.Characters.Monsters.Kobold;
import MedievalBattle.Characters.Monsters.Orc;
import MedievalBattle.Characters.Monsters.Undead;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameLog log = new GameLog();
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                System.out.println("Qual seu nickname?");
                String userName = scanner.nextLine();
                log.setUserNick(userName);
                log.setDate(LocalDate.now());

                Character hero = ChouseHero(scanner);
                log.setHeroClass(hero.getName());

                Character monster = GenerateRandomMonster();
                log.setMonsterClass(monster.getName());

                Battle battle = new Battle(hero, monster);
                battle.StartBattle(log);

                System.out.println();
            }
            catch (Exception ex){
                if (ex.getClass() == InvalidClassException.class)
                    System.out.println("Escolha uma classe valida");
            }
        }

    }

    private static  Character ChouseHero(Scanner scanner ) throws InvalidClassException {

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
            default:
                throw new InvalidClassException();
        }
    }

    private static Character GenerateRandomMonster(){
        Character[] monsters = {new Orc(), new Undead(), new Kobold()};
        int monsterInd = new Random().nextInt(monsters.length);
        System.out.println("Você lutara contra um "+ monsters[monsterInd].getName());
        return monsters[monsterInd];
    }
}
