package org.dhbw.ka.ml.petritest;

import lombok.Data;

import java.io.*;

@Data
public class MyTestStruct {
    private String string1;
    private int int1;
    private boolean hasInt1 = false;
    private long long2;
    private boolean hasLong2 = false;
    private float float1;
    private boolean hasFloat1 = false;
    private double double1;
    private boolean hasDouble1 = false;
    private boolean bool1;
    private boolean hasBool1 = false;

    public String getString1() {
        return this.string1;
    }

    public boolean hasString1() {
        return this.string1 != null;
    }

    public int getInt1() {
        return this.int1;
    }

    public boolean hasInt1() {
        return this.hasInt1;
    }

    public long getLong2() {
        return this.long2;
    }

    public boolean hasLong2() {
        return this.hasLong2;
    }

    public float getFloat1() {
        return this.float1;
    }

    public boolean hasFloat1() {
        return this.hasFloat1;
    }

    public double getDouble1() {
        return this.double1;
    }

    public boolean hasDouble1() {
        return this.hasDouble1;
    }

    public boolean getBool1() {
        return this.bool1;
    }

    public boolean hasBool1() {
        return this.hasBool1;
    }

    public void setString1(String value) {
        this.string1 = value;
    }

    public void setInt1(int value) {
        this.hasInt1 = true;
        this.int1 = value;
    }

    public void setLong2(long value) {
        this.hasLong2 = true;
        this.long2 = value;
    }

    public void setFloat1(float value) {
        this.hasFloat1 = true;
        this.float1 = value;
    }

    public void setDouble1(double value) {
        this.hasDouble1 = true;
        this.double1 = value;
    }

    public void setBool1(boolean value) {
        this.hasBool1 = true;
        this.bool1 = value;
    }

    public byte[] serialize() {
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        try (final DataOutputStream out = new DataOutputStream(result)) {
            byte[] fieldNumber;
            if (this.hasString1()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(0);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(this.string1, out);
            }
            if (this.hasInt1()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(1);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.serialize(this.int1, out);
            }
            if (this.hasLong2()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(2);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.serialize(this.long2, out);
            }
            if (this.hasFloat1()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(3);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.serialize(this.float1, out);
            }
            if (this.hasDouble1()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(4);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.serialize(this.double1, out);
            }
            if (this.hasBool1()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(5);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.serialize(this.bool1, out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toByteArray();
    }

    public static MyTestStruct deserialize(byte[] message) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        MyTestStruct value = new MyTestStruct();
        ByteArrayInputStream messageStream = new ByteArrayInputStream(message);
        try (DataInputStream in = new DataInputStream(messageStream)) {
            int fieldNumber;
            while (messageStream.available() > 0) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
                    case (0): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setString1(deserialized);
                        break;
                    }
                    case (1): {
                        final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(in);
                        value.setInt1(deserialized);
                        break;
                    }
                    case (2): {
                        final long deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.deserialize(in);
                        value.setLong2(deserialized);
                        break;
                    }
                    case (3): {
                        final float deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.deserialize(in);
                        value.setFloat1(deserialized);
                        break;
                    }
                    case (4): {
                        final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(in);
                        value.setDouble1(deserialized);
                        break;
                    }
                    case (5): {
                        final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(in);
                        value.setBool1(deserialized);
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

    static MyTestStruct deserialize(org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput in, int length) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        MyTestStruct value = new MyTestStruct();
        try {
            int fieldNumber;
            while (in.getBytesWasRead() < length) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
                    case (0): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setString1(deserialized);
                        break;
                    }
                    case (1): {
                        final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(in);
                        value.setInt1(deserialized);
                        break;
                    }
                    case (2): {
                        final long deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.deserialize(in);
                        value.setLong2(deserialized);
                        break;
                    }
                    case (3): {
                        final float deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.deserialize(in);
                        value.setFloat1(deserialized);
                        break;
                    }
                    case (4): {
                        final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(in);
                        value.setDouble1(deserialized);
                        break;
                    }
                    case (5): {
                        final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(in);
                        value.setBool1(deserialized);
                        break;
                    }
                    default: {
                        in.skipBytes(length - in.getBytesWasRead());
                    }
                }
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return value;
    }
}