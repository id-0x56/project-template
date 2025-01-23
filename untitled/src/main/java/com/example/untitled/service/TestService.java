package com.example.untitled.service;

import com.example.grpc.TestRequest;
import com.example.grpc.TestResponse;
import com.example.grpc.TestServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @GrpcClient("test-client")
    private TestServiceGrpc.TestServiceBlockingStub testServiceBlockingStub;

    public String get(String firstName, String lastName) {
        TestResponse response = testServiceBlockingStub.say(TestRequest.newBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .build());

        return response.toString();
    }
}
