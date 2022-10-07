package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args){
        Simulation simulation = new Simulation(new HumanPlayer());

        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextLong(100); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
        simulation.initialize(randomNumber);

        simulation.loopUntilPlayerSucceed(10);
    }
}
