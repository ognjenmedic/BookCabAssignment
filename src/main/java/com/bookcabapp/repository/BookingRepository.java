package com.bookcabapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookcabapp.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}
