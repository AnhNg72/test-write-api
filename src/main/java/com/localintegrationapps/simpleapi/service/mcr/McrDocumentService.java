package com.localintegrationapps.simpleapi.service.mcr;

import com.localintegrationapps.simpleapi.dto.DocumentDTO;

import java.util.List;

public interface McrDocumentService {

    void createOrUpdateDocumentService(List<DocumentDTO> documentsDTOList);
}
