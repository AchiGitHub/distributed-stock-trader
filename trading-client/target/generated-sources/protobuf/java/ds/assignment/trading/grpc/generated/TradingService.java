// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TradingService.proto

package ds.assignment.trading.grpc.generated;

public final class TradingService {
  private TradingService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ds_assignment_trading_grpc_generated_CreateOrderRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ds_assignment_trading_grpc_generated_CreateOrderRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ds_assignment_trading_grpc_generated_CreateOrderResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ds_assignment_trading_grpc_generated_CreateOrderResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ds_assignment_trading_grpc_generated_EditOrderRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ds_assignment_trading_grpc_generated_EditOrderRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ds_assignment_trading_grpc_generated_EditOrderResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ds_assignment_trading_grpc_generated_EditOrderResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ds_assignment_trading_grpc_generated_DeleteOrderRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ds_assignment_trading_grpc_generated_DeleteOrderRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ds_assignment_trading_grpc_generated_DeleteOrderResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ds_assignment_trading_grpc_generated_DeleteOrderResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ds_assignment_trading_grpc_generated_SetStockRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ds_assignment_trading_grpc_generated_SetStockRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ds_assignment_trading_grpc_generated_SetStockResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ds_assignment_trading_grpc_generated_SetStockResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024TradingService.proto\022$ds.assignment.tr" +
      "ading.grpc.generated\"}\n\022CreateOrderReque" +
      "st\022\017\n\007orderId\030\001 \001(\t\022\016\n\006symbol\030\002 \001(\t\022\r\n\005p" +
      "rice\030\003 \001(\001\022\014\n\004type\030\004 \001(\t\022\020\n\010quantity\030\005 \001" +
      "(\005\022\027\n\017isSentByPrimary\030\006 \001(\010\"%\n\023CreateOrd" +
      "erResponse\022\016\n\006status\030\001 \001(\010\"{\n\020EditOrderR" +
      "equest\022\017\n\007orderId\030\001 \001(\t\022\016\n\006symbol\030\002 \001(\t\022" +
      "\r\n\005price\030\003 \001(\001\022\014\n\004type\030\004 \001(\t\022\020\n\010quantity" +
      "\030\005 \001(\005\022\027\n\017isSentByPrimary\030\006 \001(\010\"#\n\021EditO" +
      "rderResponse\022\016\n\006status\030\001 \001(\010\">\n\022DeleteOr" +
      "derRequest\022\017\n\007orderId\030\001 \001(\t\022\027\n\017isSentByP" +
      "rimary\030\002 \001(\010\"%\n\023DeleteOrderResponse\022\016\n\006s" +
      "tatus\030\001 \001(\010\"H\n\017SetStockRequest\022\r\n\005price\030" +
      "\001 \001(\001\022\r\n\005units\030\002 \001(\005\022\027\n\017isSentByPrimary\030" +
      "\003 \001(\010\"\"\n\020SetStockResponse\022\016\n\006status\030\001 \001(" +
      "\0102\231\001\n\022CreateOrderService\022\202\001\n\013createOrder" +
      "\0228.ds.assignment.trading.grpc.generated." +
      "CreateOrderRequest\0329.ds.assignment.tradi" +
      "ng.grpc.generated.CreateOrderResponse2\220\001" +
      "\n\020EditOrderService\022|\n\teditOrder\0226.ds.ass" +
      "ignment.trading.grpc.generated.EditOrder" +
      "Request\0327.ds.assignment.trading.grpc.gen" +
      "erated.EditOrderResponse2\231\001\n\022DeleteOrder" +
      "Service\022\202\001\n\013deleteOrder\0228.ds.assignment." +
      "trading.grpc.generated.DeleteOrderReques" +
      "t\0329.ds.assignment.trading.grpc.generated" +
      ".DeleteOrderResponse2\214\001\n\017SetStockService" +
      "\022y\n\010setStock\0225.ds.assignment.trading.grp" +
      "c.generated.SetStockRequest\0326.ds.assignm" +
      "ent.trading.grpc.generated.SetStockRespo" +
      "nseB\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ds_assignment_trading_grpc_generated_CreateOrderRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ds_assignment_trading_grpc_generated_CreateOrderRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ds_assignment_trading_grpc_generated_CreateOrderRequest_descriptor,
        new java.lang.String[] { "OrderId", "Symbol", "Price", "Type", "Quantity", "IsSentByPrimary", });
    internal_static_ds_assignment_trading_grpc_generated_CreateOrderResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ds_assignment_trading_grpc_generated_CreateOrderResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ds_assignment_trading_grpc_generated_CreateOrderResponse_descriptor,
        new java.lang.String[] { "Status", });
    internal_static_ds_assignment_trading_grpc_generated_EditOrderRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ds_assignment_trading_grpc_generated_EditOrderRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ds_assignment_trading_grpc_generated_EditOrderRequest_descriptor,
        new java.lang.String[] { "OrderId", "Symbol", "Price", "Type", "Quantity", "IsSentByPrimary", });
    internal_static_ds_assignment_trading_grpc_generated_EditOrderResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ds_assignment_trading_grpc_generated_EditOrderResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ds_assignment_trading_grpc_generated_EditOrderResponse_descriptor,
        new java.lang.String[] { "Status", });
    internal_static_ds_assignment_trading_grpc_generated_DeleteOrderRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ds_assignment_trading_grpc_generated_DeleteOrderRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ds_assignment_trading_grpc_generated_DeleteOrderRequest_descriptor,
        new java.lang.String[] { "OrderId", "IsSentByPrimary", });
    internal_static_ds_assignment_trading_grpc_generated_DeleteOrderResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ds_assignment_trading_grpc_generated_DeleteOrderResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ds_assignment_trading_grpc_generated_DeleteOrderResponse_descriptor,
        new java.lang.String[] { "Status", });
    internal_static_ds_assignment_trading_grpc_generated_SetStockRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_ds_assignment_trading_grpc_generated_SetStockRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ds_assignment_trading_grpc_generated_SetStockRequest_descriptor,
        new java.lang.String[] { "Price", "Units", "IsSentByPrimary", });
    internal_static_ds_assignment_trading_grpc_generated_SetStockResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_ds_assignment_trading_grpc_generated_SetStockResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ds_assignment_trading_grpc_generated_SetStockResponse_descriptor,
        new java.lang.String[] { "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}