package com.joinup;

import com.joinup.services.ServiceUi;
import com.joinup.viewUi.ViewUi;
import org.apache.log4j.Logger;

public class ConsoleApplication {

    private final static Logger LOGGER = Logger.getLogger(ConsoleApplication.class);

    public static void main(String[] args) {
        LOGGER.info("ConsoleApplication started!");
        ServiceUi consoleUi = new ServiceUi();
        consoleUi.setView(new ViewUi());
        consoleUi.run();
        LOGGER.info("ConsoleApplication ended0!");
    }
}