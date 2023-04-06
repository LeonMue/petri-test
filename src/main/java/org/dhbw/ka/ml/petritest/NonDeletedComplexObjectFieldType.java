package org.dhbw.ka.ml.petritest;

import lombok.Data;

import java.io.*;

@Data
public class NonDeletedComplexObjectFieldType {
    private String myString1;
    private ComplexObjectFieldTypeDeletionDummy1 complex1;
    private ComplexObjectFieldTypeDeletionDummy1 complex2;
    private String myString2;

    public String getMyString1() {
        return this.myString1;
    }

    public boolean hasMyString1() {
        return this.myString1 != null;
    }

    public ComplexObjectFieldTypeDeletionDummy1 getComplex1() {
        return this.complex1;
    }

    public boolean hasComplex1() {
        return this.complex1 != null;
    }

    public ComplexObjectFieldTypeDeletionDummy1 getComplex2() {
        return this.complex2;
    }

    public boolean hasComplex2() {
        return this.complex2 != null;
    }

    public String getMyString2() {
        return this.myString2;
    }

    public boolean hasMyString2() {
        return this.myString2 != null;
    }

    public void setMyString1(String value) {
        this.myString1 = value;
    }

    public void setComplex1(ComplexObjectFieldTypeDeletionDummy1 value) {
        this.complex1 = value;
    }

    public void setComplex2(ComplexObjectFieldTypeDeletionDummy1 value) {
        this.complex2 = value;
    }

    public void setMyString2(String value) {
        this.myString2 = value;
    }

    public byte[] serialize() {
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        try (final DataOutputStream out = new DataOutputStream(result)) {
            byte[] fieldNumber;
            if (this.hasMyString1()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(0);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(this.myString1, out);
            }
            if (this.hasComplex1()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(1);
                out.write(fieldNumber);
                final byte[] serialized = this.complex1.serialize();
                out.write(serialized.length);
                out.write(serialized);
            }
            if (this.hasComplex2()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(2);
                out.write(fieldNumber);
                final byte[] serialized = this.complex2.serialize();
                out.write(serialized.length);
                out.write(serialized);
            }
            if (this.hasMyString2()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(3);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(this.myString2, out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toByteArray();
    }

    public static NonDeletedComplexObjectFieldType deserialize(byte[] message) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        NonDeletedComplexObjectFieldType value = new NonDeletedComplexObjectFieldType();
        ByteArrayInputStream messageStream = new ByteArrayInputStream(message);
        try (DataInputStream in = new DataInputStream(messageStream)) {
            int fieldNumber;
            while (messageStream.available() > 0) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
                    case (0): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setMyString1(deserialized);
                        break;
                    }
                    case (1): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                        final ComplexObjectFieldTypeDeletionDummy1 deserialized = ComplexObjectFieldTypeDeletionDummy1.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(in), serializedLength);
                        value.setComplex1(deserialized);
                        break;
                    }
                    case (2): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                        final ComplexObjectFieldTypeDeletionDummy1 deserialized = ComplexObjectFieldTypeDeletionDummy1.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(in), serializedLength);
                        value.setComplex2(deserialized);
                        break;
                    }
                    case (3): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setMyString2(deserialized);
                        break;
                    }
                    default: {
                        return value;
                    }
                }
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return value;
    }

    static NonDeletedComplexObjectFieldType deserialize(org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput readTrackingIn, int length) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        NonDeletedComplexObjectFieldType value = new NonDeletedComplexObjectFieldType();
        try {
            int fieldNumber;
            while (readTrackingIn.getBytesWasRead() < length) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                switch (fieldNumber) {
                    case (0): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(readTrackingIn);
                        value.setMyString1(deserialized);
                        break;
                    }
                    case (1): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                        final ComplexObjectFieldTypeDeletionDummy1 deserialized = ComplexObjectFieldTypeDeletionDummy1.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(readTrackingIn), serializedLength);
                        readTrackingIn.addToWasRead(serializedLength);
                        value.setComplex1(deserialized);
                        break;
                    }
                    case (2): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                        final ComplexObjectFieldTypeDeletionDummy1 deserialized = ComplexObjectFieldTypeDeletionDummy1.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(readTrackingIn), serializedLength);
                        readTrackingIn.addToWasRead(serializedLength);
                        value.setComplex2(deserialized);
                        break;
                    }
                    case (3): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(readTrackingIn);
                        value.setMyString2(deserialized);
                        break;
                    }
                    default: {
                        readTrackingIn.skipBytes(length - readTrackingIn.getBytesWasRead());
                        return value;
                    }
                }
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return value;
    }
}