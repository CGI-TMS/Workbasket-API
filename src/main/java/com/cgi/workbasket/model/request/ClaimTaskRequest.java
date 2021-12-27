package com.cgi.workbasket.model.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@JsonDeserialize
@Data
public class ClaimTaskRequest {
    public String userId;

}

