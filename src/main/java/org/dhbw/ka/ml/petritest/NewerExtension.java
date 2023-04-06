package org.dhbw.ka.ml.petritest;

import lombok.Data;

import java.io.*;

@Data
public class NewerExtension {
    private long integer64;
    private boolean hasInteger64 = false;
    private String myString;
    private boolean isNewer;
    private boolean hasIsNewer = false;
    private String description;

    public long getInteger64() {
        return this.integer64;
    }

    public boolean hasInteger64() {
        return this.hasInteger64;
    }

    public String getMyString() {
        return this.myString;
    }

    public boolean hasMyString() {
        return this.myString != null;
    }

    public boolean getIsNewer() {
        return this.isNewer;
    }

    public boolean hasIsNewer() {
        return this.hasIsNewer;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean hasDescription() {
        return this.description != null;
    }

    public void setInteger64(long value) {
        this.hasInteger64 = true;
        this.integer64 = value;
    }

    public void setMyString(String value) {
        this.myString = value;
    }

    public void setIsNewer(boolean value) {
        this.hasIsNewer = true;
        this.isNewer = value;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public byte[] serialize() {
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        try (final DataOutputStream out = new DataOutputStream(result)) {
            byte[] fieldNumber;
            if (this.hasInteger64()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(0);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.serialize(this.integer64, out);
            }
            if (this.hasMyString()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(1);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(this.myString, out);
            }
            if (this.hasIsNewer()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(2);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.serialize(this.isNewer, out);
            }
            if (this.hasDescription()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(3);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(this.description, out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toByteArray();
    }

    public static NewerExtension deserialize(byte[] message) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        NewerExtension value = new NewerExtension();
        ByteArrayInputStream messageStream = new ByteArrayInputStream(message);
        try (DataInputStream in = new DataInputStream(messageStream)) {
            int fieldNumber;
            while (messageStream.available() > 0) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
                    case (0): {
                        final long deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.deserialize(in);
                        value.setInteger64(deserialized);
                        break;
                    }
                    case (1): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setMyString(deserialized);
                        break;
                    }
                    case (2): {
                        final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(in);
                        value.setIsNewer(deserialized);
                        break;
                    }
                    case (3): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setDescription(deserialized);
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

    static NewerExtension deserialize(org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput in, int length) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        NewerExtension value = new NewerExtension();
        try {
            int fieldNumber;
            while (in.getBytesWasRead() < length) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
                    case (0): {
                        final long deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.deserialize(in);
                        value.setInteger64(deserialized);
                        break;
                    }
                    case (1): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setMyString(deserialized);
                        break;
                    }
                    case (2): {
                        final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(in);
                        value.setIsNewer(deserialized);
                        break;
                    }
                    case (3): {
                        final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setDescription(deserialized);
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