package com.springboot.mongodb.restapi.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.springboot.mongodb.restapi.repository.CardRepository;

@EnableMongoRepositories(basePackageClasses = CardRepository.class)
@Configuration
public class MongoDBConfig {

    /*@Value("${http.port}")
    private int httpPort;
    
    @Bean

    public EmbeddedServletContainerCustomizer customizeTomcatConnector() {

        return new EmbeddedServletContainerCustomizer() {

            @Override

            public void customize(ConfigurableEmbeddedServletContainer container) {

                if (container instanceof TomcatEmbeddedServletContainerFactory) {

                    TomcatEmbeddedServletContainerFactory containerFactory =

                            (TomcatEmbeddedServletContainerFactory) container;

                    Connector connector = new Connector(TomcatEmbeddedServletContainerFactory.DEFAULT_PROTOCOL);

                    connector.setPort(httpPort);

                    containerFactory.addAdditionalTomcatConnectors(connector);

                }

            }

        };

    }*/
   /* @Bean
    CommandLineRunner commandLineRunner(CardRepository cardRepository) {
        return strings -> {
        	List<Transaction> txnList = new ArrayList<Transaction>();
        	Transaction txn1 = new Transaction(new Date(), 2000.04);
        	Transaction txn2 = new Transaction(new Date(), 3000.67);
        	txnList.add(txn1);
        	txnList.add(txn2);
        	
        	cardRepository.save(new Card(1L, "VISA", new SimpleDateFormat("MM/YYYY").format(new Date()), "SHILPA", txnList));
        };
    }*/

}
