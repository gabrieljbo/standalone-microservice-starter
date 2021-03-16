package dev.gabrieljbo.project.adapters.in.web.commons.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseError implements Serializable {

	private static final long serialVersionUID = 3424614488218753134L;

	private String code;
	private String message;

}
