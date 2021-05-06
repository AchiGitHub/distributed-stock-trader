package ds.assignment.trading.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: TradingService.proto")
public final class CreateOrderServiceGrpc {

  private CreateOrderServiceGrpc() {}

  public static final String SERVICE_NAME = "ds.assignment.trading.grpc.generated.CreateOrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.assignment.trading.grpc.generated.CreateOrderRequest,
      ds.assignment.trading.grpc.generated.CreateOrderResponse> getCreateOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createOrder",
      requestType = ds.assignment.trading.grpc.generated.CreateOrderRequest.class,
      responseType = ds.assignment.trading.grpc.generated.CreateOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.assignment.trading.grpc.generated.CreateOrderRequest,
      ds.assignment.trading.grpc.generated.CreateOrderResponse> getCreateOrderMethod() {
    io.grpc.MethodDescriptor<ds.assignment.trading.grpc.generated.CreateOrderRequest, ds.assignment.trading.grpc.generated.CreateOrderResponse> getCreateOrderMethod;
    if ((getCreateOrderMethod = CreateOrderServiceGrpc.getCreateOrderMethod) == null) {
      synchronized (CreateOrderServiceGrpc.class) {
        if ((getCreateOrderMethod = CreateOrderServiceGrpc.getCreateOrderMethod) == null) {
          CreateOrderServiceGrpc.getCreateOrderMethod = getCreateOrderMethod =
              io.grpc.MethodDescriptor.<ds.assignment.trading.grpc.generated.CreateOrderRequest, ds.assignment.trading.grpc.generated.CreateOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.assignment.trading.grpc.generated.CreateOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.assignment.trading.grpc.generated.CreateOrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreateOrderServiceMethodDescriptorSupplier("createOrder"))
              .build();
        }
      }
    }
    return getCreateOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CreateOrderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateOrderServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateOrderServiceStub>() {
        @java.lang.Override
        public CreateOrderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateOrderServiceStub(channel, callOptions);
        }
      };
    return CreateOrderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CreateOrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateOrderServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateOrderServiceBlockingStub>() {
        @java.lang.Override
        public CreateOrderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateOrderServiceBlockingStub(channel, callOptions);
        }
      };
    return CreateOrderServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CreateOrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateOrderServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateOrderServiceFutureStub>() {
        @java.lang.Override
        public CreateOrderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateOrderServiceFutureStub(channel, callOptions);
        }
      };
    return CreateOrderServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CreateOrderServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createOrder(ds.assignment.trading.grpc.generated.CreateOrderRequest request,
        io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.CreateOrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ds.assignment.trading.grpc.generated.CreateOrderRequest,
                ds.assignment.trading.grpc.generated.CreateOrderResponse>(
                  this, METHODID_CREATE_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class CreateOrderServiceStub extends io.grpc.stub.AbstractAsyncStub<CreateOrderServiceStub> {
    private CreateOrderServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreateOrderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateOrderServiceStub(channel, callOptions);
    }

    /**
     */
    public void createOrder(ds.assignment.trading.grpc.generated.CreateOrderRequest request,
        io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.CreateOrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CreateOrderServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CreateOrderServiceBlockingStub> {
    private CreateOrderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreateOrderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateOrderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.assignment.trading.grpc.generated.CreateOrderResponse createOrder(ds.assignment.trading.grpc.generated.CreateOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CreateOrderServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CreateOrderServiceFutureStub> {
    private CreateOrderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreateOrderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateOrderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.assignment.trading.grpc.generated.CreateOrderResponse> createOrder(
        ds.assignment.trading.grpc.generated.CreateOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ORDER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CreateOrderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CreateOrderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ORDER:
          serviceImpl.createOrder((ds.assignment.trading.grpc.generated.CreateOrderRequest) request,
              (io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.CreateOrderResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CreateOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CreateOrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.assignment.trading.grpc.generated.TradingService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CreateOrderService");
    }
  }

  private static final class CreateOrderServiceFileDescriptorSupplier
      extends CreateOrderServiceBaseDescriptorSupplier {
    CreateOrderServiceFileDescriptorSupplier() {}
  }

  private static final class CreateOrderServiceMethodDescriptorSupplier
      extends CreateOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CreateOrderServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CreateOrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CreateOrderServiceFileDescriptorSupplier())
              .addMethod(getCreateOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
