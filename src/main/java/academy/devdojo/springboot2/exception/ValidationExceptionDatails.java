package academy.devdojo.springboot2.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationExceptionDatails extends ExceptionDatails {
	
	private final String fields;
	private final String fieldsMessage;

}
