package telran.cars.service.model;
import jakarta.persistence.*;
import lombok.*;
import telran.cars.dto.ModelDto;
@Entity

@Table(name = "models")
@Getter
public class Model {
	@EmbeddedId
	ModelYear modelYear;
	@Column(nullable = false)
	String company;
	@Column(name = "engine_power", nullable = false)
	int enginePower;
	@Column(name = "engine_capacity", nullable = false)
	int engineCapacity;
public Model(ModelDto modelDto) {
	modelYear = getModelYear();
	company = modelDto.company();
	enginePower = modelDto.enginePower();
	engineCapacity = modelDto.engineCapacity();	
}
public ModelDto build() {
	return new ModelDto(modelYear.name,modelYear.getYear(),company, enginePower, engineCapacity);
	
}
}
