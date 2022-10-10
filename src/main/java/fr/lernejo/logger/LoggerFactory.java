package fr.lernejo.logger;

import java.io.File;

public class LoggerFactory {

    public static Logger getLogger(String name){

        //return new ContextualLogger(name, new ConsoleLogger());
        //return new ContextualLogger(name, new FileLogger("log/log.txt"));
        //return new CompositeLogger(new ContextualLogger(name, new ConsoleLogger()), new ContextualLogger(name, new FileLogger("log/log.txt")));
        //return new CompositeLogger(new ContextualLogger(name, new ConsoleLogger()), new FilteredLogger(new ContextualLogger(name, new FileLogger("log/log.txt")), message -> message.contains("simulation")));
        return new CompositeLogger(new ContextualLogger(name, new ConsoleLogger()), new ContextualLogger(name, new FilteredLogger(new FileLogger("log/log.txt"), message -> message.contains("simulation"))));
    }

}
