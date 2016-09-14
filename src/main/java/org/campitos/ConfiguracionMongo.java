package org.campitos;

import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

/**
 * Created by campitos on 5/26/15.
 */
@Configuration
public class ConfiguracionMongo extends AbstractMongoConfiguration {

    @Bean
    public SimpleMongoDbFactory mongoDbFactory()throws Exception{
      //  MongoURI uri=new MongoURI("mongodb://campitos-gcm:celiesita@paulo.mongohq.com:10037/campitos-base");
        MongoURI uri=new MongoURI("mongodb://campitos:campitos@ds053188.mlab.com:53188/soluciones-moviles");
        return new SimpleMongoDbFactory(uri);
    }

    @Bean
    public MongoTemplate mongoTemplate()throws Exception{
        MongoTemplate mongoTemplate=new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
    @Bean
    public GridFsTemplate gridFsTemplate()throws Exception{
        return new GridFsTemplate(mongoDbFactory(),mappingMongoConverter());
    }
    @Override
    protected String getDatabaseName() {
        return null;
    }

    @Override
    public Mongo mongo() throws Exception {
        return null;
    }
}
