package com.localintegrationapps.simpleapi.service;


import com.localintegrationapps.simpleapi.dto.MaterialDTO;

import java.util.List;

public interface MaterialService {

    void createOrUpdateService(List<MaterialDTO> materialDTO);

}
