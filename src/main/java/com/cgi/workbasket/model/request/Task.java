package com.cgi.workbasket.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("assignee")
    private String assignee;
    @JsonProperty("created")
    private String created;
    @JsonProperty("due")
    private String due;
    @JsonProperty("followUp")
    private String followUp;
    @JsonProperty("delegationState")
    private String delegationState;
    @JsonProperty("description")
    private String description;
    @JsonProperty("executionId")
    private String executionId;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("parentTaskId")
    private String parentTaskId;
    @JsonProperty("priority")
    private long priority;
    @JsonProperty("processDefinitionId")
    private String processDefinitionId;
    @JsonProperty("processInstanceId")
    private String processInstanceId;
    @JsonProperty("taskDefinitionKey")
    private String taskDefinitionKey;
    @JsonProperty("caseExecutionId")
    private String caseExecutionId;
    @JsonProperty("caseInstanceId")
    private String caseInstanceId;
    @JsonProperty("caseDefinitionId")
    private String caseDefinitionId;
    @JsonProperty("suspended")
    private boolean suspended;
    @JsonProperty("formKey")
    private String formKey;
    @JsonProperty("tenantId")
    private String tenantId;
}
