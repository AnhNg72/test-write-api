package com.localintegrationapps.simpleapi.ui.controller;

import com.localintegrationapps.simpleapi.dto.*;
import com.localintegrationapps.simpleapi.io.AddressesRepository;
import com.localintegrationapps.simpleapi.io.DocumentsRepository;
import com.localintegrationapps.simpleapi.service.*;
import com.localintegrationapps.simpleapi.ui.model.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/lwn")
public class GeneralController {

    MaterialService materialService;
    OrdersService ordersService;
    DocumentService documentService;
    AddressService addressService;
    ComponentService componentService;

    public GeneralController(MaterialService materialService,
                             OrdersService ordersService,
                             DocumentService documentService,
                             AddressService addressService,
                             ComponentService componentService) {

        this.materialService = materialService;
        this.ordersService = ordersService;
        this.documentService = documentService;
        this.addressService = addressService;
        this.componentService = componentService;
    }

    @PostMapping("/Articles")
    public List<MaterialDTO> createOrUpdateMaterial(@Valid @RequestBody List<MaterialRestInputModel> payloadList) {

        List<MaterialDTO> returnValue = new ArrayList<>();

        for (MaterialRestInputModel payload : payloadList) {
            System.out.println(payload);

        ModelMapper modelMapper = new ModelMapper();
        MaterialDTO materialDTO = modelMapper.map(payload, MaterialDTO.class);

        returnValue.add(materialDTO);
        }
        materialService.createOrUpdateService(returnValue);

        return returnValue;

    }

    @PostMapping("/Orders")
    public List<OrderDTO> createOrUpdateOrder(@Valid @RequestBody List<OrderRestInputModel> payloadList) {

        List<OrderDTO> returnValue = new ArrayList<>();

        for (OrderRestInputModel payload : payloadList) {
            System.out.println(payload);

            ModelMapper modelMapper = new ModelMapper();
            OrderDTO orderDTO = modelMapper.map(payload, OrderDTO.class);

            returnValue.add(orderDTO);
        }
        ordersService.createOrUpdateOrderService(returnValue);

        return returnValue;

    }


    @PostMapping("/Documents")
    public List<DocumentDTO> createOrUpdateDocument(@Valid @RequestBody List<DocumentRestInputModel> payloadList) {

        List<DocumentDTO> returnValue = new ArrayList<>();

        for (DocumentRestInputModel payload : payloadList) {
            System.out.println(payload);

            ModelMapper modelMapper = new ModelMapper();
            DocumentDTO documentDTO = modelMapper.map(payload, DocumentDTO.class);

            returnValue.add(documentDTO);
        }
        documentService.createOrUpdateDocumentService(returnValue);

        return returnValue;
    }

    @PostMapping("/Addresses")
    public String createOrUpdateAddress(@Valid @RequestBody List<AddressRestInputModel> payloadList) {

        List<AddressDTO> returnValue = new ArrayList<>();

        for (AddressRestInputModel payload : payloadList) {
            System.out.println(payload);

            ModelMapper modelMapper = new ModelMapper();
            AddressDTO addressDTO = modelMapper.map(payload, AddressDTO.class);

            returnValue.add(addressDTO);
        }
        addressService.createOrUpdateAddressService(returnValue);

        return null;
    }

    @PostMapping("/PartLists")
    public String createOrUpdatePartLists(@Valid @RequestBody List<ComponentRestInputModel> payloadList) {
        ModelMapper modelMapper = new ModelMapper();


        for (ComponentRestInputModel payload : payloadList) {
            List<ComponentDTO> listComponentDTO = new ArrayList<>();

            System.out.println(payload);

            String artikelnummer = modelMapper.map(payload.getKopf(), ComponentKopfDTO.class).getArtikelnummer();

            List<ComponentPositionRestInputModel> listComponentPositionRest = payload.getPosition();

            for (ComponentPositionRestInputModel payload1 : listComponentPositionRest) {

                ComponentPositionDTO componentPositionDTO = modelMapper.map(payload1, ComponentPositionDTO.class);
               // listComponentPositionDTO.add(componentPositionDTO);
                
                ComponentDTO componentDTO = new ComponentDTO();
                componentDTO.setArtikelnummer(artikelnummer);
                componentDTO.setStuecklistenelement(componentPositionDTO.getStuecklistenelement());
                componentDTO.setSatzart(componentPositionDTO.getSatzart());
                componentDTO.setBeschreibung(componentPositionDTO.getBeschreibung());
                componentDTO.setMengeneinheit(componentPositionDTO.getMengeneinheit());
                componentDTO.setTheoretische_menge(componentPositionDTO.getTheoretische_menge());
                componentDTO.setPreis_kosten_fuer_1000_me(componentPositionDTO.getPreis_kosten_fuer_1000_me());
                componentDTO.setZuschlagsfaktor(componentPositionDTO.getZuschlagsfaktor());
                componentDTO.setFiktive_stueckliste(componentPositionDTO.getFiktive_stueckliste());
                componentDTO.setDatensatztyp(componentPositionDTO.getDatensatztyp());

                listComponentDTO.add(componentDTO);
            }
            componentService.createOrUpdatePartListsService(listComponentDTO);

        }



        return null;
    }
}