package dev.gabrieljbo.project.domain.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class WeatherReport implements Serializable {

	private static final long serialVersionUID = -7697386065511609363L;

    @NotNull
    @Size(min = 3, max = 40)
	private String temperature;

    @NotNull
    @Size(min = 3, max = 40)
    private String precipitationsProbability;
    
    @NotNull
    @Size(min = 3, max = 40)
    private String windVelocity;

}
