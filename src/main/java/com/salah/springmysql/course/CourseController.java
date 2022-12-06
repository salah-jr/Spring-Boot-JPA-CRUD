package com.salah.springmysql.course;

import com.salah.springmysql.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getTopicCourses(@PathVariable int id) {
        return courseService.getCourses(id);
    }

    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable int id){
        return courseService.getCourse(id);
    }

    @PostMapping("/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable int topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @PutMapping("/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable int topicId,@PathVariable int id){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course, id);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
    }

    @DeleteMapping("/courses/delete-all")
    public void deleteAllCourses(){
        courseService.deleteAllCourses();
    }
} 