package com.localintegrationapps.simpleapi.service.mcr;

import com.localintegrationapps.simpleapi.dto.ComponentDTO;

import java.util.List;

public interface McrComponentService {

    void createOrUpdatePartListsService(List<ComponentDTO> componentDTOList);
}
