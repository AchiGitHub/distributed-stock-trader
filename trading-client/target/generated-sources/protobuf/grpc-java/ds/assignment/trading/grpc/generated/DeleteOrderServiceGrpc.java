package ds.assignment.trading.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: TradingService.proto")
public final class DeleteOrderServiceGrpc {

  private DeleteOrderServiceGrpc() {}

  public static final String SERVICE_NAME = "ds.assignment.trading.grpc.generated.DeleteOrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.assignment.trading.grpc.generated.DeleteOrderRequest,
      ds.assignment.trading.grpc.generated.DeleteOrderResponse> getDeleteOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteOrder",
      requestType = ds.assignment.trading.grpc.generated.DeleteOrderRequest.class,
      responseType = ds.assignment.trading.grpc.generated.DeleteOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.assignment.trading.grpc.generated.DeleteOrderRequest,
      ds.assignment.trading.grpc.generated.DeleteOrderResponse> getDeleteOrderMethod() {
    io.grpc.MethodDescriptor<ds.assignment.trading.grpc.generated.DeleteOrderRequest, ds.assignment.trading.grpc.generated.DeleteOrderResponse> getDeleteOrderMethod;
    if ((getDeleteOrderMethod = DeleteOrderServiceGrpc.getDeleteOrderMethod) == null) {
      synchronized (DeleteOrderServiceGrpc.class) {
        if ((getDeleteOrderMethod = DeleteOrderServiceGrpc.getDeleteOrderMethod) == null) {
          DeleteOrderServiceGrpc.getDeleteOrderMethod = getDeleteOrderMethod =
              io.grpc.MethodDescriptor.<ds.assignment.trading.grpc.generated.DeleteOrderRequest, ds.assignment.trading.grpc.generated.DeleteOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.assignment.trading.grpc.generated.DeleteOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.assignment.trading.grpc.generated.DeleteOrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DeleteOrderServiceMethodDescriptorSupplier("deleteOrder"))
              .build();
        }
      }
    }
    return getDeleteOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeleteOrderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeleteOrderServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeleteOrderServiceStub>() {
        @java.lang.Override
        public DeleteOrderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeleteOrderServiceStub(channel, callOptions);
        }
      };
    return DeleteOrderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeleteOrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeleteOrderServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeleteOrderServiceBlockingStub>() {
        @java.lang.Override
        public DeleteOrderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeleteOrderServiceBlockingStub(channel, callOptions);
        }
      };
    return DeleteOrderServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeleteOrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeleteOrderServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeleteOrderServiceFutureStub>() {
        @java.lang.Override
        public DeleteOrderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeleteOrderServiceFutureStub(channel, callOptions);
        }
      };
    return DeleteOrderServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DeleteOrderServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void deleteOrder(ds.assignment.trading.grpc.generated.DeleteOrderRequest request,
        io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.DeleteOrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDeleteOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ds.assignment.trading.grpc.generated.DeleteOrderRequest,
                ds.assignment.trading.grpc.generated.DeleteOrderResponse>(
                  this, METHODID_DELETE_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class DeleteOrderServiceStub extends io.grpc.stub.AbstractAsyncStub<DeleteOrderServiceStub> {
    private DeleteOrderServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeleteOrderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeleteOrderServiceStub(channel, callOptions);
    }

    /**
     */
    public void deleteOrder(ds.assignment.trading.grpc.generated.DeleteOrderRequest request,
        io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.DeleteOrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DeleteOrderServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DeleteOrderServiceBlockingStub> {
    private DeleteOrderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeleteOrderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeleteOrderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.assignment.trading.grpc.generated.DeleteOrderResponse deleteOrder(ds.assignment.trading.grpc.generated.DeleteOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DeleteOrderServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DeleteOrderServiceFutureStub> {
    private DeleteOrderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeleteOrderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeleteOrderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.assignment.trading.grpc.generated.DeleteOrderResponse> deleteOrder(
        ds.assignment.trading.grpc.generated.DeleteOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE_ORDER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DeleteOrderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeleteOrderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELETE_ORDER:
          serviceImpl.deleteOrder((ds.assignment.trading.grpc.generated.DeleteOrderRequest) request,
              (io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.DeleteOrderResponse>) responseObserver);
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

  private static abstract class DeleteOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeleteOrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.assignment.trading.grpc.generated.TradingService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeleteOrderService");
    }
  }

  private static final class DeleteOrderServiceFileDescriptorSupplier
      extends DeleteOrderServiceBaseDescriptorSupplier {
    DeleteOrderServiceFileDescriptorSupplier() {}
  }

  private static final class DeleteOrderServiceMethodDescriptorSupplier
      extends DeleteOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DeleteOrderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DeleteOrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeleteOrderServiceFileDescriptorSupplier())
              .addMethod(getDeleteOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
