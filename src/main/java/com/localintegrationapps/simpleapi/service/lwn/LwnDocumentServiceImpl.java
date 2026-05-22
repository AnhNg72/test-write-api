package com.localintegrationapps.simpleapi.service.lwn;

import com.localintegrationapps.simpleapi.dto.DocumentDTO;
import com.localintegrationapps.simpleapi.io.entity.lwn.LwnDocumentEntity;
import com.localintegrationapps.simpleapi.io.repository.lwn.LwnDocumentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LwnDocumentServiceImpl implements LwnDocumentService {

    @Autowired
    LwnDocumentsRepository documentsRepository;

    public LwnDocumentServiceImpl(LwnDocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;
    }

    @Override
    public void createOrUpdateDocumentService(List<DocumentDTO> documentsDTOList) {

        List<LwnDocumentEntity> documentEntityList = new ArrayList<>();

        for (DocumentDTO documentDTO : documentsDTOList) {
            ModelMapper modelMapper = new ModelMapper();
            LwnDocumentEntity documentEntity = modelMapper.map(documentDTO, LwnDocumentEntity.class);

            documentEntityList.add(documentEntity);
        }
        documentsRepository.upsertBatch(documentEntityList);
    }
}
