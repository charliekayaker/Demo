package com.demo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.demo.grpc.HelloRequest;
import com.demo.grpc.HelloReply;
import com.demo.grpc.GreeterGrpc;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GreeterClient {

    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterBlockingStub blockingStub;

    public GreeterClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void greet(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response = blockingStub.sayHello(request);
        log.info("Response from server: " + response.getMessage() + " " + response.getName());
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws Exception {
        GreeterClient client = new GreeterClient("localhost", 50051);
        try {
            String user = "chanchito feliz";
            client.greet(user);
        } finally {
            client.shutdown();
        }
    }
}

