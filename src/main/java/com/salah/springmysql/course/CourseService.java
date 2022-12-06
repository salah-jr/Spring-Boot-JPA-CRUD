package com.salah.springmysql.course;

import com.salah.springmysql.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses(int topicId) {
        return new ArrayList<>(courseRepository.findByTopicId(topicId));
    }

    public Course getCourse(int id){
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course course, int id){
        Course c = courseRepository.findById(id).orElse(null);
        if(c != null){
            c.setName(course.getName());
            c.setDescription(course.getDescription());
        }
        courseRepository.save(c);
    }

    public void deleteCourse(int id){
        courseRepository.deleteById(id);
    }

    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }
}
