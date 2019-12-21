package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicSerice {

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("1", "C#", "C# Description"), new Topic("2", "C++", "C++ Description")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

	}

	public void postTopic(Topic topic) {
		topics.add(topic);

	}

	public void updateTopic(String id, Topic topic) {

		for (int i = 0; i < topics.size(); i++) {
			if (topics.get(i).getId().equals(topic.getId())) {
				//topics.get(i).setName(topic.getName());
				//topics.get(i).setDescription(topic.getDescription());
				
				topics.set(i, topic);
				return;
			}
		}

	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().contentEquals(id));		
	}

	public void deleteAllTopic() {
	topics.clear();
		
	}

}
