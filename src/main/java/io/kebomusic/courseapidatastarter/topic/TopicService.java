package io.kebomusic.courseapidatastarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	
	public List<Topic> getAllTopics()
	{
		List<Topic> allTopics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(allTopics::add);
		return allTopics;
	}
	
	public Topic getTopic(String id)
	{	
		return topicRepository.findById(id).get();
	}
	
	public void addUpdateTopic(Topic topic) {
		
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
	
}
