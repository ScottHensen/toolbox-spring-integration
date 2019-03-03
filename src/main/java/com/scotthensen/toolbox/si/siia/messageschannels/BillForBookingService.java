package com.scotthensen.toolbox.si.siia.messageschannels;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Payload;

import lombok.extern.slf4j.Slf4j;

@MessageEndpoint	
@Slf4j
public class BillForBookingService 
{
	@ServiceActivator
	public ChargedBooking pay(@Payload Booking booking)
	{
		log.debug("\n>>> Charged for booking");
		return new ChargedBooking( booking, 1L );
	}
}
