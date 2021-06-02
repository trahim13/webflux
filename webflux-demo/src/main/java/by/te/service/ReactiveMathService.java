package by.te.service;

import by.te.dto.MultiplyRequestDto;
import by.te.dto.ResponseDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ReactiveMathService {

    public Mono<ResponseDTO> findSquare(int input){
        return Mono.fromSupplier(() -> input * input)
                    .map(ResponseDTO::new);
    }

    public Flux<ResponseDTO> multiplicationTable(int input){
        return Flux.range(1, 10)
                    .delayElements(Duration.ofSeconds(1))
                    .doOnNext(i -> System.out.println("reactive-math-service processing : " + i))
                    .map(i -> new ResponseDTO(i * input));
    }

    public Mono<ResponseDTO> multiply(Mono<MultiplyRequestDto> dtoMono){
        return dtoMono
                    .map(dto -> dto.getFirst() * dto.getSecond())
                    .map(ResponseDTO::new);
    }

}
