package com.joinup.viewUi;

import com.joinup.entity.Transport;
import com.joinup.entity.TravelVoucher;
import com.joinup.service.Impl.TransportServiceImpl;
import com.joinup.service.Impl.TravelVoucherServiceImpl;
import com.joinup.service.TransportService;
import com.joinup.service.TravelVoucherService;
import com.joinup.util.QueryParam;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ui {
    private final static Logger LOGGER = Logger.getLogger(Ui.class);

    private TravelVoucherService travelVoucherService = new TravelVoucherServiceImpl();
    private TransportService transportService = new TransportServiceImpl();
    private Scanner scanner;
    private ViewUi viewUi;


    public void run() {
        scanner = new Scanner(System.in);
        printOffer();
    }

    private void printOffer() {
        QueryParam queryParam = new QueryParam();
        queryParam.setTypeOfTransport(inputTransport());
        queryParam.setFood(inputFood());
        queryParam.setNumberOfDays(inputNumberOfDays());
        for (TravelVoucher value : travelVoucherService.defineTour(queryParam)) {
            viewUi.printMessage(value.toString());
        }
    }

    private boolean inputFood() {
        viewUi.printMessage("input: 1 - with food; 0 - without food");
        int food;
        try {
            food = scanner.nextInt();
            if (0 == food || 1 == food) {
                return 0 != food;
            } else {
                return inputFood();
            }
        } catch (InputMismatchException e) {
            LOGGER.info("incorrect entered value food");
            viewUi.printMessage("You entered an incorrect value");
            return inputFood();
        }
    }

    private int inputTransport() {
        viewUi.printMessage("Chose transport: ");
        int id;
        List<Transport> listTransport = transportService.isAll();
        try {
            for (Transport transport : listTransport) {
                viewUi.printMessage(transport.toString());
            }
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            LOGGER.info("incorrect entered value type of transport");
            viewUi.printMessage("You entered an incorrect value");
            return inputTransport();
        }
        for (Transport transport : listTransport) {
            if (id == transport.getId()) {
                return id;
            }
        }
        viewUi.printMessage("You entered an incorrect value");
        return inputTransport();
    }

    private int inputNumberOfDays() {
        viewUi.printMessage("Input number of days:");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            LOGGER.info("incorrect entered value number of days");
            viewUi.printMessage("You entered an incorrect value");
            return inputNumberOfDays();
        }
    }

    public void setView(ViewUi viewUi) {
        this.viewUi = viewUi;
    }
}
