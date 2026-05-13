package com.localintegrationapps.simpleapi.ui.controller;

import com.localintegrationapps.simpleapi.dto.MaterialDTO;
import com.localintegrationapps.simpleapi.service.MaterialService;
import com.localintegrationapps.simpleapi.ui.model.RestInputModel;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/lwn")
public class MaterialController {

    MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping("/Articles")
    public List<MaterialDTO> createOrUpdateMaterial(@RequestBody List<RestInputModel> payloadList) {

        List<MaterialDTO> returnValue = new ArrayList<>();

        for (RestInputModel payload : payloadList) {
            System.out.println(payload);

        ModelMapper modelMapper = new ModelMapper();
        MaterialDTO materialDTO = modelMapper.map(payload, MaterialDTO.class);

        returnValue.add(materialDTO);
        }
        materialService.createOrUpdateService(returnValue);

        return returnValue;

    }

//    @PostMapping("/Addresses")
//
//    @PostMapping("/Documents")
//
//    @PostMapping("/Orders")
//
//    @PostMapping("/PartLists")
}