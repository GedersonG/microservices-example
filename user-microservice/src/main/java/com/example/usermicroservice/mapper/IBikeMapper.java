package com.example.usermicroservice.mapper;

import com.example.usermicroservice.dto.BikeDto;
import com.example.usermicroservice.model.Bike;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IBikeMapper {
    BikeDto toBikeDto(Bike bike);
    Bike toBikeModel(BikeDto bikeDto);
}
