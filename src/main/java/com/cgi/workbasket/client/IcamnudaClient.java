package com.cgi.workbasket.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cgi.workbasket.model.request.AVariableKey;
import com.cgi.workbasket.model.request.ClaimTaskRequest;
import com.cgi.workbasket.model.request.CompleteTaskRequest;
import com.cgi.workbasket.model.request.Task;

@FeignClient(name = "camundaClient",url = "${cgi.work-basket.host}")
public interface IcamnudaClient {
	@GetMapping (path = "/task")
    List<Task>  retrieveTaskList(@RequestParam(value = "candidateUser") String userId, @RequestParam(value = "includeAssignedTasks") Boolean value);
    
	@PostMapping(value = "/task/{task-id}/claim")
    String claimTask(@RequestBody ClaimTaskRequest request, @PathVariable(value = "task-id") String taskId);
    
	@GetMapping (path = "/task/{task-id}/variables")
    Map<String, AVariableKey> retrieveVariables(@PathVariable(value = "task-id") String taskId);
    
	@PostMapping (path = "/task/{task-id}/complete")
	Map<String, AVariableKey> completeTask(@PathVariable(value = "task-id") String taskId, @RequestBody CompleteTaskRequest request); 
}
