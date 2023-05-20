package com.russellsite.russellsite.others.nusmods.prerequisites.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.russellsite.russellsite.util.HttpUtils.getBodyString;

@RestController
@RequestMapping("/nusmods/prereq")
public class PrerequisiteTree {

    private final String ACADEMIC_YEAR = "2022-2023";

    @GetMapping("/{moduleCode}")
    public String getModuleInformation(@PathVariable String moduleCode) {
        try {
            String u = String.format("https://api.nusmods.com/v2/%s/modules/%s.json", ACADEMIC_YEAR, moduleCode);
            URL url = new URL(u);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            return getBodyString(connection);
        } catch (IOException ioe) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Module does not exist on NUSMODS");
        }
    }
}
