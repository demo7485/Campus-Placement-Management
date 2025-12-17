package com.application.project.collegedrive;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collegedrive")
public class CollegeDriveController {

    private final CollegeDriveService service;

    public CollegeDriveController(CollegeDriveService service) {
        this.service = service;
    }

    // GET ALL
    @GetMapping
    public List<CollegeDrive> getAll() {
        return service.getAllDrives();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public CollegeDrive getById(@PathVariable Integer id) {
        return service.getDriveById(id);
    }

    // CREATE
    @PostMapping
    public CollegeDrive create(@RequestBody CollegeDrive drive) {
        return service.createDrive(drive);
    }

    // UPDATE
    @PutMapping("/{id}")
    public CollegeDrive update(@PathVariable Integer id, @RequestBody CollegeDrive drive) {
        return service.updateDrive(id, drive);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        boolean deleted = service.deleteDrive(id);
        return deleted ? "CollegeDrive deleted successfully!" : "CollegeDrive not found!";
    }
}
