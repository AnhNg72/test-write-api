package com.localintegrationapps.simpleapi.service.lwn;

import com.localintegrationapps.simpleapi.dto.AddressDTO;
import com.localintegrationapps.simpleapi.io.repository.lwn.LwnAddressesRepository;
import com.localintegrationapps.simpleapi.io.entity.lwn.LwnAddressEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LwnAddressServiceImpl implements LwnAddressService {

    @Autowired
    LwnAddressesRepository addressesRepository;

    public LwnAddressServiceImpl(LwnAddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    @Override
    public void createOrUpdateAddressService(List<AddressDTO> addressesDTOList) {

        List<LwnAddressEntity> addressEntityList = new ArrayList<>();

        for (AddressDTO addressDTO : addressesDTOList) {
            ModelMapper modelMapper = new ModelMapper();
            LwnAddressEntity addressEntity = modelMapper.map(addressDTO, LwnAddressEntity.class);

            addressEntityList.add(addressEntity);
        }
        addressesRepository.upsertBatch(addressEntityList);
    }
}

