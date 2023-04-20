package org.dhbw.ka.ml.petritest.sd.lists.complex.recursive;

import lombok.EqualsAndHashCode;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

@EqualsAndHashCode
public class T {
    private List<String> l;

    public List<String> getL() {
        return this.l;
    }

    public void setL(List<String> value) {
        this.l = value;
    }

    public boolean hasL() {
        return this.l != null;
    }

    private boolean b;
    private boolean hasB;

    public boolean getB() {
        return this.b;
    }

    public void setB(boolean value) {
        this.hasB = true;
        this.b = value;
    }

    public boolean hasB() {
        return this.hasB;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[1];
        ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();
        try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {
            if (this.hasL()) {
                yyBitVector[0] |= 1;
                yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(l.size()));
                for (String yyElement0 : l) {
                    if (yyElement0 == null) {
                        throw new IllegalArgumentException("Elements of list must be not null");
                    }
                    org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(yyElement0, yyDataOutput);
                }
            }
            if (this.hasB()) {
                yyBitVector[0] |= 2;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.serialize(b, yyDataOutput);
            }
            ByteArrayOutputStream yyResult = new ByteArrayOutputStream();
            yyResult.writeBytes(yyBitVector);
            yySerializedFields.writeTo(yyResult);
            return yyResult.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("This should not happen...", e);
        }
    }

    public static T deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final T yyResultValue = new T();
        try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {
            int yyLengthOfBitVector = 1;
            while ((yyIn.readByte() & 0x80) != 0) {
                yyLengthOfBitVector++;
            }
            if ((serialized[0] & 1) != 0) {
                final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                final List<String> yyDeserializedList = new ArrayList<String>(yyListLength);
                for (int yyI = 0; yyI < yyListLength; yyI++) {
                    final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                    yyDeserializedList.add(deserialized);
                }
                yyResultValue.setL(yyDeserializedList);
            }
            if ((serialized[0] & 2) != 0) {
                final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(yyIn);
                yyResultValue.setB(deserialized);
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return yyResultValue;
    }

    static T yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {
        final T yyResultValue = new T();
        final int yyBeginOffset = petriReader.getOffset();
        int yyLengthOfBitVector = 1;
        while ((petriReader.readByte() & 0x80) != 0) {
            yyLengthOfBitVector++;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {
            final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
            final List<String> yyDeserializedList = new ArrayList<String>(yyListLength);
            for (int yyI = 0; yyI < yyListLength; yyI++) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
                yyDeserializedList.add(deserialized);
            }
            yyResultValue.setL(yyDeserializedList);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 2) != 0) {
            final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(petriReader);
            yyResultValue.setB(deserialized);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}