package dev.gabrieljbo.project.adapters.in.web.saveweatherreport;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.gabrieljbo.project.domain.model.WeatherReport;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoundedMapper {

	WeatherReport requestPayloadToWeatherReport(RequestPayload requestPayload);

}