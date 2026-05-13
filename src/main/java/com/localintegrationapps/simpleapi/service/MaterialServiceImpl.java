package com.localintegrationapps.simpleapi.service;

import com.localintegrationapps.simpleapi.dto.MaterialDTO;
import com.localintegrationapps.simpleapi.io.MaterialEntity;
import com.localintegrationapps.simpleapi.io.MaterialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {

        this.materialRepository = materialRepository;
    }


    @Override
    public void createOrUpdateService(List<MaterialDTO> materialDTOList) {

        List<MaterialEntity> materialEntityList = new ArrayList<>();

        for (MaterialDTO materialDTO : materialDTOList) {
        ModelMapper modelMapper = new ModelMapper();
        MaterialEntity materialEntity = modelMapper.map(materialDTO, MaterialEntity.class);

        materialEntityList.add(materialEntity);
        //materialRepository.save(materialEntity);
    }
        materialRepository.upsertBatch(materialEntityList);
}
}
