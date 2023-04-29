package com.example.bikemicroservice.mapper;

import com.example.bikemicroservice.dto.BikeDto;
import com.example.bikemicroservice.entity.Bike;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IBikeMapper {
    BikeDto toBikeDto(Bike bike);
    Bike toBikeEntity(BikeDto bikeDto);
}
