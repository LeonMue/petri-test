package org.dhbw.ka.ml.petritest.sd.lists.complex.recursive;

import lombok.EqualsAndHashCode;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

@EqualsAndHashCode
public class L {
    private List<List<T>> l;

    public List<List<T>> getL() {
        return this.l;
    }

    public void setL(List<List<T>> value) {
        this.l = value;
    }

    public boolean hasL() {
        return this.l != null;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[1];
        ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();
        try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {
            if (this.hasL()) {
                yyBitVector[0] |= 1;
                yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(l.size()));
                for (List<T> yyElement0 : l) {
                    if (yyElement0 == null) {
                        throw new IllegalArgumentException("Elements of list must be not null");
                    }
                    yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(yyElement0.size()));
                    for (T yyElement1 : yyElement0) {
                        if (yyElement1 == null) {
                            throw new IllegalArgumentException("Elements of list must be not null");
                        }
                        final byte[] serialized = yyElement1.serialize();
                        yyDataOutput.write(serialized.length);
                        yyDataOutput.write(serialized);
                    }
                }
            }
            ByteArrayOutputStream yyResult = new ByteArrayOutputStream();
            yyResult.writeBytes(yyBitVector);
            yySerializedFields.writeTo(yyResult);
            return yyResult.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("This should not happen...", e);
        }
    }

    public static L deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final L yyResultValue = new L();
        try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {
            int yyLengthOfBitVector = 1;
            while ((yyIn.readByte() & 0x80) != 0) {
                yyLengthOfBitVector++;
            }
            if ((serialized[0] & 1) != 0) {
                final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                final List<List<T>> yyDeserializedList = new ArrayList<List<T>>(yyListLength);
                for (int yyI = 0; yyI < yyListLength; yyI++) {
                    final int yyListLength0 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                    final List<T> yyDeserializedList0 = new ArrayList<T>(yyListLength0);
                    yyDeserializedList.add(yyDeserializedList0);
                    for (int yyI0 = 0; yyI0 < yyListLength0; yyI0++) {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                        final T deserialized = T.yyDeserialize(yyIn, serializedLength);
                        yyDeserializedList0.add(deserialized);
                    }
                }
                yyResultValue.setL(yyDeserializedList);
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return yyResultValue;
    }

    static L yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {
        final L yyResultValue = new L();
        final int yyBeginOffset = petriReader.getOffset();
        int yyLengthOfBitVector = 1;
        while ((petriReader.readByte() & 0x80) != 0) {
            yyLengthOfBitVector++;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {
            final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
            final List<List<T>> yyDeserializedList = new ArrayList<List<T>>(yyListLength);
            for (int yyI = 0; yyI < yyListLength; yyI++) {
                final int yyListLength0 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
                final List<T> yyDeserializedList0 = new ArrayList<T>(yyListLength0);
                yyDeserializedList.add(yyDeserializedList0);
                for (int yyI0 = 0; yyI0 < yyListLength0; yyI0++) {
                    final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
                    final T deserialized = T.yyDeserialize(petriReader, serializedLength);
                    yyDeserializedList0.add(deserialized);
                }
            }
            yyResultValue.setL(yyDeserializedList);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}