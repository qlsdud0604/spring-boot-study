package com.example.springbootstudy.controller;

import com.example.springbootstudy.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    @GetMapping(value = "/name")
    public String getName() {
        return "임빈영";
    }

    @GetMapping(value = "/variable01/{variable}")
    public String getVariable01(@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "/variable02/{variable}")
    public String getVariable02(@PathVariable("variable") String var) {
        return var;
    }

    @GetMapping(value = "/request01")
    public String getRequestParam01(@RequestParam String name, @RequestParam String email) {
        return name + ", " + email;
    }

    @GetMapping(value = "/request02")
    public String getRequestParam02(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach((map) -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping(value = "/request03")
    public String getRequestParam03(MemberDTO memberDTO) {
        return memberDTO.toString();
    }

}
