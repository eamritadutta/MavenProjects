package com.tengen; /**
 * Created with IntelliJ IDEA.
 * User: amritadutta
 * Date: 9/23/14
 * Time: 7:47 AM
 * To change this template use File | Settings | File Templates.
 */

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB db = client.getDB("course");
        DBCollection lines = db.getCollection("DotNotationTest");
        // the following line deletes this collection
        lines.drop();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            lines.insert(new BasicDBObject("_id", i)
                    .append("start", new BasicDBObject("x", rand.nextInt(90) + 10).append("y", rand.nextInt(90) + 10))
                    .append("end", new BasicDBObject("x", rand.nextInt(90) + 10).append("y", rand.nextInt(90) + 10)));
        }
        // creating an empty query
        QueryBuilder builder = new QueryBuilder().start();
        DBCursor cursor = lines.find(builder.get());
        try {
            while (cursor.hasNext()) {
                DBObject cur = cursor.next();
                System.out.println(cur);
            }
        } finally {
            cursor.close();
        }
    }
}
