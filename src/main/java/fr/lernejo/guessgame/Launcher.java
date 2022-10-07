package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args){

        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextLong(100); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE


        if(args[0].equals("-interactive")){

            Simulation simulation = new Simulation(new HumanPlayer());
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);

        } else if(args[0].equals("-auto")) {

            Simulation simulation = new Simulation(new ComputerPlayer());
            simulation.initialize(Long.parseLong(args[1]));
            simulation.loopUntilPlayerSucceed(1000);

        } else {

            System.out.println("    L'age du Capitaine\n");
            System.out.println("Options(à ajouter en paramètre lors de l'éxecution) : ");
            System.out.println("-interactive : lance le jeu en mode joueur humain");
            System.out.println("-auto [nombre à trouver] : lance le jeu en mode ordinateur");
        }
    }
}
