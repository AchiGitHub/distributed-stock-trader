// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TradingService.proto

package ds.assignment.trading.grpc.generated;

/**
 * Protobuf type {@code ds.assignment.trading.grpc.generated.SetStockRequest}
 */
public final class SetStockRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ds.assignment.trading.grpc.generated.SetStockRequest)
    SetStockRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SetStockRequest.newBuilder() to construct.
  private SetStockRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SetStockRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SetStockRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SetStockRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 9: {

            price_ = input.readDouble();
            break;
          }
          case 16: {

            units_ = input.readInt32();
            break;
          }
          case 24: {

            isSentByPrimary_ = input.readBool();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ds.assignment.trading.grpc.generated.TradingService.internal_static_ds_assignment_trading_grpc_generated_SetStockRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.assignment.trading.grpc.generated.TradingService.internal_static_ds_assignment_trading_grpc_generated_SetStockRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.assignment.trading.grpc.generated.SetStockRequest.class, ds.assignment.trading.grpc.generated.SetStockRequest.Builder.class);
  }

  public static final int PRICE_FIELD_NUMBER = 1;
  private double price_;
  /**
   * <code>double price = 1;</code>
   * @return The price.
   */
  @java.lang.Override
  public double getPrice() {
    return price_;
  }

  public static final int UNITS_FIELD_NUMBER = 2;
  private int units_;
  /**
   * <code>int32 units = 2;</code>
   * @return The units.
   */
  @java.lang.Override
  public int getUnits() {
    return units_;
  }

  public static final int ISSENTBYPRIMARY_FIELD_NUMBER = 3;
  private boolean isSentByPrimary_;
  /**
   * <code>bool isSentByPrimary = 3;</code>
   * @return The isSentByPrimary.
   */
  @java.lang.Override
  public boolean getIsSentByPrimary() {
    return isSentByPrimary_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (price_ != 0D) {
      output.writeDouble(1, price_);
    }
    if (units_ != 0) {
      output.writeInt32(2, units_);
    }
    if (isSentByPrimary_ != false) {
      output.writeBool(3, isSentByPrimary_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (price_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, price_);
    }
    if (units_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, units_);
    }
    if (isSentByPrimary_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, isSentByPrimary_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ds.assignment.trading.grpc.generated.SetStockRequest)) {
      return super.equals(obj);
    }
    ds.assignment.trading.grpc.generated.SetStockRequest other = (ds.assignment.trading.grpc.generated.SetStockRequest) obj;

    if (java.lang.Double.doubleToLongBits(getPrice())
        != java.lang.Double.doubleToLongBits(
            other.getPrice())) return false;
    if (getUnits()
        != other.getUnits()) return false;
    if (getIsSentByPrimary()
        != other.getIsSentByPrimary()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PRICE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getPrice()));
    hash = (37 * hash) + UNITS_FIELD_NUMBER;
    hash = (53 * hash) + getUnits();
    hash = (37 * hash) + ISSENTBYPRIMARY_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getIsSentByPrimary());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.assignment.trading.grpc.generated.SetStockRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.assignment.trading.grpc.generated.SetStockRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.assignment.trading.grpc.generated.SetStockRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.assignment.trading.grpc.generated.SetStockRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.assignment.trading.grpc.generated.SetStockRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.assignment.trading.grpc.generated.SetStockRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.assignment.trading.grpc.generated.SetStockRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.assignment.trading.grpc.generated.SetStockRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.assignment.trading.grpc.generated.SetStockRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.assignment.trading.grpc.generated.SetStockRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.assignment.trading.grpc.generated.SetStockRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.assignment.trading.grpc.generated.SetStockRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ds.assignment.trading.grpc.generated.SetStockRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ds.assignment.trading.grpc.generated.SetStockRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ds.assignment.trading.grpc.generated.SetStockRequest)
      ds.assignment.trading.grpc.generated.SetStockRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.assignment.trading.grpc.generated.TradingService.internal_static_ds_assignment_trading_grpc_generated_SetStockRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.assignment.trading.grpc.generated.TradingService.internal_static_ds_assignment_trading_grpc_generated_SetStockRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.assignment.trading.grpc.generated.SetStockRequest.class, ds.assignment.trading.grpc.generated.SetStockRequest.Builder.class);
    }

    // Construct using ds.assignment.trading.grpc.generated.SetStockRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      price_ = 0D;

      units_ = 0;

      isSentByPrimary_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.assignment.trading.grpc.generated.TradingService.internal_static_ds_assignment_trading_grpc_generated_SetStockRequest_descriptor;
    }

    @java.lang.Override
    public ds.assignment.trading.grpc.generated.SetStockRequest getDefaultInstanceForType() {
      return ds.assignment.trading.grpc.generated.SetStockRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ds.assignment.trading.grpc.generated.SetStockRequest build() {
      ds.assignment.trading.grpc.generated.SetStockRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.assignment.trading.grpc.generated.SetStockRequest buildPartial() {
      ds.assignment.trading.grpc.generated.SetStockRequest result = new ds.assignment.trading.grpc.generated.SetStockRequest(this);
      result.price_ = price_;
      result.units_ = units_;
      result.isSentByPrimary_ = isSentByPrimary_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ds.assignment.trading.grpc.generated.SetStockRequest) {
        return mergeFrom((ds.assignment.trading.grpc.generated.SetStockRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.assignment.trading.grpc.generated.SetStockRequest other) {
      if (other == ds.assignment.trading.grpc.generated.SetStockRequest.getDefaultInstance()) return this;
      if (other.getPrice() != 0D) {
        setPrice(other.getPrice());
      }
      if (other.getUnits() != 0) {
        setUnits(other.getUnits());
      }
      if (other.getIsSentByPrimary() != false) {
        setIsSentByPrimary(other.getIsSentByPrimary());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ds.assignment.trading.grpc.generated.SetStockRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.assignment.trading.grpc.generated.SetStockRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private double price_ ;
    /**
     * <code>double price = 1;</code>
     * @return The price.
     */
    @java.lang.Override
    public double getPrice() {
      return price_;
    }
    /**
     * <code>double price = 1;</code>
     * @param value The price to set.
     * @return This builder for chaining.
     */
    public Builder setPrice(double value) {
      
      price_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double price = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPrice() {
      
      price_ = 0D;
      onChanged();
      return this;
    }

    private int units_ ;
    /**
     * <code>int32 units = 2;</code>
     * @return The units.
     */
    @java.lang.Override
    public int getUnits() {
      return units_;
    }
    /**
     * <code>int32 units = 2;</code>
     * @param value The units to set.
     * @return This builder for chaining.
     */
    public Builder setUnits(int value) {
      
      units_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 units = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearUnits() {
      
      units_ = 0;
      onChanged();
      return this;
    }

    private boolean isSentByPrimary_ ;
    /**
     * <code>bool isSentByPrimary = 3;</code>
     * @return The isSentByPrimary.
     */
    @java.lang.Override
    public boolean getIsSentByPrimary() {
      return isSentByPrimary_;
    }
    /**
     * <code>bool isSentByPrimary = 3;</code>
     * @param value The isSentByPrimary to set.
     * @return This builder for chaining.
     */
    public Builder setIsSentByPrimary(boolean value) {
      
      isSentByPrimary_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isSentByPrimary = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearIsSentByPrimary() {
      
      isSentByPrimary_ = false;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ds.assignment.trading.grpc.generated.SetStockRequest)
  }

  // @@protoc_insertion_point(class_scope:ds.assignment.trading.grpc.generated.SetStockRequest)
  private static final ds.assignment.trading.grpc.generated.SetStockRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.assignment.trading.grpc.generated.SetStockRequest();
  }

  public static ds.assignment.trading.grpc.generated.SetStockRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SetStockRequest>
      PARSER = new com.google.protobuf.AbstractParser<SetStockRequest>() {
    @java.lang.Override
    public SetStockRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SetStockRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SetStockRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SetStockRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.assignment.trading.grpc.generated.SetStockRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

