package com.bookcabapp.service;

import com.bookcabapp.entity.Booking;
import com.bookcabapp.repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookingServiceTest {

    @InjectMocks
    private BookingService bookingService;

    @Mock
    private BookingRepository bookingRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBookCab() {
        // Given
        Booking booking = new Booking();
        booking.setFromLocation("work");
        booking.setToLocation("home");
        booking.setCabType("standard");

        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        // When
        Booking savedBooking = bookingService.bookCab(booking);

        // Then
        assertNotNull(savedBooking);
        assertEquals("work", savedBooking.getFromLocation());
        assertEquals("home", savedBooking.getToLocation());
        assertEquals("standard", savedBooking.getCabType());
    }
}
