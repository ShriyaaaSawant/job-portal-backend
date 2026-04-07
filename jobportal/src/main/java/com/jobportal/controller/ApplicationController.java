package com.jobportal.controller;

import com.jobportal.model.Application;
import com.jobportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    //apply to job
    @PostMapping
    public Application apply(@RequestBody Application applications) {
        return applicationService.apply(applications);
    }
    // Get applications by user

    @GetMapping("/user/{userId}")
    public List<Application> getByUser(@PathVariable Long userId) {
        return applicationService.getByUserId(userId);

    }

    // Get applications by job
    @GetMapping("/job/{jobId}")
    public List<Application> getByJob(@PathVariable Long jobId) {
        return applicationService.getByJobId(jobId);
    }

    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return "Application deleted successfully";
    }
}
