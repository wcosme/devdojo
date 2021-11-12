package academy.devdojo.springboot2.request;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimePostRequestBody {
	
	@NotEmpty(message = "O Campo nome não pode ser vazio.")
	private String name;

}
