package ds.assignment.trading.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: TradingService.proto")
public final class SetStockServiceGrpc {

  private SetStockServiceGrpc() {}

  public static final String SERVICE_NAME = "ds.assignment.trading.grpc.generated.SetStockService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.assignment.trading.grpc.generated.SetStockRequest,
      ds.assignment.trading.grpc.generated.SetStockResponse> getSetStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setStock",
      requestType = ds.assignment.trading.grpc.generated.SetStockRequest.class,
      responseType = ds.assignment.trading.grpc.generated.SetStockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.assignment.trading.grpc.generated.SetStockRequest,
      ds.assignment.trading.grpc.generated.SetStockResponse> getSetStockMethod() {
    io.grpc.MethodDescriptor<ds.assignment.trading.grpc.generated.SetStockRequest, ds.assignment.trading.grpc.generated.SetStockResponse> getSetStockMethod;
    if ((getSetStockMethod = SetStockServiceGrpc.getSetStockMethod) == null) {
      synchronized (SetStockServiceGrpc.class) {
        if ((getSetStockMethod = SetStockServiceGrpc.getSetStockMethod) == null) {
          SetStockServiceGrpc.getSetStockMethod = getSetStockMethod =
              io.grpc.MethodDescriptor.<ds.assignment.trading.grpc.generated.SetStockRequest, ds.assignment.trading.grpc.generated.SetStockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.assignment.trading.grpc.generated.SetStockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.assignment.trading.grpc.generated.SetStockResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SetStockServiceMethodDescriptorSupplier("setStock"))
              .build();
        }
      }
    }
    return getSetStockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SetStockServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SetStockServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SetStockServiceStub>() {
        @java.lang.Override
        public SetStockServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SetStockServiceStub(channel, callOptions);
        }
      };
    return SetStockServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SetStockServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SetStockServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SetStockServiceBlockingStub>() {
        @java.lang.Override
        public SetStockServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SetStockServiceBlockingStub(channel, callOptions);
        }
      };
    return SetStockServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SetStockServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SetStockServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SetStockServiceFutureStub>() {
        @java.lang.Override
        public SetStockServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SetStockServiceFutureStub(channel, callOptions);
        }
      };
    return SetStockServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SetStockServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void setStock(ds.assignment.trading.grpc.generated.SetStockRequest request,
        io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.SetStockResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetStockMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetStockMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ds.assignment.trading.grpc.generated.SetStockRequest,
                ds.assignment.trading.grpc.generated.SetStockResponse>(
                  this, METHODID_SET_STOCK)))
          .build();
    }
  }

  /**
   */
  public static final class SetStockServiceStub extends io.grpc.stub.AbstractAsyncStub<SetStockServiceStub> {
    private SetStockServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SetStockServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SetStockServiceStub(channel, callOptions);
    }

    /**
     */
    public void setStock(ds.assignment.trading.grpc.generated.SetStockRequest request,
        io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.SetStockResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetStockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SetStockServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SetStockServiceBlockingStub> {
    private SetStockServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SetStockServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SetStockServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.assignment.trading.grpc.generated.SetStockResponse setStock(ds.assignment.trading.grpc.generated.SetStockRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetStockMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SetStockServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SetStockServiceFutureStub> {
    private SetStockServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SetStockServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SetStockServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.assignment.trading.grpc.generated.SetStockResponse> setStock(
        ds.assignment.trading.grpc.generated.SetStockRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetStockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_STOCK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SetStockServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SetStockServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_STOCK:
          serviceImpl.setStock((ds.assignment.trading.grpc.generated.SetStockRequest) request,
              (io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.SetStockResponse>) responseObserver);
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

  private static abstract class SetStockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SetStockServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.assignment.trading.grpc.generated.TradingService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SetStockService");
    }
  }

  private static final class SetStockServiceFileDescriptorSupplier
      extends SetStockServiceBaseDescriptorSupplier {
    SetStockServiceFileDescriptorSupplier() {}
  }

  private static final class SetStockServiceMethodDescriptorSupplier
      extends SetStockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SetStockServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SetStockServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SetStockServiceFileDescriptorSupplier())
              .addMethod(getSetStockMethod())
              .build();
        }
      }
    }
    return result;
  }
}
