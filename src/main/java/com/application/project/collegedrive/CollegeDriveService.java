package com.application.project.collegedrive;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeDriveService {

    private final CollegeDriveRepository repository;

    public CollegeDriveService(CollegeDriveRepository repository) {
        this.repository = repository;
    }

    public List<CollegeDrive> getAllDrives() {
        return repository.findAll();
    }

    public CollegeDrive getDriveById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public CollegeDrive createDrive(CollegeDrive drive) {
        return repository.save(drive);
    }

    public CollegeDrive updateDrive(Integer id, CollegeDrive updatedDrive) {
        return repository.findById(id)
                .map(drive -> {
                    drive.setDriveId(updatedDrive.getDriveId());
                    drive.setCollegeId(updatedDrive.getCollegeId());
                    return repository.save(drive);
                })
                .orElse(null);
    }

    public boolean deleteDrive(Integer id) {
        return repository.findById(id)
                .map(drive -> {
                    repository.delete(drive);
                    return true;
                })
                .orElse(false);
    }
}
