package org.dhbw.ka.ml.petritest.deletion.complex;

import java.io.*;

public class NonDeletedInnerStruct {
    private String s;

    public String getS() {
        return this.s;
    }

    public boolean hasS() {
        return this.s != null;
    }

    public void setS(String value) {
        this.s = value;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[1];
        ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();
        try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {
            if (this.hasS()) {
                yyBitVector[0] |= 1;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(s, yyDataOutput);
            }
            ByteArrayOutputStream yyResult = new ByteArrayOutputStream();
            yyResult.writeBytes(yyBitVector);
            yySerializedFields.writeTo(yyResult);
            return yyResult.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("This should not happen...", e);
        }
    }

    public static NonDeletedInnerStruct deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final NonDeletedInnerStruct yyResultValue = new NonDeletedInnerStruct();
        try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {
            int yyLengthOfBitVector = 1;
            while ((yyIn.readByte() & 0x80) != 0) {
                yyLengthOfBitVector++;
            }
            if ((serialized[0] & 1) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setS(deserialized);
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return yyResultValue;
    }

    static NonDeletedInnerStruct yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {
        final NonDeletedInnerStruct yyResultValue = new NonDeletedInnerStruct();
        final int yyBeginOffset = petriReader.getOffset();
        int yyLengthOfBitVector = 1;
        while ((petriReader.readByte() & 0x80) != 0) {
            yyLengthOfBitVector++;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setS(deserialized);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}