package by.te.service;

import by.te.dto.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathService {

    public ResponseDTO findSquare(int input){
        return new ResponseDTO(input * input);
    }

    public List<ResponseDTO> multiplicationTable(int input){
        return IntStream.rangeClosed(1, 10)
                    .peek(i -> SleepUtil.sleepSeconds(1))
                    .peek(i -> System.out.println("math-service processing : " + i))
                    .mapToObj(i -> new ResponseDTO(i * input))
                    .collect(Collectors.toList());
    }


}
