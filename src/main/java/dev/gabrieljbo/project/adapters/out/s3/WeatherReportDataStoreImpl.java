package dev.gabrieljbo.project.adapters.out.s3;

import java.io.File;
import java.io.FileWriter;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.gabrieljbo.project.commons.exception.SystemErrorCode;
import dev.gabrieljbo.project.commons.exception.SystemException;
import dev.gabrieljbo.project.core.ports.out.WeatherReportDataStorePort;
import dev.gabrieljbo.project.domain.model.WeatherReport;

@Component
public class WeatherReportDataStoreImpl implements WeatherReportDataStorePort {

	@Value("${weatherreport.s3.bucket}")
	private String bucketName;

	@Override
	public String saveReport(WeatherReport weatherReport) {
		try {

			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1)
					.withCredentials(new ProfileCredentialsProvider()).build();

			ObjectMapper mapper = new ObjectMapper();
			String weatherReportJsonString = mapper.writeValueAsString(weatherReport);

			String filePrefix = LocalDateTime.now().toString("yyyyMMdd.HHmmss.SSS");
			File tempFile = File.createTempFile(filePrefix, ".json");
			FileWriter writer = new FileWriter(tempFile);
			writer.write(weatherReportJsonString);
			writer.close();
			PutObjectResult result = s3Client.putObject(bucketName, tempFile.getName(), tempFile);

			return result.getMetadata().toString();

		} catch (Exception ex) {
			throw new SystemException(ex, SystemErrorCode.SAVE_WEATHER_REPORT_ERROR_CODE);
		}

	}

}
