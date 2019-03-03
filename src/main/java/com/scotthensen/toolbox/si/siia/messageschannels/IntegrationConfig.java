package com.scotthensen.toolbox.si.siia.messageschannels;
/*
package com.scotthensen.toolbox.si.messageschannels;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class IntegrationConfig 
{
	private static final String INPUT_DIR = null;

//	@Bean
//	public MessageSource<File> sourceDirectory() {
//		FileReadingMessageSource messageSource = new FileReadingMessageSource();
//		messageSource.setDirectory = (new File(INPUT_DIR));
//		return messageSource;
//	}
	@Bean
	public MessageChannel bookingConfirmationRequests() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel chargedBookings() {
		return new DirectChannel();
	}
	
//    @Bean
//    @ServiceActivator( inputChannel = "bookingConfirmationRequests", outputChannel = "chargedBookings" )
//	public SeatConfirmation confirmSeat( ChargedBooking chargedBooking )
//	{
//		Seat seat = new Seat( "1A" );
//		return new SeatConfirmation( chargedBooking, seat);
//	}

   @Bean
   public IntegrationFlow flow() {
       return IntegrationFlows
    		   .from(this.bookingConfirmationRequests())
//    		   .channel(this.bookingConfirmationRequests())
               .<Booking, ChargedBooking>transform(BillForBookingService::pay)
               .channel(this.chargedBookings())
               .transform(SeatAvailabilityService::confirmSeat)
               .channel(this.emailConfirmationRequests)
//    		   .channel(this.inputChannel())
//                   .filter((Integer p) -> p > 0)
//                   .transform(Object::toString)
//                   .channel(MessageChannels.queue())
//                   .get();
   }

}
*/