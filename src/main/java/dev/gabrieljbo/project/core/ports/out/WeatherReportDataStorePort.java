package dev.gabrieljbo.project.core.ports.out;

import dev.gabrieljbo.project.domain.model.WeatherReport;

public interface WeatherReportDataStorePort {

    String saveReport(WeatherReport weatherReport);

}
