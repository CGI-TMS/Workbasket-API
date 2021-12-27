package com.cgi.workbasket.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.workbasket.exception.WorkbasketException;
import com.cgi.workbasket.model.request.AVariableKey;
import com.cgi.workbasket.model.request.ClaimTaskRequest;
import com.cgi.workbasket.model.request.CompleteTaskRequest;
import com.cgi.workbasket.model.request.Task;
import com.cgi.workbasket.service.WorkBasketService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/work-basket")
public class WorkbasketController {
	private WorkBasketService service;

	@GetMapping(path = "/retrieve/task/{user-id}")
	public List<Task> retrieveTaskList(@PathVariable(required = true, name = "user-id") String userId) throws WorkbasketException {
		return service.retrieveTaskList(userId);
	}

	@PostMapping("/task/{task-id}/claim")
	public ResponseEntity<?> claimTask(@PathVariable(required = true, name = "task-id") String taskId, @RequestBody ClaimTaskRequest claimTaskRequest) throws WorkbasketException {
		service.claimTask(claimTaskRequest, taskId);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}

	@GetMapping(path = "/task/{task-id}/variables")
	public Map<String, AVariableKey> getTaskVariables(@PathVariable(required = true, name = "task-id") String taskId) throws WorkbasketException {
		return service.retrieveVariables(taskId);
	}

	@PostMapping(path = "/task/{task-id}/complete")
	public ResponseEntity<?> completeTask(@PathVariable(required = true, name = "task-id") String taskId, @RequestBody CompleteTaskRequest completeTaskRequest) throws WorkbasketException {
		return new ResponseEntity<Map<String, AVariableKey>> (service.completeTask(completeTaskRequest, taskId), HttpStatus.OK);
	}
}
