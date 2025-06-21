package com.event_handler.event_handler_ms;

import com.event_handler.event_handler_ms.publisher.WikiEventsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
public class EventHandlerMsApplication implements CommandLineRunner {

	@Autowired
	private WikiEventsProducer wikiEventsProducer;

	public static void main(String[] args) {
		SpringApplication.run(EventHandlerMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//wikiEventsProducer.sendWikiData();
	}
}
