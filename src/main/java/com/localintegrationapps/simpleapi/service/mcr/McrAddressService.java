package com.localintegrationapps.simpleapi.service.mcr;

import com.localintegrationapps.simpleapi.dto.AddressDTO;

import java.util.List;

public interface McrAddressService {
    void createOrUpdateAddressService(List<AddressDTO> addressesDTOList);
}
