package com.joinup.service;

import com.joinup.entity.TravelVoucher;
import com.joinup.util.QueryParam;

import java.util.List;

public interface TravelVoucherService {

    List<TravelVoucher> defineTour(QueryParam queryParam);

}
