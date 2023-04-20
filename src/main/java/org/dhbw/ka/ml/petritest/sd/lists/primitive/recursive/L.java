package org.dhbw.ka.ml.petritest.sd.lists.primitive.recursive;

import lombok.EqualsAndHashCode;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

@EqualsAndHashCode
public class L {
    private List<List<Boolean>> l1;

    public List<List<Boolean>> getL1() {
        return this.l1;
    }

    public void setL1(List<List<Boolean>> value) {
        this.l1 = value;
    }

    public boolean hasL1() {
        return this.l1 != null;
    }

    private List<List<List<Double>>> l2;

    public List<List<List<Double>>> getL2() {
        return this.l2;
    }

    public void setL2(List<List<List<Double>>> value) {
        this.l2 = value;
    }

    public boolean hasL2() {
        return this.l2 != null;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[1];
        ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();
        try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {
            if (this.hasL1()) {
                yyBitVector[0] |= 1;
                yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(l1.size()));
                for (List<Boolean> yyElement0 : l1) {
                    if (yyElement0 == null) {
                        throw new IllegalArgumentException("Elements of list must be not null");
                    }
                    yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(yyElement0.size()));
                    for (Boolean yyElement1 : yyElement0) {
                        if (yyElement1 == null) {
                            throw new IllegalArgumentException("Elements of list must be not null");
                        }
                        org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.serialize(yyElement1, yyDataOutput);
                    }
                }
            }
            if (this.hasL2()) {
                yyBitVector[0] |= 2;
                yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(l2.size()));
                for (List<List<Double>> yyElement0 : l2) {
                    if (yyElement0 == null) {
                        throw new IllegalArgumentException("Elements of list must be not null");
                    }
                    yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(yyElement0.size()));
                    for (List<Double> yyElement1 : yyElement0) {
                        if (yyElement1 == null) {
                            throw new IllegalArgumentException("Elements of list must be not null");
                        }
                        yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(yyElement1.size()));
                        for (Double yyElement2 : yyElement1) {
                            if (yyElement2 == null) {
                                throw new IllegalArgumentException("Elements of list must be not null");
                            }
                            org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.serialize(yyElement2, yyDataOutput);
                        }
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
                final List<List<Boolean>> yyDeserializedList = new ArrayList<List<Boolean>>(yyListLength);
                for (int yyI = 0; yyI < yyListLength; yyI++) {
                    final int yyListLength0 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                    final List<Boolean> yyDeserializedList0 = new ArrayList<Boolean>(yyListLength0);
                    yyDeserializedList.add(yyDeserializedList0);
                    for (int yyI0 = 0; yyI0 < yyListLength0; yyI0++) {
                        final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(yyIn);
                        yyDeserializedList0.add(deserialized);
                    }
                }
                yyResultValue.setL1(yyDeserializedList);
            }
            if ((serialized[0] & 2) != 0) {
                final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                final List<List<List<Double>>> yyDeserializedList = new ArrayList<List<List<Double>>>(yyListLength);
                for (int yyI = 0; yyI < yyListLength; yyI++) {
                    final int yyListLength0 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                    final List<List<Double>> yyDeserializedList0 = new ArrayList<List<Double>>(yyListLength0);
                    yyDeserializedList.add(yyDeserializedList0);
                    for (int yyI0 = 0; yyI0 < yyListLength0; yyI0++) {
                        final int yyListLength1 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                        final List<Double> yyDeserializedList1 = new ArrayList<Double>(yyListLength1);
                        yyDeserializedList0.add(yyDeserializedList1);
                        for (int yyI1 = 0; yyI1 < yyListLength1; yyI1++) {
                            final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(yyIn);
                            yyDeserializedList1.add(deserialized);
                        }
                    }
                }
                yyResultValue.setL2(yyDeserializedList);
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
            final List<List<Boolean>> yyDeserializedList = new ArrayList<List<Boolean>>(yyListLength);
            for (int yyI = 0; yyI < yyListLength; yyI++) {
                final int yyListLength0 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
                final List<Boolean> yyDeserializedList0 = new ArrayList<Boolean>(yyListLength0);
                yyDeserializedList.add(yyDeserializedList0);
                for (int yyI0 = 0; yyI0 < yyListLength0; yyI0++) {
                    final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(petriReader);
                    yyDeserializedList0.add(deserialized);
                }
            }
            yyResultValue.setL1(yyDeserializedList);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 2) != 0) {
            final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
            final List<List<List<Double>>> yyDeserializedList = new ArrayList<List<List<Double>>>(yyListLength);
            for (int yyI = 0; yyI < yyListLength; yyI++) {
                final int yyListLength0 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
                final List<List<Double>> yyDeserializedList0 = new ArrayList<List<Double>>(yyListLength0);
                yyDeserializedList.add(yyDeserializedList0);
                for (int yyI0 = 0; yyI0 < yyListLength0; yyI0++) {
                    final int yyListLength1 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
                    final List<Double> yyDeserializedList1 = new ArrayList<Double>(yyListLength1);
                    yyDeserializedList0.add(yyDeserializedList1);
                    for (int yyI1 = 0; yyI1 < yyListLength1; yyI1++) {
                        final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(petriReader);
                        yyDeserializedList1.add(deserialized);
                    }
                }
            }
            yyResultValue.setL2(yyDeserializedList);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}