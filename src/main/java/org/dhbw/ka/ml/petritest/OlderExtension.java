package org.dhbw.ka.ml.petritest;

import lombok.Data;

import java.io.*;

@Data
public class OlderExtension {
    private long integer64;
    private boolean hasInteger64 = false;
    private String myString;

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

    public void setInteger64(long value) {
        this.hasInteger64 = true;
        this.integer64 = value;
    }

    public void setMyString(String value) {
        this.myString = value;
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toByteArray();
    }

    public static OlderExtension deserialize(byte[] message) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        OlderExtension value = new OlderExtension();
        ByteArrayInputStream messageStream = new ByteArrayInputStream(message);
        try (DataInputStream in = new DataInputStream(messageStream)) {
            int fieldNumber;
            while (messageStream.available() > 0) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
                    case (0): {
                        value.setInteger64(org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.deserialize(in));
                        break;
                    }
                    case (1): {
                        value.setMyString(org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in));
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
}