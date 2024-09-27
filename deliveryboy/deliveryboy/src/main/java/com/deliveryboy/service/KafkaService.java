package com.deliveryboy.service;


import com.deliveryboy.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaService {

    //for sending message via kakfa use kafka template
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;
    //SLF4J logger
    private Logger logger = LoggerFactory.getLogger(KafkaService.class);
    public boolean updateLocation( String location ){
        // 2 para-> topic name, msg
        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
        this.logger.info("Message produced");
        return true;
    }
}
