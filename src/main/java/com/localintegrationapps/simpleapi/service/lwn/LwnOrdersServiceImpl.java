package com.localintegrationapps.simpleapi.service.lwn;

import com.localintegrationapps.simpleapi.dto.OrderDTO;
import com.localintegrationapps.simpleapi.io.entity.lwn.LwnOrderEntity;
import com.localintegrationapps.simpleapi.io.repository.lwn.LwnOrdersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LwnOrdersServiceImpl implements LwnOrdersService {

    @Autowired
    LwnOrdersRepository ordersRepository;

    public LwnOrdersServiceImpl(LwnOrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public void createOrUpdateOrderService(List<OrderDTO> ordersDTOList) {

        List<LwnOrderEntity> orderEntityList = new ArrayList<>();

        for (OrderDTO orderDTO : ordersDTOList) {
            ModelMapper modelMapper = new ModelMapper();
            LwnOrderEntity orderEntity = modelMapper.map(orderDTO, LwnOrderEntity.class);

            orderEntityList.add(orderEntity);
        }
        ordersRepository.upsertBatch(orderEntityList);
    }
}
