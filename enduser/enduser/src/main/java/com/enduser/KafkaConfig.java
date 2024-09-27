package com.enduser;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.sql.SQLOutput;

@Configuration
public class KafkaConfig {

    private Logger logger = LoggerFactory.getLogger(KafkaConfig.class);
    @KafkaListener(topics = ApplicationConstants.LOCATION_UPDATE_TOPIC, groupId = ApplicationConstants.GROUP_ID)
    public void updatedLocation(String value){

        System.out.println(value);
        this.logger.info("Message produced"+ value);

    }
}
