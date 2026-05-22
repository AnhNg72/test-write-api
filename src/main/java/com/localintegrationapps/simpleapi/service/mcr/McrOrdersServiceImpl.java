package com.localintegrationapps.simpleapi.service.mcr;

import com.localintegrationapps.simpleapi.dto.OrderDTO;
import com.localintegrationapps.simpleapi.io.entity.mcr.McrOrderEntity;
import com.localintegrationapps.simpleapi.io.repository.mcr.McrOrdersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class McrOrdersServiceImpl implements McrOrdersService {

    @Autowired
    McrOrdersRepository ordersRepository;

    public McrOrdersServiceImpl(McrOrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public void createOrUpdateOrderService(List<OrderDTO> ordersDTOList) {

        List<McrOrderEntity> orderEntityList = new ArrayList<>();

        for (OrderDTO orderDTO : ordersDTOList) {
            ModelMapper modelMapper = new ModelMapper();
            McrOrderEntity orderEntity = modelMapper.map(orderDTO, McrOrderEntity.class);

            orderEntityList.add(orderEntity);
        }
        ordersRepository.upsertBatch(orderEntityList);
    }
}
