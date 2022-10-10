package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {

    private final Logger logger = LoggerFactory.getLogger("computer");

    private long lowerBorder = Long.MIN_VALUE;
    private long higherBorder = Long.MAX_VALUE;

    @Override
    public long askNextGuess() {
        logger.log(String.valueOf((lowerBorder + higherBorder) / 2));
        return (lowerBorder + higherBorder) / 2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater) {
            higherBorder = (lowerBorder + higherBorder) / 2;
            logger.log("lower");
        }
        else {
            lowerBorder = (lowerBorder + higherBorder) / 2;
            logger.log("greater");
        }
    }
}
