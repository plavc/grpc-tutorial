package net.plavcak.tutorial.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
          .forPort(8086)
          .addService(new TasksServiceImpl()).build();

        server.start();

        System.out.println("Server started.");

        server.awaitTermination();
    }
}