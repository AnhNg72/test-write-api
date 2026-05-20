package com.localintegrationapps.simpleapi.service;

import com.localintegrationapps.simpleapi.dto.OrderDTO;
import com.localintegrationapps.simpleapi.io.OrderEntity;
import com.localintegrationapps.simpleapi.io.OrdersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public void createOrUpdateOrderService(List<OrderDTO> ordersDTOList) {

        List<OrderEntity> orderEntityList = new ArrayList<>();

        for (OrderDTO orderDTO : ordersDTOList) {
            ModelMapper modelMapper = new ModelMapper();
            OrderEntity orderEntity = modelMapper.map(orderDTO, OrderEntity.class);

            orderEntityList.add(orderEntity);
        }
        ordersRepository.upsertBatch(orderEntityList);
    }
}
