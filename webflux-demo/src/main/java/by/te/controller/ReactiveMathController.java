package by.te.controller;

import by.te.dto.MultiplyRequestDto;
import by.te.dto.ResponseDTO;
import by.te.exception.InputValidationException;
import by.te.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("reactive-math")
@RequiredArgsConstructor
public class ReactiveMathController {

    private final ReactiveMathService mathService;

    @GetMapping("square/{input}")
    public Mono<ResponseDTO> findSquare(@PathVariable int input) {
        return this.mathService.findSquare(input);
    }

    @GetMapping("table/{input}")
    public Flux<ResponseDTO> multiplicationTable(@PathVariable int input) {
        return this.mathService.multiplicationTable(input);
    }

    @GetMapping(value = "table/{input}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ResponseDTO> multiplicationTableStream(@PathVariable int input) {
        return this.mathService.multiplicationTable(input);
    }

    @PostMapping("multiply")
    public Mono<ResponseDTO> multiply(@RequestBody Mono<MultiplyRequestDto> requestDtoMono,
                                      @RequestHeader Map<String, String> headers) {
        System.out.println(headers);
        return this.mathService.multiply(requestDtoMono);
    }

    @GetMapping("square/{input}/throw")
    public Mono<ResponseDTO> findSquareThrow(@PathVariable int input) {
        if (input < 10 || input > 20) {
            throw new InputValidationException(input);
        }
        return this.mathService.findSquare(input);
    }

    @GetMapping("square/{input}/mono-error")
    public Mono<ResponseDTO> monoError(@PathVariable int input) {
        return Mono.just(input)
                .handle((integer, sink) -> {
                    if (integer >= 10 && integer <= 20) {
                        sink.next(integer);
                    } else {
                        sink.error(new InputValidationException(integer));
                    }
                })
                .cast(Integer.class)
                .flatMap(this.mathService::findSquare);
    }


}
