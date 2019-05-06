package com.joinup.service.Impl;

import com.joinup.entity.Transport;
import com.joinup.repository.TransportRepository;
import com.joinup.repository.impl.TransportRepositoryImpl;
import com.joinup.service.TransportService;

import java.util.List;

public class TransportServiceImpl implements TransportService {

    private TransportRepository transportRepository;

    public TransportServiceImpl() {
        this.transportRepository = new TransportRepositoryImpl();
    }

    @Override
    public List<Transport> isAll() {
        return transportRepository.isAll();
    }
}
