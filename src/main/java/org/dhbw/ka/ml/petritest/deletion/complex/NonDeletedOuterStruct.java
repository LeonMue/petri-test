package org.dhbw.ka.ml.petritest.deletion.complex;

import java.io.*;

public class NonDeletedOuterStruct {
    private int i;
    private boolean hasI = false;
    private NonDeletedInnerStruct inner;
    private String s;

    public int getI() {
        return this.i;
    }

    public boolean hasI() {
        return this.hasI;
    }

    public NonDeletedInnerStruct getInner() {
        return this.inner;
    }

    public boolean hasInner() {
        return this.inner != null;
    }

    public String getS() {
        return this.s;
    }

    public boolean hasS() {
        return this.s != null;
    }

    public void setI(int value) {
        this.hasI = true;
        this.i = value;
    }

    public void setInner(NonDeletedInnerStruct value) {
        this.inner = value;
    }

    public void setS(String value) {
        this.s = value;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[1];
        ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();
        try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {
            if (this.hasI()) {
                yyBitVector[0] |= 1;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.serialize(i, yyDataOutput);
            }
            if (this.hasInner()) {
                yyBitVector[0] |= 2;
                final byte[] serialized = inner.serialize();
                yyDataOutput.write(serialized.length);
                yyDataOutput.write(serialized);
            }
            if (this.hasS()) {
                yyBitVector[0] |= 4;
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

    public static NonDeletedOuterStruct deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final NonDeletedOuterStruct yyResultValue = new NonDeletedOuterStruct();
        try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {
            int yyLengthOfBitVector = 1;
            while ((yyIn.readByte() & 0x80) != 0) {
                yyLengthOfBitVector++;
            }
            if ((serialized[0] & 1) != 0) {
                final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(yyIn);
                yyResultValue.setI(deserialized);
            }
            if ((serialized[0] & 2) != 0) {
                final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                final NonDeletedInnerStruct deserialized = NonDeletedInnerStruct.yyDeserialize(yyIn, serializedLength);
                yyResultValue.setInner(deserialized);
            }
            if ((serialized[0] & 4) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setS(deserialized);
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return yyResultValue;
    }

    static NonDeletedOuterStruct yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {
        final NonDeletedOuterStruct yyResultValue = new NonDeletedOuterStruct();
        final int yyBeginOffset = petriReader.getOffset();
        int yyLengthOfBitVector = 1;
        while ((petriReader.readByte() & 0x80) != 0) {
            yyLengthOfBitVector++;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {
            final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(petriReader);
            yyResultValue.setI(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 2) != 0) {
            final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
            final NonDeletedInnerStruct deserialized = NonDeletedInnerStruct.yyDeserialize(petriReader, serializedLength);
            yyResultValue.setInner(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 4) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setS(deserialized);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}