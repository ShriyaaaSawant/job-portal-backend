package com.jobportal.controller;

import com.jobportal.model.Job;
import com.jobportal.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.hibernate.engine.transaction.jta.platform.internal.JBossAppServerJtaPlatform;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    //create job
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.saveJob(job);
    }

    //get all jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/search/title/{title}")
    public List<Job> searchByTitle(@PathVariable String title) {
        return jobService.searchByTitle(title);
    }

    @GetMapping("/search/location/{location}")
    public List<Job> searchByLocation(@PathVariable String location) {
        return jobService.searchByLocation(location);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return "Job deleted successfully";
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job job) {
        return jobService.updateJob(id, job);
    }
}
