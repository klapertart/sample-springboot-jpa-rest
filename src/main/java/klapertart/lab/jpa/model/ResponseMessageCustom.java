package klapertart.lab.jpa.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ResponseMessageCustom<T> {
    private int status;
    private String message;
    private List<T> data;
}
