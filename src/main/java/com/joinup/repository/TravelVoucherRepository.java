package com.joinup.repository;

import com.joinup.entity.TravelVoucher;
import com.joinup.util.QueryParam;

import java.util.List;

public interface TravelVoucherRepository {

    List<TravelVoucher> defineTour(QueryParam queryParam);
}
