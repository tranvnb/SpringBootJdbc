package com.lf.courseman.service;


import com.lf.courseman.dao.IDao;
import com.lf.courseman.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService implements IService<Course> {

    private IDao courseDao;

    @Autowired
    public CourseService(@Qualifier("postgres") IDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void add(Course obj) {
        courseDao.insert(obj);
    }

    @Override
    public void delete(UUID Id) {
        courseDao.delete(Id);
    }

    @Override
    public void update(UUID Id, Course obj) {
        courseDao.update(Id, obj);
    }

    @Override
    public List<Course> getAll() {
        return courseDao.getAll();
    }

    @Override
    public Optional<Course> getById(UUID Id) {
        return courseDao.getById(Id);
    }
}
