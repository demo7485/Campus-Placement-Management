package com.application.project.Drivejob;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriveJobService {

    private final DriveJobRepository repository;

    public DriveJobService(DriveJobRepository repository) {
        this.repository = repository;
    }

    // ================== READ ==================

    public List<DriveJob> getAllDriveJobs() {
        return repository.findAll();
    }

    public DriveJob getDriveJobById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // ================== CREATE ==================

    public DriveJob createDriveJob(DriveJob driveJob) {
        // ❌ id must NOT be set here
        return repository.save(driveJob);
    }

    // ================== DELETE ==================

    public void deleteDriveJob(Integer id) {
        repository.deleteById(id);
    }

    // ================== UPDATE ==================

    public DriveJob updateDriveJob(Integer id, DriveJob updatedJob) {

        Optional<DriveJob> existingJob = repository.findById(id);

        if (existingJob.isPresent()) {
            DriveJob job = existingJob.get();

            job.setDriveId(updatedJob.getDriveId());
            job.setJobId(updatedJob.getJobId());
            job.setPackageValue(updatedJob.getPackageValue());
            job.setTenthCutOffPercentage(updatedJob.getTenthCutOffPercentage());
            job.setTwelfthCutOffPercentage(updatedJob.getTwelfthCutOffPercentage());
            job.setBacklogsEligibility(updatedJob.getBacklogsEligibility());
            job.setCgpaCutoff(updatedJob.getCgpaCutoff());
            job.setBranch(updatedJob.getBranch());

            return repository.save(job);
        }

        // ❌ If ID not found → DO NOT create new record with manual ID
        return null;
    }
}
