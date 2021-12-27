package com.cgi.workbasket.model.request;

import java.util.Map;

import lombok.Data;

@Data
public class CompleteTaskRequest {
	private Boolean withVariablesInReturn;
	Map<String, Object> variables;
}
