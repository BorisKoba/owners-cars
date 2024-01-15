package telran.cars.dto;

import jakarta.validation.constraints.*;
import static telran.cars.api.ValidationConstants.*;

import java.util.Objects;

public record CarDto(
		@NotEmpty(message = MISSING_CAR_NUMBER_MESSAGE) @Pattern(regexp = CAR_NUMBER_REGEXP, message = WRONG_CAR_NUMBER_MESSAGE) String number,
		@NotEmpty(message = MISSING_CAR_MODEL_MESSAGE) String model,
		@NotEmpty(message = MISSING_CAR_YEAR_MESSAGE) @Pattern(regexp = YEAR_REGEXP, message = WRONG_YEAR_FORMAT)String year,
		@Min(value = MIN_PERSON_ID_VALUE, message = WRONG_MIN_PERSON_ID_VALUE) @Max(value = MAX_PERSON_ID_VALUE, message = WRONG_MAX_PERSON_ID_VALUE) Long personId,
		@NotEmpty(message = MISSING_CAR_COLOR_MESSAGE)String color, 
		@NotEmpty(message = MISSING_CAR_KILOMETERS_MESSAGE)int kilometers, 
		@NotEmpty(message = MISSING_CAR_STATE_MESSAGE)String state) {
	
@Override
	public int hashCode() {
		return Objects.hash(number);
	}
	public String number() {
		return number;
	}

	public String model() {
		return model;
	}
	
	public Long personId() {
		return personId;
	}

	public int kilometers() {
		return kilometers;
	}

	public String state() {
		return state;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarDto other = (CarDto) obj;
		return Objects.equals(number, other.number);
	}

}