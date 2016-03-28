package io.metamorphic.cst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchAutoConfiguration;

/**
 * @author Mark Moloney <markmo @ metamorphic.io>
 * Copyright 2015
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {ElasticsearchAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
