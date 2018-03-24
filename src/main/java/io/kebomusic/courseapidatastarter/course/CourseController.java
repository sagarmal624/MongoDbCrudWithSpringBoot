package io.kebomusic.courseapidatastarter.course;

import io.kebomusic.courseapidatastarter.topic.Topic;
import io.kebomusic.courseapidatastarter.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/getaddcourse")
	public String getAddCourseView(Model model)
	{
		Map<String, String> topicMap = new HashMap<String, String>();
		
		//Create a map of topicIDs and topic names
		for(Topic topic : topicService.getAllTopics())
		{
			topicMap.put(topic.getId(), topic.getName());
		}
		model.addAttribute("course", new Course());
		model.addAttribute("topicMap", topicMap);
		
		return "AddCourse";
	}
	
	@GetMapping("/listcourses")
	public String getAllCourses(Model model)
	{
		model.addAttribute("courses", courseService.getAllCourses());
		return "ListCourses";
	}

	@GetMapping("/courses/{courseID}")
	public Course getCourse(@PathVariable String courseID)
	{
		return courseService.getCourse(courseID);
	
	}
	
	@PostMapping("/addcourse")
	public String addUpdateCourse(@ModelAttribute Course course, Model model)
	{
		if(StringUtils.isEmpty(course.getId()))
		{
			course.setId(null);
		}
		
		courseService.addCourse(course);
		String message =  "**The course " + course.getName() + " has been added!**";
		model.addAttribute("message", message);
		model.addAttribute("course", course);
		
		return "AddCourse";
	}
	
	@GetMapping("/editcourse/{courseID}")
	public String getCourse(@PathVariable String courseID, Model model)
	{
		model.addAttribute("course", courseService.getCourse(courseID));
		return "AddCourse";
	
	}
	
	@DeleteMapping("/deletecourse/{courseID}")
	public String deleteCourse(@PathVariable  String courseID, Model model)
	{
		String message =  "**The topic has been deleted!**";
		model.addAttribute("courses",courseService.getAllCourses());
		model.addAttribute("message",message);
		
		return "ListCourses";
	}
	
}
