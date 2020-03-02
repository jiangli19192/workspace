import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public final class JavaMongoDBAuthExample { 
private static Logger logger = LoggerFactory.getLogger(JavaMongoDBAuthExample.class);  
      
    private static MongoClient mongoClient = null;  
      
    private static ObjectMapper jsonMapper = new ObjectMapper();  
      
    static{  
        jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  
    }  
      
    private JavaMongoDBAuthExample(){  
          
    }  
      
    //初始化客户端  
    private static MongoClient getClient(){  
        try {  
            if(null != mongoClient){  
                return mongoClient;  
            }  
            //获取配置参数  
//              String domains = SystemProperty.getProperyValue("mongo.domains");  
//              String user = SystemProperty.getProperyValue("mongo.user");  
//              String password = SystemProperty.getProperyValue("mongo.password");  
//              String database = SystemProperty.getProperyValue("mongo.database");  
              
            String domains = "dev.mongodb1.cnhz.shishike.com:3717;dev.mongodb2.cnhz.shishike.com:3717";  
            String user = "weixl";  
            String password = "123";  
            String database = "test";  
              
            //组装mongo服务端地址  
            final List<ServerAddress> addressLists =new ArrayList<>();  
            for(String domain : domains.split(";")){  
                String[] hostAndPort = domain.split(":");  
                String host = hostAndPort[0];  
                String port = hostAndPort[1];  
                ServerAddress serverAddress = new ServerAddress(host, Integer.parseInt(port));  
                addressLists.add(serverAddress);  
            }  
              
            //组装mongo各项参数  默认值  
            //maxConnectionsPerHost = 100;  
            //threadsAllowedToBlockForConnectionMultiplier = 5;  
            //serverSelectionTimeout = 1000 * 30;  
            //maxWaitTime = 1000 * 60 * 2;  
            //maxConnectionIdleTime;  
            //maxConnectionLifeTime;  
            //connectTimeout = 1000 * 10;  
            //socketTimeout = 0;  
            //socketKeepAlive = false;  
            //sslEnabled = false;  
            //sslInvalidHostNameAllowed = false;  
            //alwaysUseMBeans = false;  
            //  
            //heartbeatFrequency = 10000;  
            //minHeartbeatFrequency = 500;  
            //heartbeatConnectTimeout = 20000;  
            //heartbeatSocketTimeout = 20000;  
            //localThreshold = 15;  
            final MongoClientOptions options = MongoClientOptions.builder().build();  
              
            //组装权限对象  
            final List<MongoCredential> credentialsLists = new ArrayList<>();  
            MongoCredential credential = MongoCredential.createCredential(user, database, password.toCharArray());  
            credentialsLists.add(credential);  
              
            //创建客户端  
            mongoClient = new MongoClient(addressLists, credentialsLists, options);  
        } catch (Exception e) {  
            logger.error("MongoDB init error",e);  
        }  
        return mongoClient;  
    }  
      
    private static MongoDatabase getDB(){  
        //String database = SystemProperty.getProperyValue("mongo.database");  
        String database = "calm_erp_dev";  
        return getClient().getDatabase(database);  
    }  
      
    private static MongoCollection<Document> getCollection(String collName){  
        return getDB().getCollection(collName);  
    }  
}