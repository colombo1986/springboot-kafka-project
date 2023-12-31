package net.cvergara.springboot;

import net.cvergara.springboot.entity.WikiMediaData;
import net.cvergara.springboot.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private WikimediaDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}" , groupId = "${spring.kafka.consumer.group-id}")

    public void consume(String eventMessage){

      LOGGER.info(String.format("Event message recieved -> %s" , eventMessage));
        WikiMediaData wikiMediaData = new WikiMediaData();
        wikiMediaData.setWikiEventData(eventMessage);
        dataRepository.save(wikiMediaData);
    }

}
