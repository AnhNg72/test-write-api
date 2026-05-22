package com.localintegrationapps.simpleapi.service.mcr;

import com.localintegrationapps.simpleapi.dto.DocumentDTO;
import com.localintegrationapps.simpleapi.io.entity.mcr.McrDocumentEntity;
import com.localintegrationapps.simpleapi.io.repository.mcr.McrDocumentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class McrDocumentServiceImpl implements McrDocumentService {

    @Autowired
    McrDocumentsRepository documentsRepository;

    public McrDocumentServiceImpl(McrDocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;
    }

    @Override
    public void createOrUpdateDocumentService(List<DocumentDTO> documentsDTOList) {

        List<McrDocumentEntity> documentEntityList = new ArrayList<>();

        for (DocumentDTO documentDTO : documentsDTOList) {
            ModelMapper modelMapper = new ModelMapper();
            McrDocumentEntity documentEntity = modelMapper.map(documentDTO, McrDocumentEntity.class);

            documentEntityList.add(documentEntity);
        }
        documentsRepository.upsertBatch(documentEntityList);
    }
}
