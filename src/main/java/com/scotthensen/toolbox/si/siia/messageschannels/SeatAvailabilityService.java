package com.scotthensen.toolbox.si.siia.messageschannels;

import lombok.extern.slf4j.Slf4j;

import org.springframework.integration.annotation.ServiceActivator;

//@Service
@Slf4j
public class SeatAvailabilityService
{
	@ServiceActivator
	public SeatConfirmation confirmSeat( ChargedBooking chargedBooking )
	{
		Seat seat = new Seat( "1A" );
		log.debug("\n>>> Assign {}", seat);
		return new SeatConfirmation( chargedBooking, seat);
	}
}
