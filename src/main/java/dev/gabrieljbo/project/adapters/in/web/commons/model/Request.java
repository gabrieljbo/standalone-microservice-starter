package dev.gabrieljbo.project.adapters.in.web.commons.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Request<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = -8476840317010670850L;
	
	private T data;

}