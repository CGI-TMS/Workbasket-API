package com.cgi.workbasket.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.workbasket.client.IcamnudaClient;
import com.cgi.workbasket.exception.WorkbasketException;
import com.cgi.workbasket.model.request.AVariableKey;
import com.cgi.workbasket.model.request.ClaimTaskRequest;
import com.cgi.workbasket.model.request.CompleteTaskRequest;
import com.cgi.workbasket.model.request.Task;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
@Slf4j
public class WorkBasketServiceImpl implements WorkBasketService {

	private IcamnudaClient client;

	@Override
	public void claimTask(ClaimTaskRequest request, String taskId) throws WorkbasketException {
		try {
			client.claimTask(request, taskId);
		} catch (Exception e) {
			log.error("Exception Occured while Assigning task  to User: " + taskId, e);
			throw new WorkbasketException(e.getMessage());
		}
	}

	@Override
	public List<Task> retrieveTaskList(String userId) throws WorkbasketException {

		try {
			return client.retrieveTaskList(userId, true);
		} catch (Exception e) {
			log.error("Exception Occured while Updating User Credential", e);
			throw new WorkbasketException(e.getMessage());
		}
	}

	@Override
	public Map<String, AVariableKey> retrieveVariables(String taskId) throws WorkbasketException {
		try {
			return client.retrieveVariables(taskId);
		} catch (Exception e) {
			log.error("Exception Occured while retrieving variables", e);
			throw new WorkbasketException(e.getMessage());
		}
	}

	@Override
	public Map<String, AVariableKey> completeTask(CompleteTaskRequest completeTaskRequest, String taskId) {
		return client.completeTask(taskId, completeTaskRequest);
	}
}
