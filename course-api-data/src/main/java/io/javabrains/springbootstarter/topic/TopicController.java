package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	//@RequestMapping(value="/topics",method=RequestMethod.GET)   <---Default Request mapping
	public List<Topic> getAllTopics() {		
		return topicService.getAllTopics();	
	}
	
	@RequestMapping("/topics/{ID}")
	public Optional<Topic> getTopic(@PathVariable("ID") String id) {
		return topicService.getTopic(id);
		
	}
	
	@RequestMapping(value="/topics",method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		topicService.postTopic(topic);
		
	}
	
	// update data
	@RequestMapping(value="/topics/{ID}",method=RequestMethod.PUT)
	public void updateTopic(@RequestBody  Topic topic ,@PathVariable("ID") String id ) {
		topicService.updateTopic(topic);
		
	}
	
	
	//  Remove element
	@RequestMapping(value="/topics/{ID}",method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable("ID") String id ) {
		topicService.deleteTopic(id);		
	}
	
	//  Remove element
	@RequestMapping(value="/topics",method=RequestMethod.DELETE)
	public void deleteAllTopic() {
		topicService.deleteAllTopic();		
	}
	

}
