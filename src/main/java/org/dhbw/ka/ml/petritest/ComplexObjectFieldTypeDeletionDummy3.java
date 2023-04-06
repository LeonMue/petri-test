package org.dhbw.ka.ml.petritest;

import lombok.Data;

import java.io.*;

@Data
public class ComplexObjectFieldTypeDeletionDummy3 {
    private boolean myBool;
    private boolean hasMyBool = false;

    public boolean getMyBool() {
        return this.myBool;
    }

    public boolean hasMyBool() {
        return this.hasMyBool;
    }

    public void setMyBool(boolean value) {
        this.hasMyBool = true;
        this.myBool = value;
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toByteArray();
    }

    public static ComplexObjectFieldTypeDeletionDummy3 deserialize(byte[] message) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        ComplexObjectFieldTypeDeletionDummy3 value = new ComplexObjectFieldTypeDeletionDummy3();
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

    static ComplexObjectFieldTypeDeletionDummy3 deserialize(org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput readTrackingIn, int length) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        ComplexObjectFieldTypeDeletionDummy3 value = new ComplexObjectFieldTypeDeletionDummy3();
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