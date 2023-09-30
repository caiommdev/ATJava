package MedievalBattle.Characters;

public abstract class Character {
    protected int lifePoints;
    protected int strength;
    protected int defense;
    protected int agility;
    protected String damage;
    protected String Name;

    public int getLifePoints(){
       return lifePoints;
    }

    public int getAgility() {
        return agility;
    }

    public String getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return Name;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setName(String name) {
        Name = name;
    }
}
