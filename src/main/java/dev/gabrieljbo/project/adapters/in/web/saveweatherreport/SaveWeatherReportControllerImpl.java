package dev.gabrieljbo.project.adapters.in.web.saveweatherreport;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dev.gabrieljbo.project.adapters.in.web.commons.model.Request;
import dev.gabrieljbo.project.core.ports.in.SaveWeatherReportPort;
import dev.gabrieljbo.project.domain.model.WeatherReport;

@RestController
public class SaveWeatherReportControllerImpl implements SaveWeatherReportController {

    @Autowired
    SaveWeatherReportPort saveWeatherReportPort;
	
	@Override
	public ResponseEntity<String> saveWeatherReport(Request<RequestPayload> request) {
		BoundedMapper boundedMapper = Mappers.getMapper(BoundedMapper.class);
		WeatherReport weatherReport = boundedMapper.requestPayloadToWeatherReport(request.getData());
		
		String response = saveWeatherReportPort.saveReport(weatherReport);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
