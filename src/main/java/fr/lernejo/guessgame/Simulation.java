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
        logger.log("Enter your guess :");
        long guess = player.askNextGuess();

        if(guess == numberToGuess) return true;

        player.respond(guess > numberToGuess);

        return false;
    }

    public void loopUntilPlayerSucceed(long maxTry) {
        //TODO implement me
        long timeStampStart = System.currentTimeMillis();
        boolean success = false;

        while(maxTry != 0){
            if(nextRound()){
                success = true;
                break;
            }
            maxTry--;
        }

        Date timeToEndOfGame = new Date(System.currentTimeMillis() - timeStampStart);
        String date = new SimpleDateFormat("mm:ss.SSS").format(timeToEndOfGame);

        if(success) logger.log("The player won, taking " + date + " minute(s)");
        else logger.log("The player did not win and took " + date + " minute(s)");
    }
}
