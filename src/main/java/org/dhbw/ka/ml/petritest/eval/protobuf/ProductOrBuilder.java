// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/resources/product_orders.proto

package org.dhbw.ka.ml.petritest.eval.protobuf;

public interface ProductOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tutorial.Product)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string brand = 1;</code>
   * @return The brand.
   */
  java.lang.String getBrand();
  /**
   * <code>string brand = 1;</code>
   * @return The bytes for brand.
   */
  com.google.protobuf.ByteString
      getBrandBytes();

  /**
   * <code>double price = 2;</code>
   * @return The price.
   */
  double getPrice();

  /**
   * <code>double weight = 3;</code>
   * @return The weight.
   */
  double getWeight();

  /**
   * <code>int32 amount = 4;</code>
   * @return The amount.
   */
  int getAmount();

  /**
   * <code>string name = 5;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 5;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>repeated string colors = 6;</code>
   * @return A list containing the colors.
   */
  java.util.List<java.lang.String>
      getColorsList();
  /**
   * <code>repeated string colors = 6;</code>
   * @return The count of colors.
   */
  int getColorsCount();
  /**
   * <code>repeated string colors = 6;</code>
   * @param index The index of the element to return.
   * @return The colors at the given index.
   */
  java.lang.String getColors(int index);
  /**
   * <code>repeated string colors = 6;</code>
   * @param index The index of the value to return.
   * @return The bytes of the colors at the given index.
   */
  com.google.protobuf.ByteString
      getColorsBytes(int index);
}