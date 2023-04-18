package org.dhbw.ka.ml.petritest.sd.complex;

import lombok.EqualsAndHashCode;

import java.io.*;

@EqualsAndHashCode
public class OuterStruct {
    private String s1;
    private InnerStruct inner;
    private String s2;

    public String getS1() {
        return this.s1;
    }

    public boolean hasS1() {
        return this.s1 != null;
    }

    public InnerStruct getInner() {
        return this.inner;
    }

    public boolean hasInner() {
        return this.inner != null;
    }

    public String getS2() {
        return this.s2;
    }

    public boolean hasS2() {
        return this.s2 != null;
    }

    public void setS1(String value) {
        this.s1 = value;
    }

    public void setInner(InnerStruct value) {
        this.inner = value;
    }

    public void setS2(String value) {
        this.s2 = value;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[1];
        ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();
        try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {
            if (this.hasS1()) {
                yyBitVector[0] |= 1;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(s1, yyDataOutput);
            }
            if (this.hasInner()) {
                yyBitVector[0] |= 2;
                final byte[] serialized = inner.serialize();
                yyDataOutput.write(serialized.length);
                yyDataOutput.write(serialized);
            }
            if (this.hasS2()) {
                yyBitVector[0] |= 4;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(s2, yyDataOutput);
            }
            ByteArrayOutputStream yyResult = new ByteArrayOutputStream();
            yyResult.writeBytes(yyBitVector);
            yySerializedFields.writeTo(yyResult);
            return yyResult.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("This should not happen...", e);
        }
    }

    public static OuterStruct deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final OuterStruct yyResultValue = new OuterStruct();
        try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {
            int yyLengthOfBitVector = 1;
            while ((yyIn.readByte() & 0x80) != 0) {
                yyLengthOfBitVector++;
            }
            if ((serialized[0] & 1) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setS1(deserialized);
            }
            if ((serialized[0] & 2) != 0) {
                final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                final InnerStruct deserialized = InnerStruct.yyDeserialize(yyIn, serializedLength);
                yyResultValue.setInner(deserialized);
            }
            if ((serialized[0] & 4) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setS2(deserialized);
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return yyResultValue;
    }

    static OuterStruct yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {
        final OuterStruct yyResultValue = new OuterStruct();
        final int yyBeginOffset = petriReader.getOffset();
        int yyLengthOfBitVector = 1;
        while ((petriReader.readByte() & 0x80) != 0) {
            yyLengthOfBitVector++;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setS1(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 2) != 0) {
            final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
            final InnerStruct deserialized = InnerStruct.yyDeserialize(petriReader, serializedLength);
            yyResultValue.setInner(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 4) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setS2(deserialized);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}