package com.jaqstack.service;

import com.jaqstack.helpers.AuthenticationException;
import com.jaqstack.models.UserCredentials;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import com.mongodb.MongoClientSettings;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.jaqstack.models.User;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

/**
 * Service which provides crud operations for database.
 *
 * @author Suren Konathala
 */
@ApplicationScoped
public class DataService implements Serializable {

    public String addUser(User user) {
        //MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoClient mongoClient = MongoClients.create();

        MongoDatabase database = mongoClient.getDatabase("jaqstack");

        MongoCollection<Document> collection = database.getCollection("users");

        Document doc = new Document("username", user.getUsername())
                .append("password", user.getPassword())
                .append("firstname", user.getFirstName())
                .append("lastname", user.getLastName());

        collection.insertOne(doc);

        //Document myDoc = collection.find().first();
        mongoClient.close();

        return "User " + user.getUsername() + " added successfully.";
    }

    public void findUser(User user) {
        //TODO
    }

    public User findUsernamePassword(UserCredentials userCredentials) {

        List<User> usersList = new ArrayList<>();

        //MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoClient mongoClient = MongoClients.create();

        // create codec registry for POJOs
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoDatabase database = mongoClient.getDatabase("jaqstack").withCodecRegistry(pojoCodecRegistry);

        MongoCollection<Document> collection = database.getCollection("users");

        BasicDBObject andQuery = new BasicDBObject();
        List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        obj.add(new BasicDBObject("username", userCredentials.getUsername()));
        obj.add(new BasicDBObject("password", userCredentials.getPassword()));
        andQuery.put("$and", obj);

        //System.out.println("**Query="+ andQuery.toString());

        /** alternate process
        Document result = collection.find(andQuery).first();
        System.out.println("\n**** result= "+result + " and "+ result.size());

        if (result!=null && result.size()==5) {
            System.out.println("\n**result.getString="+ result.getString("username"));

            User usernamePasswordMatch = new User(result.getString("username"), "", "", "");
            System.out.println("\n****usernamePasswordMatch...");
            System.out.println(usernamePasswordMatch);
        } else {
            System.out.println("\n****ELSE");
        }*/

        usersList = collection.find(andQuery, User.class).into(new ArrayList<>());

        if (usersList == null) {
            throw new AuthenticationException("Invalid username. Please try again.");
        }

        if (usersList.size()<1) {
            throw new AuthenticationException("Username/Password does not match. Please try again.");
        }

        if (usersList.size()>1) {
            throw new AuthenticationException("Multiple Users Found. Please contact system adminstrator.");
        }

        //System.out.println("\n****Users..." + users.size() + "and " + users.get(0));
        return usersList.get(0);
    }


}
