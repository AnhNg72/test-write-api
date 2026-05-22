package com.localintegrationapps.simpleapi.service.mcr;

import com.localintegrationapps.simpleapi.dto.ComponentDTO;
import com.localintegrationapps.simpleapi.io.entity.mcr.McrComponentEntity;
import com.localintegrationapps.simpleapi.io.repository.mcr.McrComponentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class McrComponentServiceImpl implements McrComponentService {

    @Autowired
    McrComponentsRepository componentsRepository;

    public McrComponentServiceImpl(McrComponentsRepository componentsRepository) {
        this.componentsRepository = componentsRepository;
    }

    @Override
    public void createOrUpdatePartListsService(List<ComponentDTO> componentDTOList)  {

        List<McrComponentEntity> componentEntityList = new ArrayList<>();

        for (ComponentDTO componentDTO : componentDTOList) {
            ModelMapper modelMapper = new ModelMapper();
            McrComponentEntity componentEntity = modelMapper.map(componentDTO, McrComponentEntity.class);

            componentEntityList.add(componentEntity);
        }
        componentsRepository.upsertBatch(componentEntityList);
    }
}
