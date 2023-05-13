package org.dhbw.ka.ml.petritest.extension.complex;import java.io.*;import java.util.List;import java.util.ArrayList;@lombok.EqualsAndHashCode @lombok.ToString public class OlderParentObject {private OlderInnerObject older;public OlderInnerObject getOlder() {return this.older;}public void setOlder(OlderInnerObject value) {this.older = value;}public boolean hasOlder() {return this.older != null;}public byte[] serialize() {byte[] yyBitVector = new byte[1];try (final org.dhbw.ka.ml.petrilib.io.PetriWriter yyDataOutput = new org.dhbw.ka.ml.petrilib.io.PetriWriter()) {if (this.hasOlder()) {yyBitVector[0] |= 1;final byte[] serialized = older.serialize();yyDataOutput.writeInt(serialized.length);yyDataOutput.write(serialized);}org.dhbw.ka.ml.petrilib.io.PetriWriter yyResult = new org.dhbw.ka.ml.petrilib.io.PetriWriter();yyResult.writeBytes(yyBitVector);yyDataOutput.writeTo(yyResult);return yyResult.toByteArray();}catch (IOException e) {throw new RuntimeException("This should not happen...", e);}}public static OlderParentObject deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {final OlderParentObject yyResultValue = new OlderParentObject();try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {int yyLengthOfBitVector = 1;while ((yyIn.readByte() & 0x80) != 0) {yyLengthOfBitVector++;}if ((serialized[0] & 1) != 0) {final int serializedLength = yyIn.readInt();final OlderInnerObject deserialized = OlderInnerObject.yyDeserialize(yyIn, serializedLength);yyResultValue.setOlder(deserialized);}}catch (IOException e) {throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);}return yyResultValue;}static OlderParentObject yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {final OlderParentObject yyResultValue = new OlderParentObject();final int yyBeginOffset = petriReader.getOffset();int yyLengthOfBitVector = 1;while ((petriReader.readByte() & 0x80) != 0) {yyLengthOfBitVector++;}if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {final int serializedLength = petriReader.readInt();final OlderInnerObject deserialized = OlderInnerObject.yyDeserialize(petriReader, serializedLength);yyResultValue.setOlder(deserialized);}petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());return yyResultValue;}}