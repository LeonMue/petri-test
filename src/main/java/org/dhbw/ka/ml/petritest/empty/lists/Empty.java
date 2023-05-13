package org.dhbw.ka.ml.petritest.empty.lists;import java.io.*;import java.util.List;import java.util.ArrayList;@lombok.EqualsAndHashCode @lombok.ToString public class Empty {public byte[] serialize() {byte[] yyBitVector = new byte[1];try (final org.dhbw.ka.ml.petrilib.io.PetriWriter yyDataOutput = new org.dhbw.ka.ml.petrilib.io.PetriWriter()) {org.dhbw.ka.ml.petrilib.io.PetriWriter yyResult = new org.dhbw.ka.ml.petrilib.io.PetriWriter();yyResult.writeBytes(yyBitVector);yyDataOutput.writeTo(yyResult);return yyResult.toByteArray();}catch (IOException e) {throw new RuntimeException("This should not happen...", e);}}public static Empty deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {final Empty yyResultValue = new Empty();try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {int yyLengthOfBitVector = 1;while ((yyIn.readByte() & 0x80) != 0) {yyLengthOfBitVector++;}}catch (IOException e) {throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);}return yyResultValue;}static Empty yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {final Empty yyResultValue = new Empty();final int yyBeginOffset = petriReader.getOffset();int yyLengthOfBitVector = 1;while ((petriReader.readByte() & 0x80) != 0) {yyLengthOfBitVector++;}petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());return yyResultValue;}}