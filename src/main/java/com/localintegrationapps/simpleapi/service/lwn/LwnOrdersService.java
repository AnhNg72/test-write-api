package com.localintegrationapps.simpleapi.service.lwn;

import com.localintegrationapps.simpleapi.dto.OrderDTO;

import java.util.List;

public interface LwnOrdersService {
    void createOrUpdateOrderService(List<OrderDTO> ordersDTOList);
}
