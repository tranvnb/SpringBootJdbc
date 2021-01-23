package com.lf.courseman.dao;

import com.lf.courseman.model.Course;
import com.lf.courseman.model.mapper.CourseRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class CourseDaoFromPostgres implements IDao<Course> {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseDaoFromPostgres(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Course course) {
        String sql = "INSERT INTO Course VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, UUID.randomUUID(), course.getName(), course.getStartDate(), course.getEndDate());
    }

    @Override
    public int update(UUID Id, Course course) {
        String sql = "UPDATE Course SET name = ?, start_date = ?, end_date = ? WHERE id = ?";
        return jdbcTemplate.update(sql, course.getName(), course.getStartDate(), course.getEndDate(), Id);
    }

    @Override
    public int delete(UUID Id) {
        String sql = "DELETE FROM Course WHERE id = ?";
        return jdbcTemplate.update(sql, Id);
    }

    @Override
    public Optional<Course> getById(UUID Id) {
        String sql = "SELECT id, name, start_date, end_date FROM Course WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new CourseRowMapper(), Id));

    }

    @Override
    public List<Course> getAll() {
        String sql = "SELECT id, name, start_date, end_date FROM Course";
        return jdbcTemplate.query(sql, new CourseRowMapper());
    }
}
