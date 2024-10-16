package lk.ijse.posfusion.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerErrorResponse implements CustomerResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
