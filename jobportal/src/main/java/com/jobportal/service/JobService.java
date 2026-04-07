package com.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.jobportal.model.Job;
import com.jobportal.repository.JobRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    //create Job
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    //Get all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> searchByTitle(String title) {
        return jobRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Job> searchByLocation(String location) {
        return jobRepository.findByLocationContainingIgnoreCase(location);
    }

    public Job updateJob(Long id, Job updatedJob) {
        Job job = jobRepository.findById(id).orElse(null);

        if (job != null) {
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setSalary(updatedJob.getSalary());
            job.setLocation(updatedJob.getLocation());
            return jobRepository.save(job);
        }
        return null;
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
