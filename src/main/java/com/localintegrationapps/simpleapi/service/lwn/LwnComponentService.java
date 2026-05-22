package com.localintegrationapps.simpleapi.service.lwn;

import com.localintegrationapps.simpleapi.dto.ComponentDTO;

import java.util.List;

public interface LwnComponentService {

    void createOrUpdatePartListsService(List<ComponentDTO> componentDTOList);
}
