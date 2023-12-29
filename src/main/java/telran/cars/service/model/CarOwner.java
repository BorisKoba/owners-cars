package telran.cars.service.model;

import java.time.LocalDate;
import java.util.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import telran.cars.dto.CarDto;
import telran.cars.dto.PersonDto;
@Getter
public class CarOwner {
	long id;
	String name;
	LocalDate birthDate;
	String email;
	List<Car> cars = new ArrayList<>();
	public CarOwner(PersonDto personDto) {
		id = personDto.id();
		name = personDto.name();
		birthDate = LocalDate.parse(personDto.birthDate());
		email = personDto.email();
	}
	public PersonDto build() {
		return new PersonDto(id, name, birthDate.toString(), email);
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void addCar(Car car) {
			this.cars.add(car);
		
	}
	
}