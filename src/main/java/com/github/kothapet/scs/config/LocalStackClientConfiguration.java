package com.github.kothapet.scs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.kinesis.producer.KinesisProducerConfiguration;

import lombok.RequiredArgsConstructor;

@Profile("local")
@Configuration
@RequiredArgsConstructor
public class LocalStackClientConfiguration {
    /*
    @Bean
    public KinesisProducer kinesisProducer() {
        KinesisProducerConfiguration configuration = new KinesisProducerConfiguration()
            .setKinesisEndpoint("localhost")
            .setKinesisPort(4567)
            .setCloudwatchEndpoint("localhost")
            .setCloudwatchPort(4567)
            .setVerifyCertificate(false)
            .setRegion("us-east-1");

        return new KinesisProducer(configuration);
    }
    */
	@Bean
	public KinesisProducerConfiguration kinesisProducerConfiguration()  {
			return new KinesisProducerConfiguration()
					.setCredentialsProvider(new DefaultAWSCredentialsProviderChain())
					.setRegion("us-east-1")
					.setKinesisEndpoint("localhost")
					.setKinesisPort(4567)
					.setCloudwatchEndpoint("localhost")
					.setCloudwatchPort(4567)
					.setVerifyCertificate(false);
	}	
	
}