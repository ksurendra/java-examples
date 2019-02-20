package com.jaqstack.data;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.Arrays;

public class MongoExample {
    public static void main(String[] args) {

        //MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoClient mongoClient = MongoClients.create();

        MongoDatabase database = mongoClient.getDatabase("jaqstack");

        MongoCollection<Document> collection = database.getCollection("product");

        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));

        collection.insertOne(doc);

        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());

        mongoClient.close();
    }

    public String getProduct() {
        //MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoClient mongoClient = MongoClients.create();

        MongoDatabase database = mongoClient.getDatabase("jaqstack");

        MongoCollection<Document> collection = database.getCollection("product");

        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));

        collection.insertOne(doc);

        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());

        mongoClient.close();

        return myDoc.toJson();
    }
}
