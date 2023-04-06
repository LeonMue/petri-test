package org.dhbw.ka.ml.petritest;

import lombok.Data;

import java.io.*;

@Data
public class SimpleComplexObjectField2 {
    private boolean myBool;
    private boolean hasMyBool = false;
    private SimpleComplexObjectField1 complex;
    private int myInt;
    private boolean hasMyInt = false;

    public boolean getMyBool() {
        return this.myBool;
    }

    public boolean hasMyBool() {
        return this.hasMyBool;
    }

    public SimpleComplexObjectField1 getComplex() {
        return this.complex;
    }

    public boolean hasComplex() {
        return this.complex != null;
    }

    public int getMyInt() {
        return this.myInt;
    }

    public boolean hasMyInt() {
        return this.hasMyInt;
    }

    public void setMyBool(boolean value) {
        this.hasMyBool = true;
        this.myBool = value;
    }

    public void setComplex(SimpleComplexObjectField1 value) {
        this.complex = value;
    }

    public void setMyInt(int value) {
        this.hasMyInt = true;
        this.myInt = value;
    }

    public byte[] serialize() {
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        try (final DataOutputStream out = new DataOutputStream(result)) {
            byte[] fieldNumber;
            if (this.hasMyBool()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(0);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.serialize(this.myBool, out);
            }
            if (this.hasComplex()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(1);
                out.write(fieldNumber);
                final byte[] serialized = this.complex.serialize();
                out.write(serialized.length);
                out.write(serialized);
            }
            if (this.hasMyInt()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(2);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.serialize(this.myInt, out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toByteArray();
    }

    public static SimpleComplexObjectField2 deserialize(byte[] message) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        SimpleComplexObjectField2 value = new SimpleComplexObjectField2();
        ByteArrayInputStream messageStream = new ByteArrayInputStream(message);
        try (DataInputStream in = new DataInputStream(messageStream)) {
            int fieldNumber;
            while (messageStream.available() > 0) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
                    case (0): {
                        final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(in);
                        value.setMyBool(deserialized);
                        break;
                    }
                    case (1): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                        final SimpleComplexObjectField1 deserialized = SimpleComplexObjectField1.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(in), serializedLength);
                        value.setComplex(deserialized);
                        break;
                    }
                    case (2): {
                        final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(in);
                        value.setMyInt(deserialized);
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

    static SimpleComplexObjectField2 deserialize(org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput readTrackingIn, int length) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        SimpleComplexObjectField2 value = new SimpleComplexObjectField2();
        try {
            int fieldNumber;
            while (readTrackingIn.getBytesWasRead() < length) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                switch (fieldNumber) {
                    case (0): {
                        final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(readTrackingIn);
                        value.setMyBool(deserialized);
                        break;
                    }
                    case (1): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                        final SimpleComplexObjectField1 deserialized = SimpleComplexObjectField1.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(readTrackingIn), serializedLength);
                        readTrackingIn.addToWasRead(serializedLength);
                        value.setComplex(deserialized);
                        break;
                    }
                    case (2): {
                        final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(readTrackingIn);
                        value.setMyInt(deserialized);
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