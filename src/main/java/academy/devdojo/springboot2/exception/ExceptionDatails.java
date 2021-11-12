package academy.devdojo.springboot2.exception;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ExceptionDatails {
	
	protected String title;
	protected int status;
	protected String details;
	protected String developMessage;
	protected LocalDateTime timestamp;

}
