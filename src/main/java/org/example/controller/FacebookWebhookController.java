package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.example.entity.RequestData;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import static java.sql.DriverManager.println;

@Slf4j
@RestController
@RequestMapping("/facebook-webhook")
public class FacebookWebhookController {

    @GetMapping("/calculate")
    public int calculate(@RequestBody RequestData data){
        log.info("Message is {}", data.getOperation());
        if(data.getOperation().equals("multiply"))
         return data.getNum1() * data.getNum2();
        else
            return data.getNum1() - data.getNum2();
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int num1, @RequestParam int num2){
        return num1 - num2;
    }

    @GetMapping("/subtract/dummy")
    public int subtract(@RequestBody int num1){
        return num1;
    }
}
