package com.bookcabapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookcabapp.entity.Booking;
import com.bookcabapp.service.BookingService;

@Controller
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookCab")
    public String bookCab(@ModelAttribute Booking booking, Model model) {
    	System.out.println(booking);
        Booking savedBooking = bookingService.bookCab(booking);
        model.addAttribute("booking", savedBooking);
        
        return "redirect:/bookingConfirmed.html";  
    }

}
