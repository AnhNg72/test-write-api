package com.localintegrationapps.simpleapi.ui.controller;

import com.localintegrationapps.simpleapi.dto.*;
import com.localintegrationapps.simpleapi.service.lwn.*;
import com.localintegrationapps.simpleapi.ui.model.input.*;
import com.localintegrationapps.simpleapi.ui.model.output.RestOutputModel;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/lwn")
public class LwnGeneralController {

    LwnMaterialService materialService;
    LwnOrdersService ordersService;
    LwnDocumentService documentService;
    LwnAddressService addressService;
    LwnComponentService componentService;

    public LwnGeneralController(LwnMaterialService materialService,
                                LwnOrdersService ordersService,
                                LwnDocumentService documentService,
                                LwnAddressService addressService,
                                LwnComponentService componentService) {

        this.materialService = materialService;
        this.ordersService = ordersService;
        this.documentService = documentService;
        this.addressService = addressService;
        this.componentService = componentService;
    }

    @PostMapping("/Articles")
    public ResponseEntity<RestOutputModel> createOrUpdateMaterial(@Valid @RequestBody List<MaterialRestInputModel> payloadList) {

        List<MaterialDTO> returnValue = new ArrayList<>();

        for (MaterialRestInputModel payload : payloadList) {
            System.out.println(payload);

        ModelMapper modelMapper = new ModelMapper();
        MaterialDTO materialDTO = modelMapper.map(payload, MaterialDTO.class);

        // validation (throw exception instead of returning error)
        if (payload.getArtikelnummer() == null || payload.getArtikelnummer().isEmpty()) {
            throw new IllegalArgumentException("Artikelnummer must not be empty");
        }

        returnValue.add(materialDTO);
        }
        materialService.createOrUpdateService(returnValue);


        RestOutputModel response = new RestOutputModel(
                "200",
                "Service is running successfully"
        );

        return ResponseEntity.ok(response);


    }

    @PostMapping("/Orders")
    public ResponseEntity<RestOutputModel> createOrUpdateOrder(@Valid @RequestBody List<OrderRestInputModel> payloadList) {

        List<OrderDTO> returnValue = new ArrayList<>();

        for (OrderRestInputModel payload : payloadList) {
            System.out.println(payload);

            ModelMapper modelMapper = new ModelMapper();
            OrderDTO orderDTO = modelMapper.map(payload, OrderDTO.class);

            // validation (throw exception instead of returning error)
            if (payload.getBestellnummer() == null || payload.getBestellnummer().isEmpty() || payload.getLieferantennummer() == null || payload.getLieferantennummer().isEmpty() || payload.getArtikelpositionsnummer() == null || payload.getArtikelpositionsnummer().isEmpty()) {
                throw new IllegalArgumentException("Bestellnummer, Lieferantennummer, Artikelpositionsnummer must not be empty");
            }

            returnValue.add(orderDTO);
        }
        ordersService.createOrUpdateOrderService(returnValue);

        RestOutputModel response = new RestOutputModel(
                "200",
                "Service is running successfully"
        );

        return ResponseEntity.ok(response);


    }


    @PostMapping("/Documents")
    public ResponseEntity<RestOutputModel> createOrUpdateDocument(@Valid @RequestBody List<DocumentRestInputModel> payloadList) {

        List<DocumentDTO> returnValue = new ArrayList<>();

        for (DocumentRestInputModel payload : payloadList) {
            System.out.println(payload);

            ModelMapper modelMapper = new ModelMapper();
            DocumentDTO documentDTO = modelMapper.map(payload, DocumentDTO.class);

            // validation (throw exception instead of returning error)
            if (payload.getBestellnummer() == null || payload.getBestellnummer().isEmpty() || payload.getBelegtyp() == null || payload.getBelegtyp().isEmpty() || payload.getArtikelpositionsnummer() == null || payload.getArtikelpositionsnummer().isEmpty()) {
                throw new IllegalArgumentException("Bestellnummer, Belegtyp, Artikelpositionsnummer must not be empty");
            }

            returnValue.add(documentDTO);
        }
        documentService.createOrUpdateDocumentService(returnValue);

        RestOutputModel response = new RestOutputModel(
                "200",
                "Service is running successfully"
        );

        return ResponseEntity.ok(response);

    }

    @PostMapping("/Addresses")
    public ResponseEntity<RestOutputModel> createOrUpdateAddress(@Valid @RequestBody List<AddressRestInputModel> payloadList) {

        List<AddressDTO> returnValue = new ArrayList<>();

        for (AddressRestInputModel payload : payloadList) {
            System.out.println(payload);

            ModelMapper modelMapper = new ModelMapper();
            AddressDTO addressDTO = modelMapper.map(payload, AddressDTO.class);

            // validation (throw exception instead of returning error)
            if (payload.getGeschaeftspartnernummer() == null || payload.getGeschaeftspartnernummer().isEmpty() || payload.getGeschaeftspartnertyp() == null || payload.getGeschaeftspartnertyp().isEmpty()) {
                throw new IllegalArgumentException("geschaeftspartnertyp and geschaeftspartnernummer must not be empty");
            }

            returnValue.add(addressDTO);
        }
        addressService.createOrUpdateAddressService(returnValue);

        RestOutputModel response = new RestOutputModel(
                "200",
                "Service is running successfully"
        );

        return ResponseEntity.ok(response);

    }

    @PostMapping("/PartLists")
    public ResponseEntity<RestOutputModel> createOrUpdatePartLists(@Valid @RequestBody List<ComponentRestInputModel> payloadList) {
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

                // validation (throw exception instead of returning error)
                if (artikelnummer == null || artikelnummer.isEmpty() || componentPositionDTO.getStuecklistenelement() == null || componentPositionDTO.getStuecklistenelement().isEmpty()) {
                    throw new IllegalArgumentException("artikelnummer and stuecklistenelement must not be empty");
                }

                listComponentDTO.add(componentDTO);
            }
            componentService.createOrUpdatePartListsService(listComponentDTO);

        }

        RestOutputModel response = new RestOutputModel(
                "200",
                "Service is running successfully"
        );

        return ResponseEntity.ok(response);

    }
}

