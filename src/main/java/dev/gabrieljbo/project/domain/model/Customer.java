package dev.gabrieljbo.project.domain.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer implements Serializable {

	private static final long serialVersionUID = -6384592378060125134L;

	private int id;
	
    @NotNull
    @Size(min = 3, max = 40)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 40)
    private String lastName;

    @NotNull
    @Email
    private String email;
    
}
