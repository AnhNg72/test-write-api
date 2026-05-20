package com.localintegrationapps.simpleapi.service;

import com.localintegrationapps.simpleapi.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    void createOrUpdateAddressService(List<AddressDTO> addressesDTOList);
}
