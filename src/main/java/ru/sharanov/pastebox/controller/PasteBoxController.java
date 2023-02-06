package ru.sharanov.pastebox.controller;

import org.springframework.web.bind.annotation.*;
import ru.sharanov.pastebox.api.request.PasteBoxRequest;

import java.util.Collections;
import java.util.List;

@RestController
public class PasteBoxController {
    @GetMapping("/{hash}")
    public String getByHash(@PathVariable String hash){
        return hash;
    }

    @GetMapping("/")
    public List<String> getPublicPasteList(){
        return Collections.emptyList();
    }

    @PostMapping("/")
    public String add(@RequestBody PasteBoxRequest request){
        return request.getData();
    }
}