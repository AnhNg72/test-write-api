package com.localintegrationapps.simpleapi.service;

import com.localintegrationapps.simpleapi.dto.ComponentDTO;
import com.localintegrationapps.simpleapi.dto.DocumentDTO;
import com.localintegrationapps.simpleapi.io.ComponentEntity;
import com.localintegrationapps.simpleapi.io.ComponentsRepository;
import com.localintegrationapps.simpleapi.io.DocumentEntity;
import com.localintegrationapps.simpleapi.io.DocumentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComponentServiceImpl implements ComponentService {

    @Autowired
    ComponentsRepository componentsRepository;

    public ComponentServiceImpl(ComponentsRepository componentsRepository) {
        this.componentsRepository = componentsRepository;
    }

    @Override
    public void createOrUpdatePartListsService(List<ComponentDTO> componentDTOList)  {

        List<ComponentEntity> componentEntityList = new ArrayList<>();

        for (ComponentDTO componentDTO : componentDTOList) {
            ModelMapper modelMapper = new ModelMapper();
            ComponentEntity componentEntity = modelMapper.map(componentDTO, ComponentEntity.class);

            componentEntityList.add(componentEntity);
        }
        componentsRepository.upsertBatch(componentEntityList);
    }
}
