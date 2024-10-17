package lk.ijse.posfusion.customObj.impl;

import lk.ijse.posfusion.customObj.ItemResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemErrorResponse implements ItemResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
