package com.scotthensen.toolbox.si.siia.messageschannels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatConfirmation 
{
	private ChargedBooking chargedBooking;
	private Seat seat;
}
