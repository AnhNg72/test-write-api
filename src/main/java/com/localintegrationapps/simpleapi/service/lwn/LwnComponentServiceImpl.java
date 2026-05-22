package com.localintegrationapps.simpleapi.service.lwn;

import com.localintegrationapps.simpleapi.dto.ComponentDTO;
import com.localintegrationapps.simpleapi.io.entity.lwn.LwnComponentEntity;
import com.localintegrationapps.simpleapi.io.repository.lwn.LwnComponentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LwnComponentServiceImpl implements LwnComponentService {

    @Autowired
    LwnComponentsRepository componentsRepository;

    public LwnComponentServiceImpl(LwnComponentsRepository componentsRepository) {
        this.componentsRepository = componentsRepository;
    }

    @Override
    public void createOrUpdatePartListsService(List<ComponentDTO> componentDTOList)  {

        List<LwnComponentEntity> componentEntityList = new ArrayList<>();

        for (ComponentDTO componentDTO : componentDTOList) {
            ModelMapper modelMapper = new ModelMapper();
            LwnComponentEntity componentEntity = modelMapper.map(componentDTO, LwnComponentEntity.class);

            componentEntityList.add(componentEntity);
        }
        componentsRepository.upsertBatch(componentEntityList);
    }
}
