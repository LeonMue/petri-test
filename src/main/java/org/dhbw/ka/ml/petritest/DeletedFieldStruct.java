package org.dhbw.ka.ml.petritest;

import lombok.Data;
import lombok.ToString;

import java.io.*;

@ToString
public class DeletedFieldStruct {
    private int myInt32;
    private boolean hasMyInt32 = false;
    private String world;

    public int getMyInt32() {
        return this.myInt32;
    }

    public boolean hasMyInt32() {
        return this.hasMyInt32;
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
            if (this.hasWorld()) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(3);
                out.write(fieldNumber);
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(this.world, out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toByteArray();
    }

    public static DeletedFieldStruct deserialize(byte[] message) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        DeletedFieldStruct value = new DeletedFieldStruct();
        ByteArrayInputStream messageStream = new ByteArrayInputStream(message);
        try (DataInputStream in = new DataInputStream(messageStream)) {
            int fieldNumber;
            while (messageStream.available() > 0) {
                fieldNumber = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(in);
                switch (fieldNumber) {
                    case (0): {
                        int fieldValue = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(in);
                        value.setMyInt32(fieldValue);
                        break;
                    }
                    case (1): {
                        String fieldValue = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        break;
                    }
                    case (2): {
                        boolean fieldValue = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(in);
                        break;
                    }
                    case (3): {
                        String fieldValue = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(in);
                        value.setWorld(fieldValue);
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