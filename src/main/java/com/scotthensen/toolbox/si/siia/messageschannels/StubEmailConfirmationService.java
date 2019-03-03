package com.scotthensen.toolbox.si.siia.messageschannels;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StubEmailConfirmationService implements MessageHandler
{

	private List<Email> emails = new ArrayList<>();
	
	CountDownLatch countDownLatch = new CountDownLatch(1);  // this is just for local; don't latch in prod
	
	@Override
	public void handleMessage(Message<?> message) throws MessagingException
	{
		SeatConfirmation seatConfirmation = (SeatConfirmation) message.getPayload();
		
		ChargedBooking chargedBooking = seatConfirmation.getChargedBooking();
		Booking booking = chargedBooking.getBooking();
		Email email = new Email(booking.getCustomerEmail(),
				"Your booking on flight " + booking.getFlightId() + " has been confirmed." +
				"You have seat number " + seatConfirmation.getSeat().getSeatNumber());
		
		log.debug("\n>>> sending email: {}", email);
		sendEmail(email);
	}
	
	public void sendEmail(Email email) 
	{
		countDownLatch.countDown();
		emails.add(email);
	}

	public List<Email> getEmails() throws InterruptedException 
	{
		countDownLatch.await(5, TimeUnit.SECONDS);
		return emails;
	}


}
