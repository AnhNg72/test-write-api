package com.localintegrationapps.simpleapi.service.mcr;

import com.localintegrationapps.simpleapi.dto.OrderDTO;

import java.util.List;

public interface McrOrdersService {
    void createOrUpdateOrderService(List<OrderDTO> ordersDTOList);
}
