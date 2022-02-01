package com.example.springbootstudy.controller;

import com.example.springbootstudy.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping(value = "/default")
    public String putMethod() {
        return "Hello World";
    }

    @PutMapping(value = "/member")
    public String putMember(@RequestBody Map<String, String> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PutMapping(value = "/member01")
    public String putMemberDto01(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }

    @PutMapping(value = "/member02")
    public MemberDTO putMemberDto02(@RequestBody MemberDTO memberDTO) {
        return memberDTO;
    }

    @PutMapping(value = "/member03")
    public ResponseEntity<MemberDTO> putMemberDto03(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }
}
