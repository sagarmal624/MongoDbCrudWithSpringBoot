package io.kebomusic.courseapidatastarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/addtopic")
	public String getAddTopicView(Model model)
	{
		model.addAttribute("topic", new Topic());
		return "AddTopic";
	}
	
	@GetMapping("/listtopics")
	public String getAllTopics(Model model)
	{
		model.addAttribute("topics", topicService.getAllTopics());
		return "ListTopics";
	}

	@GetMapping("/edittopic/{id}")
	public String getTopic(@PathVariable String id, Model model)
	{
		model.addAttribute("topic", topicService.getTopic(id));
		return "AddTopic";
	
	}
	
	@PostMapping("/topics")
	public String addUpdateTopic(@ModelAttribute Topic topic, Model model)
	{
		if(StringUtils.isEmpty(topic.getId()))
		{
			topic.setId(null);
		}
		
		topicService.addUpdateTopic(topic);
		String message =  "**The topic " + topic.getName()+ "  has been added!**";
		model.addAttribute("message", message);
		return "AddTopic";
	}
	
	@GetMapping("/deletetopic/{id}")
	public String deleteTopic(@PathVariable String id, Model model)
	{
		topicService.deleteTopic(id);
		String message =  "**The topic has been deleted!**";
		model.addAttribute("topics", topicService.getAllTopics());
		model.addAttribute("message",message);
		return "ListTopics";
	}
	
}
