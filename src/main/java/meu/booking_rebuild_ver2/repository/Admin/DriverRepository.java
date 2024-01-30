package meu.booking_rebuild_ver2.repository.Admin;

import meu.booking_rebuild_ver2.model.Admin.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DriverRepository extends JpaRepository<Driver, UUID> {
    @Query("SELECT dr FROM Driver dr WHERE dr.idBusTypes.id = :idBusType")
    List<Driver> findAllByIdBusTypes(UUID idBusType);
    Driver findByPhone(String phone);
    Driver findAllByKindOfLicense(String kindOfLicense);
}
