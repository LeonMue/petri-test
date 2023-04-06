package org.dhbw.ka.ml.petritest;

import lombok.Data;

import java.io.*;

@Data
public class NonDeletedFieldStruct {
    private int myInt32;
    private boolean hasMyInt32 = false;
    private String hello;
    private boolean isNotDeleted;
    private boolean hasIsNotDeleted = false;
    private double myFloat64;
    private boolean hasMyFloat64 = false;
    private String world;

    public int getMyInt32() {
        return this.myInt32;
    }

    public boolean hasMyInt32() {
        return this.hasMyInt32;
    }

    public String getHello() {
        return this.hello;
    }

    public boolean hasHello() {
        return this.hello != null;
    }

    public boolean getIsNotDeleted() {
        return this.isNotDeleted;
    }

    public boolean hasIsNotDeleted() {
        return this.hasIsNotDeleted;
    }

    public double getMyFloat64() {
        return this.myFloat64;
    }

    public boolean hasMyFloat64() {
        return this.hasMyFloat64;
    }

    public String getWorld() {
        return this.world;
    }

    public boolean hasWorld() {
        return this.world != null;
    }

    public void setMyInt32(int value) {
        this.hasMyInt32 = true;
        this.myInt32 = value;
    }

    public void setHello(String value) {
        this.hello = value;
    }

    public void setIsNotDeleted(boolean value) {
        this.hasIsNotDeleted = true;
        this.isNotDeleted = value;
    }

    public void setMyFloat64(double value) {
        this.hasMyFloat64 = true;
        this.myFloat64 = value;
    }

    public void setWorld(String value) {
        this.world = value;
    }

    public byte[] serialize() {
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        try (final DataOutputStream out = new DataOutputStream(result)) {
            byte[] fieldNumber;
            if (this.hasMyInt32()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(0);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.serialize(this.myInt32, out);
            }
            if (this.hasHello()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(1);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(this.hello, out);
            }
            if (this.hasIsNotDeleted()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(2);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.serialize(this.isNotDeleted, out);
            }
            if (this.hasMyFloat64()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(3);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.serialize(this.myFloat64, out);
            }
            if (this.hasWorld()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(4);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(this.world, out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toByteArray();
    }

    public static NonDeletedFieldStruct deserialize(byte[] message) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        NonDeletedFieldStruct value = new NonDeletedFieldStruct();
        ByteArrayInputStream messageStream = new ByteArrayInputStream(message);
        try (DataInputStream in = new DataInputStream(messageStream)) {
            int fieldNumber;
            while (messageStream.available() > 0) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
                    case (0): {
                        final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(in);
                        value.setMyInt32(deserialized);
                        break;
                    }
                    case (1): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setHello(deserialized);
                        break;
                    }
                    case (2): {
                        final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(in);
                        value.setIsNotDeleted(deserialized);
                        break;
                    }
                    case (3): {
                        final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(in);
                        value.setMyFloat64(deserialized);
                        break;
                    }
                    case (4): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setWorld(deserialized);
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

    static NonDeletedFieldStruct deserialize(org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput in, int length) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        NonDeletedFieldStruct value = new NonDeletedFieldStruct();
        try {
            int fieldNumber;
            while (in.getBytesWasRead() < length) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
                    case (0): {
                        final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(in);
                        value.setMyInt32(deserialized);
                        break;
                    }
                    case (1): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setHello(deserialized);
                        break;
                    }
                    case (2): {
                        final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(in);
                        value.setIsNotDeleted(deserialized);
                        break;
                    }
                    case (3): {
                        final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(in);
                        value.setMyFloat64(deserialized);
                        break;
                    }
                    case (4): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setWorld(deserialized);
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