package dev.gabrieljbo.project.adapters.in.web.commons.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response<T> implements Serializable {

	private static final long serialVersionUID = -103949524164831041L;

	private Status status = Status.SUCCESS;
	private transient T data;
    private List<ResponseError> errors = new ArrayList<>(0);

}