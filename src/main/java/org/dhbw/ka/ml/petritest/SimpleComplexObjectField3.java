package org.dhbw.ka.ml.petritest;

import lombok.Data;

import java.io.*;

@Data
public class SimpleComplexObjectField3 {
    private boolean myBool;
    private boolean hasMyBool = false;
    private float myFloat;
    private boolean hasMyFloat = false;

    public boolean getMyBool() {
        return this.myBool;
    }

    public boolean hasMyBool() {
        return this.hasMyBool;
    }

    public float getMyFloat() {
        return this.myFloat;
    }

    public boolean hasMyFloat() {
        return this.hasMyFloat;
    }

    public void setMyBool(boolean value) {
        this.hasMyBool = true;
        this.myBool = value;
    }

    public void setMyFloat(float value) {
        this.hasMyFloat = true;
        this.myFloat = value;
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
            if (this.hasMyFloat()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(1);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.serialize(this.myFloat, out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toByteArray();
    }

    public static SimpleComplexObjectField3 deserialize(byte[] message) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        SimpleComplexObjectField3 value = new SimpleComplexObjectField3();
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
                        final float deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.deserialize(in);
                        value.setMyFloat(deserialized);
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

    static SimpleComplexObjectField3 deserialize(org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput readTrackingIn, int length) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        SimpleComplexObjectField3 value = new SimpleComplexObjectField3();
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
                        final float deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.deserialize(readTrackingIn);
                        value.setMyFloat(deserialized);
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