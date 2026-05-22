package com.localintegrationapps.simpleapi.service.mcr;

import com.localintegrationapps.simpleapi.dto.AddressDTO;
import com.localintegrationapps.simpleapi.io.entity.mcr.McrAddressEntity;
import com.localintegrationapps.simpleapi.io.repository.mcr.McrAddressesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class McrAddressServiceImpl implements McrAddressService {

    @Autowired
    McrAddressesRepository addressesRepository;

    public McrAddressServiceImpl(McrAddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    @Override
    public void createOrUpdateAddressService(List<AddressDTO> addressesDTOList) {

        List<McrAddressEntity> addressEntityList = new ArrayList<>();

        for (AddressDTO addressDTO : addressesDTOList) {
            ModelMapper modelMapper = new ModelMapper();
            McrAddressEntity addressEntity = modelMapper.map(addressDTO, McrAddressEntity.class);

            addressEntityList.add(addressEntity);
        }
        addressesRepository.upsertBatch(addressEntityList);
    }
}

