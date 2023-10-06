package Logging;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public void showData(){
        String fileName = "src/temp/" + getUserNick() + ".csv";
        ValidateFile(fileName);
        try {
            List<String> lines = ReadAllLines(fileName);
            //lines.stream().map(linha -> linha.split(";"));
            MostPlayedClass(lines);
            MostPlayedMonster(lines);
            TotalPonts(lines);
        } catch (IOException e) {
            System.out.println("Erro na escrita.");
            e.printStackTrace();
        }
    }

    public void Log(){
        String fileName = "src/temp/" + getUserNick() + ".csv";
        ValidateFile(fileName);
        try {
            List<String> lines = ReadAllLines(fileName);
            WriteAllContent(fileName, lines);
            System.out.println("Log escrito com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro na escrita.");
            e.printStackTrace();
        }
    }

    private void ValidateFile(String fileName) {
        File file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao procurrar o arquivo.");
                e.printStackTrace();
                return;
            }
        }
    }

    private List<String> ReadAllLines(String fileName) throws IOException {
        BufferedReader bufferedRead = new BufferedReader(new FileReader(fileName));

        List<String> lines = new ArrayList<String>();
        String line = "";
        while (true) {
            line = bufferedRead.readLine();
            if (line != null) {
                lines.add(line+"\n");
            } else
                break;
        }
        bufferedRead.close();
        return lines;
    }

    private void WriteAllContent(String fileName, List<String> lines) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        lines.add(getDate().toString() + ";" + getHeroClass() + ";" + getBattleStatus() + ";" + getMonsterClass() + ";" + getNumberOfRounds() + "\n");

        for (String i: lines) {
            bufferedWriter.append(i);
        }
        bufferedWriter.close();
    }

    private void MostPlayedClass(List<String> lines){
        int contBarbarian = 0;
        int contWarrior = 0;
        int contPaladin = 0;
        for (String line:lines) {
            if (line.contains("Guerreiro"))
                contWarrior++;

            if (line.contains("Barbaro"))
                contBarbarian++;

            if(line.contains("Paladino"))
                contPaladin++;
        }
        String mostPlayerClass = "";
        if(contWarrior > contBarbarian && contWarrior > contPaladin)
            mostPlayerClass = "Guerreiro";
        else if (contBarbarian > contWarrior && contBarbarian > contPaladin)
            mostPlayerClass = "Barbaro";
        else if (contPaladin > contWarrior && contPaladin > contBarbarian)
            mostPlayerClass = "Paladino";
        else
            mostPlayerClass = "Você não tem";
        System.out.println("Sua classe mais jogada é "+ mostPlayerClass);
    }

    private void MostPlayedMonster(List<String> lines){
        int contOrc = 0;
        int contUndead = 0;
        int contKobold = 0;
        for (String line:lines) {
            if (line.contains("Orc"))
                contUndead++;

            if (line.contains("Morto-Vivo"))
                contOrc++;

            if(line.contains("Kobold"))
                contKobold++;
        }
        String mostPlayerClass = "";
        if(contUndead > contOrc && contUndead > contKobold)
            mostPlayerClass = "Orc";
        else if (contOrc > contUndead && contOrc > contKobold)
            mostPlayerClass = "Morto-Vivo";
        else if (contKobold > contUndead && contKobold > contOrc)
            mostPlayerClass = "Kobold";
        else
            mostPlayerClass = "Você não tem";
        System.out.println("Seu monstro mais jogado é "+ mostPlayerClass);
    }

    private void TotalPonts(List<String> lines){
        int numberOfPoints = 0;
        for (String line :
                lines) {
            var list = line.split(";");
            numberOfPoints += 100 - Integer.parseInt(list[4].replace("\n", ""));
        }
        System.out.println("Você fez "+numberOfPoints+" pontos");
    }
}
