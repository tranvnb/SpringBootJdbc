package com.lf.courseman.api;

import com.lf.courseman.model.Course;
import com.lf.courseman.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/courses")
@RestController
public class CourseController implements IBaseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping()
    public void addCourse(@Valid @RequestBody Course course) {
        //TODO: insert new course to database using service
        courseService.add(course);
    }

    @PutMapping(path = "{id}")
    public void updateCourse(@PathVariable("id") UUID Id, @Valid @RequestBody Course course) {
        courseService.update(Id, course);
    }

    @GetMapping(path = "{id}")
    public Course getCourseById(@PathVariable("id") UUID Id) {
        return courseService.getById(Id).get();
    }

    @GetMapping
    public List<Course> getAllCourse() {
        List<Course> result = courseService.getAll();
        return courseService.getAll();
    }

    @DeleteMapping(path = "{id}")
    public void deleteCourse(@PathVariable("id") UUID Id) {
        courseService.delete(Id);
    }

}
