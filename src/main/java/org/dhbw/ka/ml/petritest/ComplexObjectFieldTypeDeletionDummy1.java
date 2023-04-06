package org.dhbw.ka.ml.petritest;

import lombok.Data;

import java.io.*;

@Data
public class ComplexObjectFieldTypeDeletionDummy1 {
    private int myInt;
    private boolean hasMyInt = false;
    private String myString;
    private ComplexObjectFieldTypeDeletionDummy2 complex2;
    private ComplexObjectFieldTypeDeletionDummy3 complex3;

    public int getMyInt() {
        return this.myInt;
    }

    public boolean hasMyInt() {
        return this.hasMyInt;
    }

    public String getMyString() {
        return this.myString;
    }

    public boolean hasMyString() {
        return this.myString != null;
    }

    public ComplexObjectFieldTypeDeletionDummy2 getComplex2() {
        return this.complex2;
    }

    public boolean hasComplex2() {
        return this.complex2 != null;
    }

    public ComplexObjectFieldTypeDeletionDummy3 getComplex3() {
        return this.complex3;
    }

    public boolean hasComplex3() {
        return this.complex3 != null;
    }

    public void setMyInt(int value) {
        this.hasMyInt = true;
        this.myInt = value;
    }

    public void setMyString(String value) {
        this.myString = value;
    }

    public void setComplex2(ComplexObjectFieldTypeDeletionDummy2 value) {
        this.complex2 = value;
    }

    public void setComplex3(ComplexObjectFieldTypeDeletionDummy3 value) {
        this.complex3 = value;
    }

    public byte[] serialize() {
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        try (final DataOutputStream out = new DataOutputStream(result)) {
            byte[] fieldNumber;
            if (this.hasMyInt()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(0);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.serialize(this.myInt, out);
            }
            if (this.hasMyString()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(1);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(this.myString, out);
            }
            if (this.hasComplex2()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(2);
                out.write(fieldNumber);
                final byte[] serialized = this.complex2.serialize();
                out.write(serialized.length);
                out.write(serialized);
            }
            if (this.hasComplex3()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(3);
                out.write(fieldNumber);
                final byte[] serialized = this.complex3.serialize();
                out.write(serialized.length);
                out.write(serialized);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toByteArray();
    }

    public static ComplexObjectFieldTypeDeletionDummy1 deserialize(byte[] message) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        ComplexObjectFieldTypeDeletionDummy1 value = new ComplexObjectFieldTypeDeletionDummy1();
        ByteArrayInputStream messageStream = new ByteArrayInputStream(message);
        try (DataInputStream in = new DataInputStream(messageStream)) {
            int fieldNumber;
            while (messageStream.available() > 0) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
                    case (0): {
                        final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(in);
                        value.setMyInt(deserialized);
                        break;
                    }
                    case (1): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setMyString(deserialized);
                        break;
                    }
                    case (2): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                        final ComplexObjectFieldTypeDeletionDummy2 deserialized = ComplexObjectFieldTypeDeletionDummy2.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(in), serializedLength);
                        value.setComplex2(deserialized);
                        break;
                    }
                    case (3): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                        final ComplexObjectFieldTypeDeletionDummy3 deserialized = ComplexObjectFieldTypeDeletionDummy3.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(in), serializedLength);
                        value.setComplex3(deserialized);
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

    static ComplexObjectFieldTypeDeletionDummy1 deserialize(org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput readTrackingIn, int length) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        ComplexObjectFieldTypeDeletionDummy1 value = new ComplexObjectFieldTypeDeletionDummy1();
        try {
            int fieldNumber;
            while (readTrackingIn.getBytesWasRead() < length) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                switch (fieldNumber) {
                    case (0): {
                        final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(readTrackingIn);
                        value.setMyInt(deserialized);
                        break;
                    }
                    case (1): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(readTrackingIn);
                        value.setMyString(deserialized);
                        break;
                    }
                    case (2): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                        final ComplexObjectFieldTypeDeletionDummy2 deserialized = ComplexObjectFieldTypeDeletionDummy2.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(readTrackingIn), serializedLength);
                        readTrackingIn.addToWasRead(serializedLength);
                        value.setComplex2(deserialized);
                        break;
                    }
                    case (3): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                        final ComplexObjectFieldTypeDeletionDummy3 deserialized = ComplexObjectFieldTypeDeletionDummy3.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(readTrackingIn), serializedLength);
                        readTrackingIn.addToWasRead(serializedLength);
                        value.setComplex3(deserialized);
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