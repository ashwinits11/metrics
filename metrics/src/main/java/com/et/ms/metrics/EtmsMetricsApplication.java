package com.et.ms.metrics;

import com.et.ms.metrics.model.Donetrade;
import com.et.ms.metrics.producer.KafkaMessageProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class EtmsMetricsApplication {

	private static final Logger log =
			LoggerFactory.getLogger(EtmsMetricsApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(EtmsMetricsApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(org.springframework.context.ApplicationContext appContext) {
		return args -> {
			KafkaMessageProducer producer = appContext.getBean(KafkaMessageProducer.class);
			ObjectMapper mapper = new ObjectMapper();
			int qty=2, px=160;

			for(int i=10; i<15; i++) {
				qty = qty*2;
				px  = px+2;
				Donetrade trade = new Donetrade(UUID.randomUUID().toString(), Integer.toString(i), "B", "AAPL", Integer.toString(qty), Integer.toString(px));
				log.info(mapper.writeValueAsString(trade));
				producer.sendMessage(mapper.writeValueAsString(trade));
			}
		};
	}
}
