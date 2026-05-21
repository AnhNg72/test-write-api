package com.localintegrationapps.simpleapi.service;

import com.localintegrationapps.simpleapi.dto.ComponentDTO;
import com.localintegrationapps.simpleapi.dto.DocumentDTO;

import java.awt.*;
import java.util.List;

public interface ComponentService {

    void createOrUpdatePartListsService(List<ComponentDTO> componentDTOList);
}
