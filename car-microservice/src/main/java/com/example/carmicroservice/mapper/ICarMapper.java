package com.example.carmicroservice.mapper;

import com.example.carmicroservice.dto.CarDto;
import com.example.carmicroservice.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICarMapper {
    CarDto toCarDto(Car car);
    Car toCarEntity(CarDto carDto);
}
