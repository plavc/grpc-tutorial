package net.plavcak.tutorial.grpc.server;

import io.grpc.stub.StreamObserver;
import net.plavcak.tutorial.grpc.TaskInputRequest;
import net.plavcak.tutorial.grpc.TaskInputResponse;
import net.plavcak.tutorial.grpc.TasksServiceGrpc;

public class TasksServiceImpl extends TasksServiceGrpc.TasksServiceImplBase {
 
    @Override
    public void hello(TaskInputRequest request, StreamObserver<TaskInputResponse> responseObserver) {
 
        String text = new StringBuilder()
                .append("'")
                .append(request.getAuthor())
                .append("' ")
                .append(" added a note with content: '")
                .append(request.getText())
                .append("'")
                .toString();

        System.out.println(text);

        TaskInputResponse response = TaskInputResponse.newBuilder()
          .setStatus(true)
          .build();
 
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}