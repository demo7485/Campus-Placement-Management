package com.application.project.college;

import java.util.List;

public interface CollegeService {
    College createCollege(College college);
    College getCollegeById(Integer id);
    List<College> getAllColleges();
    College updateCollege(Integer id, College college);
    void deleteCollege(Integer id);
}
