package ds.assignment.trading.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: TradingService.proto")
public final class EditOrderServiceGrpc {

  private EditOrderServiceGrpc() {}

  public static final String SERVICE_NAME = "ds.assignment.trading.grpc.generated.EditOrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.assignment.trading.grpc.generated.EditOrderRequest,
      ds.assignment.trading.grpc.generated.EditOrderResponse> getEditOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "editOrder",
      requestType = ds.assignment.trading.grpc.generated.EditOrderRequest.class,
      responseType = ds.assignment.trading.grpc.generated.EditOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.assignment.trading.grpc.generated.EditOrderRequest,
      ds.assignment.trading.grpc.generated.EditOrderResponse> getEditOrderMethod() {
    io.grpc.MethodDescriptor<ds.assignment.trading.grpc.generated.EditOrderRequest, ds.assignment.trading.grpc.generated.EditOrderResponse> getEditOrderMethod;
    if ((getEditOrderMethod = EditOrderServiceGrpc.getEditOrderMethod) == null) {
      synchronized (EditOrderServiceGrpc.class) {
        if ((getEditOrderMethod = EditOrderServiceGrpc.getEditOrderMethod) == null) {
          EditOrderServiceGrpc.getEditOrderMethod = getEditOrderMethod =
              io.grpc.MethodDescriptor.<ds.assignment.trading.grpc.generated.EditOrderRequest, ds.assignment.trading.grpc.generated.EditOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "editOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.assignment.trading.grpc.generated.EditOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.assignment.trading.grpc.generated.EditOrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EditOrderServiceMethodDescriptorSupplier("editOrder"))
              .build();
        }
      }
    }
    return getEditOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EditOrderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EditOrderServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EditOrderServiceStub>() {
        @java.lang.Override
        public EditOrderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EditOrderServiceStub(channel, callOptions);
        }
      };
    return EditOrderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EditOrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EditOrderServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EditOrderServiceBlockingStub>() {
        @java.lang.Override
        public EditOrderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EditOrderServiceBlockingStub(channel, callOptions);
        }
      };
    return EditOrderServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EditOrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EditOrderServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EditOrderServiceFutureStub>() {
        @java.lang.Override
        public EditOrderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EditOrderServiceFutureStub(channel, callOptions);
        }
      };
    return EditOrderServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EditOrderServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void editOrder(ds.assignment.trading.grpc.generated.EditOrderRequest request,
        io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.EditOrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEditOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEditOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ds.assignment.trading.grpc.generated.EditOrderRequest,
                ds.assignment.trading.grpc.generated.EditOrderResponse>(
                  this, METHODID_EDIT_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class EditOrderServiceStub extends io.grpc.stub.AbstractAsyncStub<EditOrderServiceStub> {
    private EditOrderServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EditOrderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EditOrderServiceStub(channel, callOptions);
    }

    /**
     */
    public void editOrder(ds.assignment.trading.grpc.generated.EditOrderRequest request,
        io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.EditOrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEditOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EditOrderServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<EditOrderServiceBlockingStub> {
    private EditOrderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EditOrderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EditOrderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.assignment.trading.grpc.generated.EditOrderResponse editOrder(ds.assignment.trading.grpc.generated.EditOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEditOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EditOrderServiceFutureStub extends io.grpc.stub.AbstractFutureStub<EditOrderServiceFutureStub> {
    private EditOrderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EditOrderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EditOrderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.assignment.trading.grpc.generated.EditOrderResponse> editOrder(
        ds.assignment.trading.grpc.generated.EditOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEditOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EDIT_ORDER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EditOrderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EditOrderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EDIT_ORDER:
          serviceImpl.editOrder((ds.assignment.trading.grpc.generated.EditOrderRequest) request,
              (io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.EditOrderResponse>) responseObserver);
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

  private static abstract class EditOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EditOrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.assignment.trading.grpc.generated.TradingService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EditOrderService");
    }
  }

  private static final class EditOrderServiceFileDescriptorSupplier
      extends EditOrderServiceBaseDescriptorSupplier {
    EditOrderServiceFileDescriptorSupplier() {}
  }

  private static final class EditOrderServiceMethodDescriptorSupplier
      extends EditOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EditOrderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EditOrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EditOrderServiceFileDescriptorSupplier())
              .addMethod(getEditOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
