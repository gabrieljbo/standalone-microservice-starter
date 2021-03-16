package dev.gabrieljbo.project.adapters.in.web.registercustomer;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
class ResponsePayload implements Serializable {

	private static final long serialVersionUID = 1058606437445935993L;
	
	private String firstName;
    private String lastName;
    private String email;

}