package com.localintegrationapps.simpleapi.service.lwn;


import com.localintegrationapps.simpleapi.dto.MaterialDTO;

import java.util.List;

public interface LwnMaterialService {

    void createOrUpdateService(List<MaterialDTO> materialDTO);

}
