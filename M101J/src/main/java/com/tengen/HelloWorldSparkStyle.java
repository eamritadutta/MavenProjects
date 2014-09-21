package com.tengen;


import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created with IntelliJ IDEA.
 * User: amritadutta
 * Date: 9/18/14
 * Time: 7:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        Spark.get(new Route("/") {
            @Override
            public Object handle(final Request request, final Response respose) {
                return "Hello World From Spark";
            }
        });
    }
}
