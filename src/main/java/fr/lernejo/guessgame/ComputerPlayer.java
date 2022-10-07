package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {

    private final Logger logger = LoggerFactory.getLogger("computer");

    private long lowerBorder = 0;
    private long higherBorder = 100;

    @Override
    public long askNextGuess() {
        System.out.println((lowerBorder + higherBorder) / 2);
        return (lowerBorder + higherBorder) / 2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater) {
            higherBorder = (lowerBorder + higherBorder) / 2;
            logger.log("Lower");
        }
        else {
            lowerBorder = (lowerBorder + higherBorder) / 2;
            logger.log("Greater");
        }
    }
}
