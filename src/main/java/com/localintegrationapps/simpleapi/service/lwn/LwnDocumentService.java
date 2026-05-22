package com.localintegrationapps.simpleapi.service.lwn;

import com.localintegrationapps.simpleapi.dto.DocumentDTO;

import java.util.List;

public interface LwnDocumentService {

    void createOrUpdateDocumentService(List<DocumentDTO> documentsDTOList);
}
