package dev.gabrieljbo.project.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import dev.gabrieljbo.project.core.ports.in.SaveWeatherReportPort;
import dev.gabrieljbo.project.core.ports.out.WeatherReportDataStorePort;
import dev.gabrieljbo.project.domain.model.WeatherReport;

@Component
@Validated
public class SaveWeatherReportImpl implements SaveWeatherReportPort {

	@Autowired
	WeatherReportDataStorePort weatherReportDataStorePort;
	
	@Override
	public String saveReport(WeatherReport weatherReport) {
		String result = weatherReportDataStorePort.saveReport(weatherReport);
		
		return result;
	}

}
