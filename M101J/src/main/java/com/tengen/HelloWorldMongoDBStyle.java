package com.tengen;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: amritadutta
 * Date: 9/18/14
 * Time: 7:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldMongoDBStyle {
    public static void main(String[] args) throws UnknownHostException {
        // logical connection to database server
        MongoClient client = new MongoClient();  // by default connects to localhost:27017

        // get an instance of the 'course' database using the client
        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("hello");

        DBObject document = collection.findOne();
        System.out.println(document);
    }
}
