package com.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByTitleContainingIgnoreCase(String title);

    List<Job> findByLocationContainingIgnoreCase(String location);
}
