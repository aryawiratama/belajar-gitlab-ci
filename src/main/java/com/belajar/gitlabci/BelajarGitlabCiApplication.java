package com.belajar.gitlabci;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePrometheusEndpoint
public class BelajarGitlabCiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarGitlabCiApplication.class, args);
	}
}
