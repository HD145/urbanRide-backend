package com.urbanride.repository;

import com.urbanride.model.Driver;
import com.urbanride.model.DriverStatus;
import com.urbanride.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByUserId(Long userId);
    List<Driver> findByStatus(DriverStatus status);
    List<Driver> findByVehicleTypeAndStatus(VehicleType vehicleType, DriverStatus status);
    List<Driver> findByIsAvailableTrue();
    Optional<Driver> findByLicenseNumber(String licenseNumber);
    Optional<Driver> findByLicensePlate(String licensePlate);
} 