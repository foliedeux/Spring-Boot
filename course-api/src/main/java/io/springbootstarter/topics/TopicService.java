package io.springbootstarter.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topics> topics = new ArrayList<>(Arrays.asList(
								new Topics("123", "ABC", "ABC Description"),
								new Topics("456", "DEF", "DEF Description"),
								new Topics("789", "GHI", "GHI Description")
								));

	public List<Topics> getAllTopics() {
		return topics;
	}
	
	public Topics getTopic(String id) {
		return topics.stream().filter(n -> n.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topics topic) {
		topics.add(topic);
	}

	public void updateTopic(Topics topic, String id) {
		for(int i = 0; i < topics.size(); i++) {
			if(topics.get(i).getId().equalsIgnoreCase(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(n -> n.getId().equalsIgnoreCase(id));
	}
	
}
