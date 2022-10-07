package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        System.out.println("Enter your guess :");
        long guess = player.askNextGuess();

        if(guess == numberToGuess) return true;

        if(guess > numberToGuess) player.respond(true);
        else player.respond(false);

        return false;
    }

    public void loopUntilPlayerSucceed(long maxTry) {
        //TODO implement me
        long timeStampStart = System.currentTimeMillis();
        long maxTryTemp = maxTry;
        boolean success = false;

        while(maxTryTemp != 0 && !nextRound()) maxTryTemp--;

        Date timeToEndOfGame = new Date(System.currentTimeMillis() - timeStampStart);
        String date = new SimpleDateFormat("mm:ss.SSS").format(timeToEndOfGame);

        if(success) System.out.println("The player took " + date + " minute(s) and found the solution in less than " + maxTry + " tries");
        else System.out.println("The player took " + date + " minute(s) and did not find the solution in less than " + maxTry + " tries");
    }
}