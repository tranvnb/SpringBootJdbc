package com.lf.courseman.model.mapper;

import com.lf.courseman.model.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CourseRowMapper implements RowMapper<Course> {

    @Override
    public Course mapRow(ResultSet resultSet, int i) throws SQLException {
        Course course = new Course();
        course.setId(UUID.fromString(resultSet.getString("id")));
        course.setName(resultSet.getString("name"));
        course.setStartDate(resultSet.getDate("start_date").toLocalDate());
        course.setEndDate(resultSet.getDate("end_date").toLocalDate());
        return course;
    }
}
