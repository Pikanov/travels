package com.joinup.service.Impl;

import com.joinup.entity.TravelVoucher;
import com.joinup.repository.TravelVoucherRepository;
import com.joinup.repository.impl.TravelVoucherRepositoryImpl;
import com.joinup.service.TravelVoucherService;
import com.joinup.util.QueryParam;

import java.util.List;

public class TravelVoucherServiceImpl implements TravelVoucherService {

    private TravelVoucherRepository travelVoucherRepository;

    public TravelVoucherServiceImpl() {
        this.travelVoucherRepository = new TravelVoucherRepositoryImpl();
    }


    @Override
    public List<TravelVoucher> defineTour(QueryParam queryParam) {
        if (queryParam != null) {
            return travelVoucherRepository.defineTour(queryParam);
        }
        return null;
    }
}
