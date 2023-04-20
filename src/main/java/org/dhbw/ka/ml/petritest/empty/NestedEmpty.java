package org.dhbw.ka.ml.petritest.empty;import java.io.*;import java.util.List;import java.util.ArrayList;@lombok.EqualsAndHashCode public class NestedEmpty {private Empty empty;public Empty getEmpty() {return this.empty;}public void setEmpty(Empty value) {this.empty = value;}public boolean hasEmpty() {return this.empty != null;}private String s;public String getS() {return this.s;}public void setS(String value) {this.s = value;}public boolean hasS() {return this.s != null;}public byte[] serialize() {byte[] yyBitVector = new byte[1];ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {if (this.hasEmpty()) {yyBitVector[0] |= 1;final byte[] serialized = empty.serialize();yyDataOutput.write(serialized.length);yyDataOutput.write(serialized);}if (this.hasS()) {yyBitVector[0] |= 2;org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(s, yyDataOutput);}ByteArrayOutputStream yyResult = new ByteArrayOutputStream();yyResult.writeBytes(yyBitVector);yySerializedFields.writeTo(yyResult);return yyResult.toByteArray();}catch (IOException e) {throw new RuntimeException("This should not happen...", e);}}public static NestedEmpty deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {final NestedEmpty yyResultValue = new NestedEmpty();try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {int yyLengthOfBitVector = 1;while ((yyIn.readByte() & 0x80) != 0) {yyLengthOfBitVector++;}if ((serialized[0] & 1) != 0) {final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);final Empty deserialized = Empty.yyDeserialize(yyIn, serializedLength);yyResultValue.setEmpty(deserialized);}if ((serialized[0] & 2) != 0) {final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);yyResultValue.setS(deserialized);}}catch (IOException e) {throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);}return yyResultValue;}static NestedEmpty yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {final NestedEmpty yyResultValue = new NestedEmpty();final int yyBeginOffset = petriReader.getOffset();int yyLengthOfBitVector = 1;while ((petriReader.readByte() & 0x80) != 0) {yyLengthOfBitVector++;}if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);final Empty deserialized = Empty.yyDeserialize(petriReader, serializedLength);yyResultValue.setEmpty(deserialized);}if ((petriReader.getByteAt(yyBeginOffset + 0) & 2) != 0) {final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);yyResultValue.setS(deserialized);}petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());return yyResultValue;}}