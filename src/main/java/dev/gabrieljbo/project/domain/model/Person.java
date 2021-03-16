package dev.gabrieljbo.project.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person implements Serializable {

	private static final long serialVersionUID = 5246547597900281572L;
	
	private int id;
    private String name;
    private LocalDate birthday;
    private double height;

}
