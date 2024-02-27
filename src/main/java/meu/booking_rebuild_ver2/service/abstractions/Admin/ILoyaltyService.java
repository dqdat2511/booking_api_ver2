package meu.booking_rebuild_ver2.service.abstractions.Admin;

import jakarta.servlet.http.HttpSession;
import meu.booking_rebuild_ver2.exception.GenericResponseException;
import meu.booking_rebuild_ver2.exception.NotFoundException;
import meu.booking_rebuild_ver2.model.Admin.DTO.LoyaltyDTO;
import meu.booking_rebuild_ver2.model.Admin.Loyalty;
import meu.booking_rebuild_ver2.request.LoyaltyRequest;
import meu.booking_rebuild_ver2.response.Admin.LoyaltyResponse;
import meu.booking_rebuild_ver2.response.GenericResponse;

import java.util.Optional;
import java.util.UUID;

public interface ILoyaltyService {
    LoyaltyResponse getLoyaltyByRank(String rank) throws NotFoundException, GenericResponseException;
    GenericResponse addNewLoyalty(Loyalty request, HttpSession httpSession) throws GenericResponseException;
    Optional<Loyalty> getLoyaltyByDiscount(int discount);
    LoyaltyResponse getAllLoyalty();
    GenericResponse updateLoyalty(UUID id, LoyaltyRequest request, HttpSession httpSession) throws NotFoundException, GenericResponseException;
    GenericResponse deleteLoyalty(UUID id) throws NotFoundException;
    LoyaltyResponse getLoyaltyByPrice(double price) throws GenericResponseException;
    LoyaltyDTO getLoyaltyByPrice() throws GenericResponseException;
    LoyaltyResponse getLoyaltyById(UUID id) throws NotFoundException;

}
