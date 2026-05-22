package com.localintegrationapps.simpleapi.service.mcr;

import com.localintegrationapps.simpleapi.dto.MaterialDTO;
import com.localintegrationapps.simpleapi.io.entity.mcr.McrMaterialEntity;
import com.localintegrationapps.simpleapi.io.repository.mcr.McrMaterialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class McrMaterialServiceImpl implements McrMaterialService {

    @Autowired
    McrMaterialRepository materialRepository;

    public McrMaterialServiceImpl(McrMaterialRepository materialRepository) {

        this.materialRepository = materialRepository;
    }


    @Override
    public void createOrUpdateService(List<MaterialDTO> materialDTOList) {

        List<McrMaterialEntity> materialEntityList = new ArrayList<>();

        for (MaterialDTO materialDTO : materialDTOList) {
        ModelMapper modelMapper = new ModelMapper();
        McrMaterialEntity materialEntity = modelMapper.map(materialDTO, McrMaterialEntity.class);

        materialEntityList.add(materialEntity);
        //materialRepository.save(materialEntity);
    }
        materialRepository.upsertBatch(materialEntityList);
}
}
