package MedievalBattle.Battle;

import MedievalBattle.Characters.Character;
import MedievalBattle.Battle.Dices.Dices;

public class Battle {
    private Character hero;
    private Character monster;
    private Dices dices;
    public Battle (Character hero, Character monster){
        this.hero = hero;
        this.monster = monster;
        this.dices = new Dices();
    }

    public void StartBattle(){
        while (hero.getLifePoints() > 0 || monster.getLifePoints() > 0){
            Character attacker = InitiativeCalc();
            Attack(attacker);
        }
        if(hero.getLifePoints() >0)
            System.out.println("Vc ganhou a batalha");
        else{
            System.out.println("Vc perdeu a batalha");
        }
    }

    private Character InitiativeCalc() {
        int heroInitiative = 0;
        int monsterInitiative = 0;
        while( heroInitiative == monsterInitiative){
            heroInitiative = dices.RollD10() + this.hero.getAgility();
            monsterInitiative = dices.RollD10() + this.monster.getAgility();
        }

        if (monsterInitiative > heroInitiative)
            return this.monster;
        return this.hero;
    }

    private void Attack(Character attacker){
        Character defender = this.monster;

        if(attacker == this.monster)
            defender = this.hero;

        int attackFactor = dices.RollD10() + attacker.getAgility() + attacker.getStrength();
        int defenseFactor = dices.RollD10() + defender.getAgility() + defender.getDefense();
        if(attackFactor > defenseFactor)
            DamageCalc(attacker,defender);
    }

    private void DamageCalc(Character attacker, Character defender){
        String attackerDamage = attacker.getDamage();
        int damage;
        switch (attackerDamage){
            case "2d4":
                damage = dices.Roll2D4() + attacker.getStrength();
                defender.setLifePoints(defender.getLifePoints() - damage);
                break;
            case "2d6":
                damage = dices.Roll2D6() + attacker.getStrength();
                defender.setLifePoints(defender.getLifePoints() - damage);
                break;
            case "3d2":
                damage = dices.Roll3D2() + attacker.getStrength();
                defender.setLifePoints(defender.getLifePoints() - damage);
                break;
            case "1d8":
                damage = dices.RollD8() + attacker.getStrength();
                defender.setLifePoints(defender.getLifePoints() - damage);
                break;
        }
    }
}
