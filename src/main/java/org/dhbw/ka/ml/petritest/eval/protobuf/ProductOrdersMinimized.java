// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/resources/product_orders.proto

package org.dhbw.ka.ml.petritest.eval.protobuf;

/**
 * Protobuf type {@code tutorial.ProductOrdersMinimized}
 */
public final class ProductOrdersMinimized extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tutorial.ProductOrdersMinimized)
    ProductOrdersMinimizedOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ProductOrdersMinimized.newBuilder() to construct.
  private ProductOrdersMinimized(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ProductOrdersMinimized() {
    products_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ProductOrdersMinimized();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersProtos.internal_static_tutorial_ProductOrdersMinimized_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersProtos.internal_static_tutorial_ProductOrdersMinimized_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized.class, org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized.Builder.class);
  }

  public static final int PRODUCTS_FIELD_NUMBER = 1;
  private java.util.List<org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized> products_;
  /**
   * <code>repeated .tutorial.ProductMinimized products = 1;</code>
   */
  @java.lang.Override
  public java.util.List<org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized> getProductsList() {
    return products_;
  }
  /**
   * <code>repeated .tutorial.ProductMinimized products = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimizedOrBuilder> 
      getProductsOrBuilderList() {
    return products_;
  }
  /**
   * <code>repeated .tutorial.ProductMinimized products = 1;</code>
   */
  @java.lang.Override
  public int getProductsCount() {
    return products_.size();
  }
  /**
   * <code>repeated .tutorial.ProductMinimized products = 1;</code>
   */
  @java.lang.Override
  public org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized getProducts(int index) {
    return products_.get(index);
  }
  /**
   * <code>repeated .tutorial.ProductMinimized products = 1;</code>
   */
  @java.lang.Override
  public org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimizedOrBuilder getProductsOrBuilder(
      int index) {
    return products_.get(index);
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
    for (int i = 0; i < products_.size(); i++) {
      output.writeMessage(1, products_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < products_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, products_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized)) {
      return super.equals(obj);
    }
    org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized other = (org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized) obj;

    if (!getProductsList()
        .equals(other.getProductsList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getProductsCount() > 0) {
      hash = (37 * hash) + PRODUCTS_FIELD_NUMBER;
      hash = (53 * hash) + getProductsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized parseFrom(
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
  public static Builder newBuilder(org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized prototype) {
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
   * Protobuf type {@code tutorial.ProductOrdersMinimized}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tutorial.ProductOrdersMinimized)
      org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimizedOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersProtos.internal_static_tutorial_ProductOrdersMinimized_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersProtos.internal_static_tutorial_ProductOrdersMinimized_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized.class, org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized.Builder.class);
    }

    // Construct using org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (productsBuilder_ == null) {
        products_ = java.util.Collections.emptyList();
      } else {
        products_ = null;
        productsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersProtos.internal_static_tutorial_ProductOrdersMinimized_descriptor;
    }

    @java.lang.Override
    public org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized getDefaultInstanceForType() {
      return org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized.getDefaultInstance();
    }

    @java.lang.Override
    public org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized build() {
      org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized buildPartial() {
      org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized result = new org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized(this);
      int from_bitField0_ = bitField0_;
      if (productsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          products_ = java.util.Collections.unmodifiableList(products_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.products_ = products_;
      } else {
        result.products_ = productsBuilder_.build();
      }
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
      if (other instanceof org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized) {
        return mergeFrom((org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized other) {
      if (other == org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized.getDefaultInstance()) return this;
      if (productsBuilder_ == null) {
        if (!other.products_.isEmpty()) {
          if (products_.isEmpty()) {
            products_ = other.products_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureProductsIsMutable();
            products_.addAll(other.products_);
          }
          onChanged();
        }
      } else {
        if (!other.products_.isEmpty()) {
          if (productsBuilder_.isEmpty()) {
            productsBuilder_.dispose();
            productsBuilder_ = null;
            products_ = other.products_;
            bitField0_ = (bitField0_ & ~0x00000001);
            productsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getProductsFieldBuilder() : null;
          } else {
            productsBuilder_.addAllMessages(other.products_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
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
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized m =
                  input.readMessage(
                      org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized.parser(),
                      extensionRegistry);
              if (productsBuilder_ == null) {
                ensureProductsIsMutable();
                products_.add(m);
              } else {
                productsBuilder_.addMessage(m);
              }
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.util.List<org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized> products_ =
      java.util.Collections.emptyList();
    private void ensureProductsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        products_ = new java.util.ArrayList<org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized>(products_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized, org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized.Builder, org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimizedOrBuilder> productsBuilder_;

    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public java.util.List<org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized> getProductsList() {
      if (productsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(products_);
      } else {
        return productsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public int getProductsCount() {
      if (productsBuilder_ == null) {
        return products_.size();
      } else {
        return productsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized getProducts(int index) {
      if (productsBuilder_ == null) {
        return products_.get(index);
      } else {
        return productsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public Builder setProducts(
        int index, org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized value) {
      if (productsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProductsIsMutable();
        products_.set(index, value);
        onChanged();
      } else {
        productsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public Builder setProducts(
        int index, org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized.Builder builderForValue) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        products_.set(index, builderForValue.build());
        onChanged();
      } else {
        productsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public Builder addProducts(org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized value) {
      if (productsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProductsIsMutable();
        products_.add(value);
        onChanged();
      } else {
        productsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public Builder addProducts(
        int index, org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized value) {
      if (productsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProductsIsMutable();
        products_.add(index, value);
        onChanged();
      } else {
        productsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public Builder addProducts(
        org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized.Builder builderForValue) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        products_.add(builderForValue.build());
        onChanged();
      } else {
        productsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public Builder addProducts(
        int index, org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized.Builder builderForValue) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        products_.add(index, builderForValue.build());
        onChanged();
      } else {
        productsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public Builder addAllProducts(
        java.lang.Iterable<? extends org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized> values) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, products_);
        onChanged();
      } else {
        productsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public Builder clearProducts() {
      if (productsBuilder_ == null) {
        products_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        productsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public Builder removeProducts(int index) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        products_.remove(index);
        onChanged();
      } else {
        productsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized.Builder getProductsBuilder(
        int index) {
      return getProductsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimizedOrBuilder getProductsOrBuilder(
        int index) {
      if (productsBuilder_ == null) {
        return products_.get(index);  } else {
        return productsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public java.util.List<? extends org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimizedOrBuilder> 
         getProductsOrBuilderList() {
      if (productsBuilder_ != null) {
        return productsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(products_);
      }
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized.Builder addProductsBuilder() {
      return getProductsFieldBuilder().addBuilder(
          org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized.getDefaultInstance());
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized.Builder addProductsBuilder(
        int index) {
      return getProductsFieldBuilder().addBuilder(
          index, org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized.getDefaultInstance());
    }
    /**
     * <code>repeated .tutorial.ProductMinimized products = 1;</code>
     */
    public java.util.List<org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized.Builder> 
         getProductsBuilderList() {
      return getProductsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized, org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized.Builder, org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimizedOrBuilder> 
        getProductsFieldBuilder() {
      if (productsBuilder_ == null) {
        productsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized, org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimized.Builder, org.dhbw.ka.ml.petritest.eval.protobuf.ProductMinimizedOrBuilder>(
                products_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        products_ = null;
      }
      return productsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:tutorial.ProductOrdersMinimized)
  }

  // @@protoc_insertion_point(class_scope:tutorial.ProductOrdersMinimized)
  private static final org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized();
  }

  public static org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ProductOrdersMinimized>
      PARSER = new com.google.protobuf.AbstractParser<ProductOrdersMinimized>() {
    @java.lang.Override
    public ProductOrdersMinimized parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<ProductOrdersMinimized> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ProductOrdersMinimized> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.dhbw.ka.ml.petritest.eval.protobuf.ProductOrdersMinimized getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

