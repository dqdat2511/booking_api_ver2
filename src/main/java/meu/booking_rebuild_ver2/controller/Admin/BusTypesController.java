package meu.booking_rebuild_ver2.controller.Admin;


import meu.booking_rebuild_ver2.model.Admin.DTO.BusTypeDTO;
import meu.booking_rebuild_ver2.repository.Admin.BusTypesRepository;
import meu.booking_rebuild_ver2.response.Admin.BusTypesResponse;
import meu.booking_rebuild_ver2.service.concretions.Admin.BusTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/*
 * author: Nguyen Quoc Dai
 * ticket: BS-9
 * */
@RestController
@RequestMapping(path = "/busTypes", produces = MediaType.APPLICATION_JSON_VALUE)
public class BusTypesController {
    private final BusTypesRepository busTypesRepository;
    @Autowired
    private BusTypesService busTypesService;

    public BusTypesController(BusTypesRepository busTypesRepository) {
        this.busTypesRepository = busTypesRepository;
    }

    @PostMapping(path = "/addBusTypes")
    public BusTypesResponse addBusTypesPostMapping(@RequestBody @Valid BusTypeDTO busTypesDTO){
        return busTypesService.createBusType(busTypesDTO);
    }

    @GetMapping(path = "getAllBusTypes")
    public BusTypesResponse getAllBusTypes(){
        return busTypesService.getAllBusTypes();
    }

    @GetMapping(path = "getAllBusTypesByNumberOfSeat")
    public BusTypesResponse getAllBusTypesByNumberOfSeat(@RequestParam int numberOfSeat){
        return busTypesService.getAllBusTypesByNumberOfSeat(numberOfSeat);
    }

    @GetMapping(path = "getAllBusTypesByStatus")
    public BusTypesResponse getAllBusTypesByStatus(@RequestParam UUID idStatus){
        return busTypesService.getAllBusTypesByStatus(idStatus);
    }

    @GetMapping(path = "getBusTypesById")
    public BusTypesResponse getBusTypesById(@RequestParam UUID id){
        return busTypesService.getBusTypesById(id);
    }

    @GetMapping(path = "getBusTypesByLicensePlate")
    public BusTypesResponse getBusTypesByLicensePlate(@RequestParam String licensePlate){
        return busTypesService.getBusTypesByLicensePlate(licensePlate);
    }

    @PutMapping(path = "updateBusType")
    public BusTypesResponse updateBusType(@RequestBody @Valid BusTypeDTO busTypeDTO){
        return busTypesService.updateBusType(busTypeDTO);
    }

    @DeleteMapping(path = "deleteBusTypesById")
    public BusTypesResponse deleteBusTypesById(@RequestParam UUID id){
        return busTypesService.deleteBusTypesById(id);
    }
}
