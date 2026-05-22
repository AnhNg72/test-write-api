package com.localintegrationapps.simpleapi.service.mcr;


import com.localintegrationapps.simpleapi.dto.MaterialDTO;

import java.util.List;

public interface McrMaterialService {

    void createOrUpdateService(List<MaterialDTO> materialDTO);

}
