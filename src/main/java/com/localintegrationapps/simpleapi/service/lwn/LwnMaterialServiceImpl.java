package com.localintegrationapps.simpleapi.service.lwn;

import com.localintegrationapps.simpleapi.dto.MaterialDTO;
import com.localintegrationapps.simpleapi.io.entity.lwn.LwnMaterialEntity;
import com.localintegrationapps.simpleapi.io.repository.lwn.LwnMaterialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LwnMaterialServiceImpl implements LwnMaterialService {

    @Autowired
    LwnMaterialRepository materialRepository;

    public LwnMaterialServiceImpl(LwnMaterialRepository materialRepository) {

        this.materialRepository = materialRepository;
    }


    @Override
    public void createOrUpdateService(List<MaterialDTO> materialDTOList) {

        List<LwnMaterialEntity> materialEntityList = new ArrayList<>();

        for (MaterialDTO materialDTO : materialDTOList) {
        ModelMapper modelMapper = new ModelMapper();
        LwnMaterialEntity materialEntity = modelMapper.map(materialDTO, LwnMaterialEntity.class);

        materialEntityList.add(materialEntity);
        //materialRepository.save(materialEntity);
    }
        materialRepository.upsertBatch(materialEntityList);
}
}
