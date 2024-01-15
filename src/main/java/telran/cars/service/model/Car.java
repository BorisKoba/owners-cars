package telran.cars.service.model;

import lombok.*;

import java.time.LocalDate;

import jakarta.persistence.*;
import telran.cars.dto.*;
import telran.cars.service.model.*;
@Entity
@AllArgsConstructor
@Getter
@Table(name = "cars")
public class Car {
	@Id
	String number;
	@ManyToOne
	@JoinColumns({@JoinColumn(name="model_name", nullable = false) ,
		@JoinColumn(name="model_year",nullable = false)})
	Model model;
	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = true)
	CarOwner carOwner;
	String color;
	int kilometers;
	@Enumerated(EnumType.STRING)
	CarState state;
	
	public Car(CarDto carDto) {
		number = carDto.number();
		model = new Model(carDto.model(), carDto.year());
		carOwner = getCarOwner();
		color = carDto.color();
		kilometers = carDto.kilometers();
		state = CarState.valueOf(carDto.state());    
	}
	
	public CarDto build() {
		return new CarDto(number, model.modelYear.name, model.modelYear.year, carOwner.id, color, kilometers, String.valueOf(state));
	}
	
	
	
	
}