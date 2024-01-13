package telran.cars.service.model;

import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import telran.cars.dto.CarDto;
import telran.cars.dto.PersonDto;
@Getter
@NoArgsConstructor
@Entity
@Table(name = "car_owners")
public class CarOwner {
	@Id
	long id;
	String name;
	@Column(nullable = false, name = "birth_date")
	@Temporal(TemporalType.DATE)
	LocalDate birthDate;
	String email;
	
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
	 
	
}