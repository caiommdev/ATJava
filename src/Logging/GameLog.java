package Logging;

import java.time.LocalDate;

public class GameLog {
    private LocalDate date;
    private String userNick;
    private String heroClass;
    private String battleStatus;
    private String monsterClass;
    private int numberOfRounds;

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getBattleStatus() {
        return battleStatus;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public String getMonsterClass() {
        return monsterClass;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setBattleStatus(String battleStatus) {
        this.battleStatus = battleStatus;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public void setMonsterClass(String monsterClass) {
        this.monsterClass = monsterClass;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
}
