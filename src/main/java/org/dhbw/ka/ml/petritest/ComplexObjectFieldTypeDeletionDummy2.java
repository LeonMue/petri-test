package org.dhbw.ka.ml.petritest;

import lombok.Data;

import java.io.*;

@Data
public class ComplexObjectFieldTypeDeletionDummy2 {
    public byte[] serialize() {
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        try (final DataOutputStream out = new DataOutputStream(result)) {
            byte[] fieldNumber;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toByteArray();
    }

    public static ComplexObjectFieldTypeDeletionDummy2 deserialize(byte[] message) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        ComplexObjectFieldTypeDeletionDummy2 value = new ComplexObjectFieldTypeDeletionDummy2();
        ByteArrayInputStream messageStream = new ByteArrayInputStream(message);
        try (DataInputStream in = new DataInputStream(messageStream)) {
            int fieldNumber;
            while (messageStream.available() > 0) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
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

    static ComplexObjectFieldTypeDeletionDummy2 deserialize(org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput readTrackingIn, int length) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        ComplexObjectFieldTypeDeletionDummy2 value = new ComplexObjectFieldTypeDeletionDummy2();
        try {
            int fieldNumber;
            while (readTrackingIn.getBytesWasRead() < length) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                switch (fieldNumber) {
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