package com.example.usermicroservice.mapper;

import com.example.usermicroservice.dto.CarDto;
import com.example.usermicroservice.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICarMapper {
    CarDto toCarDto(Car car);
    Car toCarModel(CarDto carDto);
}
