package dz.elit.handler;

import dz.elit.exception.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ErrorDto {
    //private ErrorCodes
    private ErrorCodes  code;

    private Integer codehttp;

    private String  message;

    private List<String> errors=new ArrayList<>();




}
