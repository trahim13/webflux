package by.te.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class ResponseDTO {

    private Date date = new Date();
    private int output;

    public ResponseDTO(int output) {
        this.output = output;
    }
}
