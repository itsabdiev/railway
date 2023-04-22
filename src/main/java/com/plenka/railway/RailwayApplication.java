package com.plenka.railway;

import com.github.javafaker.Faker;
import com.plenka.railway.configuration.EnvironmentProperties;
import com.plenka.railway.model.Action;
import com.plenka.railway.model.Status;
import com.plenka.railway.model.Type;
import com.plenka.railway.repository.ActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;


@SpringBootApplication
@EnableConfigurationProperties(EnvironmentProperties.class)
@RequiredArgsConstructor
public class RailwayApplication {
	private final Faker faker;
	private final ActionRepository actionRepository;

	public static void main(String[] args) {
		SpringApplication.run(RailwayApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			if (actionRepository.count() == 0) {
				List<Action> collect = IntStream.rangeClosed(1, 100).mapToObj(
						x -> new Action(
								faker.app().name(),
								faker.weather().description(),
								Status.randomStatus(),
								Type.randomType(),
								LocalDateTime.now(),
								null,
								faker.friends().character()

						)
				).toList();
				actionRepository.saveAll(collect);
			}
		};

	}
}
