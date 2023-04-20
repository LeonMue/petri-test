package org.dhbw.ka.ml.petritest.sd.complex;

import lombok.EqualsAndHashCode;

import java.io.*;

@EqualsAndHashCode
public class TripleNested {
    private int i;
    private boolean hasI = false;
    private OuterStruct triple;
    private String s;

    public int getI() {
        return this.i;
    }

    public boolean hasI() {
        return this.hasI;
    }

    public OuterStruct getTriple() {
        return this.triple;
    }

    public boolean hasTriple() {
        return this.triple != null;
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

    public void setTriple(OuterStruct value) {
        this.triple = value;
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
            if (this.hasTriple()) {
                yyBitVector[0] |= 2;
                final byte[] serialized = triple.serialize();
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

    public static TripleNested deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final TripleNested yyResultValue = new TripleNested();
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
                final OuterStruct deserialized = OuterStruct.yyDeserialize(yyIn, serializedLength);
                yyResultValue.setTriple(deserialized);
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

    static TripleNested yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {
        final TripleNested yyResultValue = new TripleNested();
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
            final OuterStruct deserialized = OuterStruct.yyDeserialize(petriReader, serializedLength);
            yyResultValue.setTriple(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 4) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setS(deserialized);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}