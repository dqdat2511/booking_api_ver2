package meu.booking_rebuild_ver2.controller.Admin;

import jakarta.servlet.http.HttpSession;
import meu.booking_rebuild_ver2.exception.GenericResponseException;
import meu.booking_rebuild_ver2.exception.NotFoundException;
import meu.booking_rebuild_ver2.model.Admin.Loyalty;
import meu.booking_rebuild_ver2.request.LoyaltyRequest;
import meu.booking_rebuild_ver2.response.Admin.LoyaltyResponse;
import meu.booking_rebuild_ver2.response.GenericResponse;
import meu.booking_rebuild_ver2.service.abstractions.Admin.ILoyaltyService;
import meu.booking_rebuild_ver2.service.abstractions.Passanger.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/*
 * author: Nguyen Minh Tam
 * ticket: BS-2
 * */
@RestController
@RequestMapping(path = "/loyalty", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoyaltyController {
    @Autowired
    private ILoyaltyService loyaltyService;
    @Autowired
    private ICustomerService customerService;
    /*
    * The function to add new loyalty with request with no duplicate rank and discount.
    * The model will ensure that the rank and discount are unique
     */
    @PostMapping(path = "addLoyalty")
    public GenericResponse addNewLoyalty(@RequestBody @Valid Loyalty request, @NotNull HttpSession httpSession) throws GenericResponseException {
        return loyaltyService.addNewLoyalty(request, httpSession);
    }
    /*
     * The function to get all rank and it's discount in table loyalty.
     */
    @GetMapping(path = "getAllLoyalty")
    public LoyaltyResponse getAllLoyalty(){
        return  loyaltyService.getAllLoyalty();
    }
    @GetMapping(path = "getLoyaltyByRank")
    /*
     * The function to get the detail of rank. With the rank is input from user
     */
    public LoyaltyResponse getLoyalty(@RequestBody LoyaltyRequest request) throws NotFoundException, GenericResponseException {
        return  loyaltyService.getLoyaltyByRank(request.getRank());
    }
    /*
     * The function used to get the rank with price will be the norm according to loyalty_spent
     */
    @GetMapping(path = "getLoyaltyByPrice")
    public LoyaltyResponse getLoyaltyByPrice(@RequestParam double price) throws GenericResponseException {
        return loyaltyService.getLoyaltyByPrice(price);
    }
    /*
     * The function used to get the rank with price will be the norm according to id loyalty
     */
    @GetMapping(path = "getLoyaltyById")
    public LoyaltyResponse getLoyaltyById(@RequestParam UUID id) throws GenericResponseException, NotFoundException {
        return loyaltyService.getLoyaltyById(id);
    }
    /*
     * The function to update the loyalty from id and dto
     */
    @PutMapping(path = "updateLoyalty")
    public GenericResponse updateLoyalty(@RequestParam UUID id, @RequestBody LoyaltyRequest request, @NotNull HttpSession httpSession) throws NotFoundException, GenericResponseException {
        return loyaltyService.updateLoyalty(id, request, httpSession);
    }
    /*
     * The function to delete the loyalty form id
     */
    @DeleteMapping(path = "deleteLoyalty")
    public GenericResponse deleteLoyalty(@RequestParam UUID id) throws NotFoundException, GenericResponseException {
        System.out.println(customerService.getCustomerByLoyalty(id).getListCustomer());
         customerService.handleUpdateCustomerWhenLoyaltyDelete(customerService.getCustomerByLoyalty(id).getListCustomer());
        return loyaltyService.deleteLoyalty(id);
    }
}
