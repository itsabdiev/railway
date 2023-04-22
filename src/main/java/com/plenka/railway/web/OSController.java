package com.plenka.railway.web;

import com.plenka.railway.configuration.EnvironmentProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class OSController {
    private final EnvironmentProperties environmentProperties;

    @GetMapping
    public EnvironmentProperties test() {
        return environmentProperties;
    }
}
