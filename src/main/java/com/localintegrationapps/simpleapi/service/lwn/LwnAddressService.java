package com.localintegrationapps.simpleapi.service.lwn;

import com.localintegrationapps.simpleapi.dto.AddressDTO;

import java.util.List;

public interface LwnAddressService {
    void createOrUpdateAddressService(List<AddressDTO> addressesDTOList);
}
