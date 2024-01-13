package telran.cars.service.model;

import lombok.*;
import jakarta.persistence.*;
import telran.cars.dto.CarDto;
import telran.cars.dto.CarState;
@Entity
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}