package com.scotthensen.toolbox.si.siia.messageschannels;

import org.springframework.integration.annotation.MessageEndpoint;

import lombok.AllArgsConstructor;
import lombok.Getter;

@MessageEndpoint
@Getter
@AllArgsConstructor
public class ChargedBooking 
{
	private Booking booking;
	private Long confirmationNumber;
}
