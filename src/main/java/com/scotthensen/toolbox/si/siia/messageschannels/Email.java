package com.scotthensen.toolbox.si.siia.messageschannels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email 
{
	private String recipient;
	private String content;
}
