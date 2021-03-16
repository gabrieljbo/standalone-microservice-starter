package dev.gabrieljbo.project.adapters.in.web.getallcustomers;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponsePayload implements Serializable {

	private static final long serialVersionUID = -3953431944461418784L;

	private String id;
    private String firstName;
    private String lastName;
    private String email;

}