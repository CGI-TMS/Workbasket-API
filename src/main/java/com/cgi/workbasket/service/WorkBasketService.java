package com.cgi.workbasket.service;

import java.util.List;
import java.util.Map;

import com.cgi.workbasket.exception.WorkbasketException;
import com.cgi.workbasket.model.request.AVariableKey;
import com.cgi.workbasket.model.request.ClaimTaskRequest;
import com.cgi.workbasket.model.request.CompleteTaskRequest;
import com.cgi.workbasket.model.request.Task;

public interface WorkBasketService {
	List<Task> retrieveTaskList(String userId) throws WorkbasketException;

	void claimTask(ClaimTaskRequest claimTaskRequest, String taskId) throws WorkbasketException;

	Map<String, AVariableKey> retrieveVariables(String taskId) throws WorkbasketException;
	
	Map<String, AVariableKey> completeTask(CompleteTaskRequest completeTaskRequest, String taskId);
}
