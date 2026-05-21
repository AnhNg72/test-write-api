package com.localintegrationapps.simpleapi.service;

import com.localintegrationapps.simpleapi.dto.AddressDTO;
import com.localintegrationapps.simpleapi.dto.DocumentDTO;
import com.localintegrationapps.simpleapi.io.AddressEntity;
import com.localintegrationapps.simpleapi.io.AddressesRepository;
import com.localintegrationapps.simpleapi.io.DocumentEntity;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressesRepository addressesRepository;

    public AddressServiceImpl(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    @Override
    public void createOrUpdateAddressService(List<AddressDTO> addressesDTOList) {

        List<AddressEntity> addressEntityList = new ArrayList<>();

        for (AddressDTO addressDTO : addressesDTOList) {
            ModelMapper modelMapper = new ModelMapper();
            AddressEntity addressEntity = modelMapper.map(addressDTO, AddressEntity.class);

            addressEntityList.add(addressEntity);
        }
        addressesRepository.upsertBatch(addressEntityList);
    }
}

