package com.training.javaee.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aspect")
public class CdiRest3 {

    @Autowired
    private MyCaller myCaller;

    @GetMapping("/process")
    public String process(@RequestParam("name") final String name) {
        return this.myCaller.execute(name);
    }

}
