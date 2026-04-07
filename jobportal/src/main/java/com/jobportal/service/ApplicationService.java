package com.jobportal.service;

import com.jobportal.model.Application;
import com.jobportal.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    //Apply to job
    public Application apply(Application applications) {
        return applicationRepository.save(applications);
    }

    //Get application by users
    public List<Application> getByUserId(Long userId) {
        return applicationRepository.findByJobId(userId);
    }

    //Get applications by job
    public List<Application> getByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }

    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}
