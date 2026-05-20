package com.localintegrationapps.simpleapi.service;

import com.localintegrationapps.simpleapi.dto.DocumentDTO;

import java.util.List;

public interface DocumentService {

    void createOrUpdateDocumentService(List<DocumentDTO> documentsDTOList);
}
