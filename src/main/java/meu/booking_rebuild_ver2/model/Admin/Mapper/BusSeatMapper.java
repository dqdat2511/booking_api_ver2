package meu.booking_rebuild_ver2.model.Admin.Mapper;

import meu.booking_rebuild_ver2.model.Admin.BusSeat;
import meu.booking_rebuild_ver2.model.Admin.DTO.BusSeatDTO;

/*
 * author: Nguyen Quoc Dai
 * ticket: BS-8
 * */
public class BusSeatMapper {
    public static BusSeatDTO busSeatToDTO(BusSeat busSeat){
        BusSeatDTO busSeatDTO = new BusSeatDTO();
        busSeatDTO.setId(busSeat.getId());
        busSeatDTO.setNameSeat(busSeat.getNameSeat());
        busSeatDTO.setAvailable(busSeat.isAvailable());
        busSeatDTO.setFloorNumber(busSeat.getFloorNumber());
        busSeatDTO.setIdBusTypes(BusTypeMapper.busTypeDTO(busSeat.getIdBusTypes()));

        return busSeatDTO;
    }

    public static BusSeat dtoToBusSeat(BusSeatDTO busSeatDTO){
        BusSeat busSeat = new BusSeat();
        busSeat.setId(busSeatDTO.getId());
        busSeat.setNameSeat(busSeatDTO.getNameSeat());
        busSeat.setFloorNumber(busSeatDTO.getFloorNumber());
        busSeat.setAvailable(busSeatDTO.isAvailable());
        busSeat.setIdBusTypes(BusTypeMapper.dtoToBusTypes(busSeatDTO.getIdBusTypes()));

        return busSeat;
    }
}
