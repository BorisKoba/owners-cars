package telran.cars.dto;

import static telran.cars.api.ValidationConstants.*;

import java.util.Objects;

import jakarta.validation.constraints.*;


public record ModelDto(@NotEmpty(message = MISSING_CAR_MODEL_MESSAGE) String model, 
		@NotEmpty(message = MISSING_CAR_YEAR_MESSAGE) @Pattern(regexp = YEAR_REGEXP, message = WRONG_YEAR_FORMAT)String year, 
		@NotEmpty(message = MISSING_COMPANY_MESSAGE)String company,
		@NotEmpty(message = MISSING_ENGINE_POWER_MESSAGE)int enginePower, 
		@NotEmpty(message = MISSING_ENGINE_CAPACITY_MESSAGE)int engineCapacity) {

	@Override
	public int hashCode() {
		return Objects.hash(company, engineCapacity, enginePower, model, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelDto other = (ModelDto) obj;
		return Objects.equals(company, other.company) && engineCapacity == other.engineCapacity
				&& enginePower == other.enginePower && Objects.equals(model, other.model)
				&& Objects.equals(year, other.year);
	}

}
