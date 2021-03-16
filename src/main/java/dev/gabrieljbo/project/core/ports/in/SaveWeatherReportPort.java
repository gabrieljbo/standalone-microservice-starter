package dev.gabrieljbo.project.core.ports.in;

import javax.validation.Valid;

import dev.gabrieljbo.project.domain.model.WeatherReport;

public interface SaveWeatherReportPort {

	public String saveReport(@Valid WeatherReport weatherReport);
	
}
