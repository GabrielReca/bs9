package com.example.DB1JPA.application.port;

import com.example.DB1JPA.infrastructure.dto.output.ProfesorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simpleFeign", url = "http://localhost:8081/")
public interface IFeignServer {

    @GetMapping("/persona/profesor/id/{id}")
    ResponseEntity<ProfesorOutputDTO> callServer(@PathVariable("id") int id);
}
