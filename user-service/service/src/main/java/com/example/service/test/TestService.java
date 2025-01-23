package com.example.service.test;

import com.example.grpc.TestRequest;
import com.example.grpc.TestResponse;
import com.example.grpc.TestServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class TestService extends TestServiceGrpc.TestServiceImplBase {
    @Override
    public void say(TestRequest request, StreamObserver<TestResponse> responseObserver) {
        TestResponse response = TestResponse.newBuilder()
                .setMessage("This is TEST! " + request.getFirstName() + " " + request.getLastName())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
