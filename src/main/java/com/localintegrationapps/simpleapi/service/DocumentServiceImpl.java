package com.localintegrationapps.simpleapi.service;

import com.localintegrationapps.simpleapi.dto.DocumentDTO;
import com.localintegrationapps.simpleapi.io.DocumentEntity;
import com.localintegrationapps.simpleapi.io.DocumentsRepository;
import com.localintegrationapps.simpleapi.io.OrderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentsRepository documentsRepository;

    public DocumentServiceImpl(DocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;
    }

    @Override
    public void createOrUpdateDocumentService(List<DocumentDTO> documentsDTOList) {

        List<DocumentEntity> documentEntityList = new ArrayList<>();

        for (DocumentDTO documentDTO : documentsDTOList) {
            ModelMapper modelMapper = new ModelMapper();
            DocumentEntity documentEntity = modelMapper.map(documentDTO, DocumentEntity.class);

            documentEntityList.add(documentEntity);
        }
        documentsRepository.upsertBatch(documentEntityList);
    }
}
