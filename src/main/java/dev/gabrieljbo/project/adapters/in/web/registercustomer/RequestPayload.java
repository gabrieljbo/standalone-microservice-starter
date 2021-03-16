package dev.gabrieljbo.project.adapters.in.web.registercustomer;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
class RequestPayload implements Serializable {

	private static final long serialVersionUID = -2374658293404056452L;

	private String firstName;
    private String lastName;
    private String email;

}