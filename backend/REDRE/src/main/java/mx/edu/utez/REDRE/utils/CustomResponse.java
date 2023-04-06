package mx.edu.utez.REDRE.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomResponse<T> {
    T obj;
    Boolean errorStatus;
    int statusCode;
    String message;
}
