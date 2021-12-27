package com.cgi.workbasket.model.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
@JsonDeserialize
public class AVariableKey {
    public  Object value;
    public String type;
    public Object valueInfo;
}
