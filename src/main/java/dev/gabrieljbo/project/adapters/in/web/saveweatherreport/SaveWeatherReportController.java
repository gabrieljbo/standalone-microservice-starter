package dev.gabrieljbo.project.adapters.in.web.saveweatherreport;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.gabrieljbo.project.adapters.in.web.commons.model.Request;

public interface SaveWeatherReportController {

    @PostMapping(path = "/api/weather")
	public ResponseEntity<String> saveWeatherReport(@RequestBody Request<RequestPayload> request);

}
