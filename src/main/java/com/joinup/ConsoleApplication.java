package com.joinup;

import com.joinup.viewUi.Ui;
import com.joinup.viewUi.ViewUi;

public class ConsoleApplication {

    public static void main(String[] args) {
        Ui consoleUi = new Ui();
        consoleUi.setView(new ViewUi());
        consoleUi.run();
    }
}
