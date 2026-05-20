package com.localintegrationapps.simpleapi.ui.controller;

import com.localintegrationapps.simpleapi.dto.AddressDTO;
import com.localintegrationapps.simpleapi.dto.DocumentDTO;
import com.localintegrationapps.simpleapi.dto.MaterialDTO;
import com.localintegrationapps.simpleapi.dto.OrderDTO;
import com.localintegrationapps.simpleapi.service.AddressService;
import com.localintegrationapps.simpleapi.service.DocumentService;
import com.localintegrationapps.simpleapi.service.MaterialService;
import com.localintegrationapps.simpleapi.service.OrdersService;
import com.localintegrationapps.simpleapi.ui.model.AddressRestInputModel;
import com.localintegrationapps.simpleapi.ui.model.DocumentRestInputModel;
import com.localintegrationapps.simpleapi.ui.model.MaterialRestInputModel;
import com.localintegrationapps.simpleapi.ui.model.OrderRestInputModel;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/lwn")
public class GeneralController {

    MaterialService materialService;
    OrdersService ordersService;
    DocumentService documentService;
    AddressService addressService;

    public GeneralController(MaterialService materialService, OrdersService ordersService, DocumentService documentService) {

        this.materialService = materialService;
        this.ordersService = ordersService;
        this.documentService = documentService;
    }

    @PostMapping("/Articles")
    public List<MaterialDTO> createOrUpdateMaterial(@RequestBody List<MaterialRestInputModel> payloadList) {

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
    public List<OrderDTO> createOrUpdateOrder(@RequestBody List<OrderRestInputModel> payloadList) {

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
    public List<DocumentDTO> createOrUpdateDocument(@RequestBody List<DocumentRestInputModel> payloadList) {

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
    public List<AddressDTO> createOrUpdateAddress(@RequestBody List<AddressRestInputModel> payloadList) {

        List<AddressDTO> returnValue = new ArrayList<>();

        for (AddressRestInputModel payload : payloadList) {
            System.out.println(payload);

            ModelMapper modelMapper = new ModelMapper();
            AddressDTO addressDTO = modelMapper.map(payload, AddressDTO.class);

            returnValue.add(addressDTO);
        }
        addressService.createOrUpdateAddressService(returnValue);

        return returnValue;
    }

//    @PostMapping("/PartLists")
}