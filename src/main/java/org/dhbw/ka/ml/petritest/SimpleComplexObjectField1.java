package org.dhbw.ka.ml.petritest;

import lombok.Data;

import java.io.*;

@Data
public class SimpleComplexObjectField1 {
    private String myString;
    private SimpleComplexObjectField3 complex;
    private boolean myBool;
    private boolean hasMyBool = false;

    public String getMyString() {
        return this.myString;
    }

    public boolean hasMyString() {
        return this.myString != null;
    }

    public SimpleComplexObjectField3 getComplex() {
        return this.complex;
    }

    public boolean hasComplex() {
        return this.complex != null;
    }

    public boolean getMyBool() {
        return this.myBool;
    }

    public boolean hasMyBool() {
        return this.hasMyBool;
    }

    public void setMyString(String value) {
        this.myString = value;
    }

    public void setComplex(SimpleComplexObjectField3 value) {
        this.complex = value;
    }

    public void setMyBool(boolean value) {
        this.hasMyBool = true;
        this.myBool = value;
    }

    public byte[] serialize() {
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        try (final DataOutputStream out = new DataOutputStream(result)) {
            byte[] fieldNumber;
            if (this.hasMyString()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(0);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(this.myString, out);
            }
            if (this.hasComplex()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(1);
                out.write(fieldNumber);
                final byte[] serialized = this.complex.serialize();
                out.write(serialized.length);
                out.write(serialized);
            }
            if (this.hasMyBool()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(2);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.serialize(this.myBool, out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toByteArray();
    }

    public static SimpleComplexObjectField1 deserialize(byte[] message) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        SimpleComplexObjectField1 value = new SimpleComplexObjectField1();
        ByteArrayInputStream messageStream = new ByteArrayInputStream(message);
        try (DataInputStream in = new DataInputStream(messageStream)) {
            int fieldNumber;
            while (messageStream.available() > 0) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
                    case (0): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setMyString(deserialized);
                        break;
                    }
                    case (1): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                        final SimpleComplexObjectField3 deserialized = SimpleComplexObjectField3.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(in), serializedLength);
                        value.setComplex(deserialized);
                        break;
                    }
                    case (2): {
                        final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(in);
                        value.setMyBool(deserialized);
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

    static SimpleComplexObjectField1 deserialize(org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput readTrackingIn, int length) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        SimpleComplexObjectField1 value = new SimpleComplexObjectField1();
        try {
            int fieldNumber;
            while (readTrackingIn.getBytesWasRead() < length) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                switch (fieldNumber) {
                    case (0): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(readTrackingIn);
                        value.setMyString(deserialized);
                        break;
                    }
                    case (1): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                        final SimpleComplexObjectField3 deserialized = SimpleComplexObjectField3.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(readTrackingIn), serializedLength);
                        readTrackingIn.addToWasRead(serializedLength);
                        value.setComplex(deserialized);
                        break;
                    }
                    case (2): {
                        final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(readTrackingIn);
                        value.setMyBool(deserialized);
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