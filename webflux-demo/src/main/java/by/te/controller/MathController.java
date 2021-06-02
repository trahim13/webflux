package by.te.controller;

import by.te.dto.ResponseDTO;
import by.te.service.MathService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("math")
@RequiredArgsConstructor
public class MathController {

    private final MathService mathService;

    @GetMapping("square/{input}")
    public ResponseDTO findSquare(@PathVariable int input){
        if (input < 10) {
            throw new IllegalArgumentException();
        }
        return this.mathService.findSquare(input);
    }

    @GetMapping("table/{input}")
    public List<ResponseDTO> multiplicationTable(@PathVariable int input){
        return this.mathService.multiplicationTable(input);
    }

}
