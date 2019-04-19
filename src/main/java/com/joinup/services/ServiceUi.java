package com.joinup.services;

import com.joinup.entity.Transport;
import com.joinup.entity.TravelVoucher;
import com.joinup.repository.TransportRepository;
import com.joinup.repository.TravelVoucherRepository;
import com.joinup.repository.impl.TransportRepositoryImpl;
import com.joinup.repository.impl.TravelVoucherRepositoryImpl;
import com.joinup.viewUi.ViewUi;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ServiceUi {
    private final static Logger LOGGER = Logger.getLogger(ServiceUi.class);
    private TransportRepository transportRepository = new TransportRepositoryImpl();
    private TravelVoucherRepository repository = new TravelVoucherRepositoryImpl();
    private Scanner scanner;
    private ViewUi viewUi;


    public void run() {
        scanner = new Scanner(System.in);
        filter();
    }

    private void filter() {
        int transportId = inputTransport();
        boolean food = inputFood();
        int inputNumberOfDays = inputNumberOfDays();
        for (TravelVoucher value : repository.defineTour(transportId, food, inputNumberOfDays)) {
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
            LOGGER.info("incorrect entered value int method inputFood()");
            viewUi.printMessage("You entered an incorrect value");
            return inputFood();
        }
    }

    private int inputTransport() {
        viewUi.printMessage("Chose transport: ");
        int id;
        List<Transport> listTransport = transportRepository.isAll();
        try {
            for (Transport transport : listTransport) {
                viewUi.printMessage(transport.toString());
            }
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            LOGGER.info("incorrect entered value int method inputTransport()");
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
            LOGGER.info("incorrect entered value int method inputNumberOfDays()");
            viewUi.printMessage("You entered an incorrect value");
            return inputNumberOfDays();
        }
    }

    public void setView(ViewUi viewUi) {
        this.viewUi = viewUi;
    }
}