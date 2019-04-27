package net.plavcak.tutorial.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.plavcak.tutorial.grpc.TaskInputRequest;
import net.plavcak.tutorial.grpc.TaskInputResponse;
import net.plavcak.tutorial.grpc.TasksServiceGrpc;

public class GRPCClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8086)
          .usePlaintext()
          .build();
 
        TasksServiceGrpc.TasksServiceBlockingStub stub = TasksServiceGrpc.newBlockingStub(channel);
 
        TaskInputResponse helloResponse = stub.hello(TaskInputRequest.newBuilder()
          .setAuthor("plavc")
          .setText("Some notes added at " + System.currentTimeMillis())
          .build());

        System.out.println("Status: " + helloResponse.getStatus());
 
        channel.shutdown();
    }

}