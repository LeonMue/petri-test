package org.dhbw.ka.ml.petritest.sd.lists.complex.nonrecursive;import java.io.*;import java.util.List;import java.util.ArrayList;@lombok.EqualsAndHashCode @lombok.ToString public class L {private List<T> l1;public List<T> getL1() {return this.l1;}public void setL1(List<T> value) {this.l1 = value;}public boolean hasL1() {return this.l1 != null;}public byte[] serialize() {byte[] yyBitVector = new byte[1];try (final org.dhbw.ka.ml.petrilib.io.PetriWriter yyDataOutput = new org.dhbw.ka.ml.petrilib.io.PetriWriter()) {if (this.hasL1()) {yyBitVector[0] |= 1;org.dhbw.ka.ml.petrilib.io.PetriWriter yySerializedList0 = new org.dhbw.ka.ml.petrilib.io.PetriWriter();for (T yyElement0 : l1) {if (yyElement0 == null) {throw new IllegalArgumentException("Elements of list must be not null");}final byte[] serialized = yyElement0.serialize();yySerializedList0.writeInt(serialized.length);yySerializedList0.write(serialized);}yyDataOutput.writeInt(yySerializedList0.size());yySerializedList0.writeTo(yyDataOutput);}org.dhbw.ka.ml.petrilib.io.PetriWriter yyResult = new org.dhbw.ka.ml.petrilib.io.PetriWriter();yyResult.writeBytes(yyBitVector);yyDataOutput.writeTo(yyResult);return yyResult.toByteArray();}catch (IOException e) {throw new RuntimeException("This should not happen...", e);}}public static L deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {final L yyResultValue = new L();try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {int yyLengthOfBitVector = 1;while ((yyIn.readByte() & 0x80) != 0) {yyLengthOfBitVector++;}if ((serialized[0] & 1) != 0) {final int yyListLength = yyIn.readInt();final List<T> yyDeserializedList = new ArrayList<T>(yyListLength);final int beginningOffset = yyIn.getOffset();while (yyIn.getOffset() < beginningOffset + yyListLength) {final int serializedLength = yyIn.readInt();final T deserialized = T.yyDeserialize(yyIn, serializedLength);yyDeserializedList.add(deserialized);}yyResultValue.setL1(yyDeserializedList);}}catch (IOException e) {throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);}return yyResultValue;}static L yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {final L yyResultValue = new L();final int yyBeginOffset = petriReader.getOffset();int yyLengthOfBitVector = 1;while ((petriReader.readByte() & 0x80) != 0) {yyLengthOfBitVector++;}if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {final int yyListLength = petriReader.readInt();final List<T> yyDeserializedList = new ArrayList<T>(yyListLength);final int beginningOffset = petriReader.getOffset();while (petriReader.getOffset() < beginningOffset + yyListLength) {final int serializedLength = petriReader.readInt();final T deserialized = T.yyDeserialize(petriReader, serializedLength);yyDeserializedList.add(deserialized);}yyResultValue.setL1(yyDeserializedList);}petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());return yyResultValue;}}