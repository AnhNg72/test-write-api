package com.localintegrationapps.simpleapi.service;

import com.localintegrationapps.simpleapi.dto.OrderDTO;

import java.util.List;

public interface OrdersService {
    void createOrUpdateOrderService(List<OrderDTO> ordersDTOList);
}
