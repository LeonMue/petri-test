package org.dhbw.ka.ml.petritest;

import lombok.Data;

import java.io.*;

@Data
public class DeletedComplexObjectFieldType {
    private ComplexObjectFieldTypeDeletionDummy1 complex2;

    public ComplexObjectFieldTypeDeletionDummy1 getComplex2() {
        return this.complex2;
    }

    public boolean hasComplex2() {
        return this.complex2 != null;
    }

    public void setComplex2(ComplexObjectFieldTypeDeletionDummy1 value) {
        this.complex2 = value;
    }

    public byte[] serialize() {
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        try (final DataOutputStream out = new DataOutputStream(result)) {
            byte[] fieldNumber;
            if (this.hasComplex2()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(2);
                out.write(fieldNumber);
                final byte[] serialized = this.complex2.serialize();
                out.write(serialized.length);
                out.write(serialized);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toByteArray();
    }

    public static DeletedComplexObjectFieldType deserialize(byte[] message) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        DeletedComplexObjectFieldType value = new DeletedComplexObjectFieldType();
        ByteArrayInputStream messageStream = new ByteArrayInputStream(message);
        try (DataInputStream in = new DataInputStream(messageStream)) {
            int fieldNumber;
            while (messageStream.available() > 0) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
                    case (0): {
                        org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.skip(in);
                        break;
                    }
                    case (1): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                        in.skipBytes(serializedLength);
                        break;
                    }
                    case (2): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                        final ComplexObjectFieldTypeDeletionDummy1 deserialized = ComplexObjectFieldTypeDeletionDummy1.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(in), serializedLength);
                        value.setComplex2(deserialized);
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

    static DeletedComplexObjectFieldType deserialize(org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput readTrackingIn, int length) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        DeletedComplexObjectFieldType value = new DeletedComplexObjectFieldType();
        try {
            int fieldNumber;
            while (readTrackingIn.getBytesWasRead() < length) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                switch (fieldNumber) {
                    case (0): {
                        org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.skip(readTrackingIn);
                        break;
                    }
                    case (1): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                        readTrackingIn.skipBytes(serializedLength);
                        break;
                    }
                    case (2): {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(readTrackingIn);
                        final ComplexObjectFieldTypeDeletionDummy1 deserialized = ComplexObjectFieldTypeDeletionDummy1.deserialize(new org.dhbw.ka.ml.petrilib.io.ReadTrackingDataInput(readTrackingIn), serializedLength);
                        readTrackingIn.addToWasRead(serializedLength);
                        value.setComplex2(deserialized);
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