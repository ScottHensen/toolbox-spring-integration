package com.scotthensen.toolbox.si.siia.messageschannels;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.scotthensen.toolbox.si.siia.messageschannels.Booking;
import com.scotthensen.toolbox.si.siia.messageschannels.StubEmailConfirmationService;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:messageschannels/channels-all-direct.xml")
public class AllChannelsDirectTest 
{
	@Autowired
	@Qualifier( "bookingConfirmationRequests" )
	MessageChannel bookingsChannel;
	
	@Autowired
	StubEmailConfirmationService emailConfirmationService;
	
	@Test
	public void testChannels() throws Exception
	{
		Booking booking = new Booking();
		booking.setCustomerEmail( "user@example.com" );
		booking.setFlightId( "AC100" );
		Message<Booking> bookingMessage = MessageBuilder.withPayload(booking).build();
		bookingsChannel.send(bookingMessage);
		
		assertThat(emailConfirmationService.getEmails()).hasSize(1);
		
		bookingsChannel.send(bookingMessage);
		bookingsChannel.send(bookingMessage);
		bookingsChannel.send(bookingMessage);
		
	}
}
