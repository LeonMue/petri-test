package org.dhbw.ka.ml.petritest.empty.lists;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

@lombok.EqualsAndHashCode
public class L {
    private List<Empty> l1;

    public List<Empty> getL1() {
        return this.l1;
    }

    public void setL1(List<Empty> value) {
        this.l1 = value;
    }

    public boolean hasL1() {
        return this.l1 != null;
    }

    private List<List<Empty>> l2;

    public List<List<Empty>> getL2() {
        return this.l2;
    }

    public void setL2(List<List<Empty>> value) {
        this.l2 = value;
    }

    public boolean hasL2() {
        return this.l2 != null;
    }

    private List<List<List<Empty>>> l3;

    public List<List<List<Empty>>> getL3() {
        return this.l3;
    }

    public void setL3(List<List<List<Empty>>> value) {
        this.l3 = value;
    }

    public boolean hasL3() {
        return this.l3 != null;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[1];
        ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();
        try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {
            if (this.hasL1()) {
                yyBitVector[0] |= 1;
                yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(l1.size()));
                for (Empty yyElement0 : l1) {
                    if (yyElement0 == null) {
                        throw new IllegalArgumentException("Elements of list must be not null");
                    }
                    final byte[] serialized = yyElement0.serialize();
                    yyDataOutput.write(serialized.length);
                    yyDataOutput.write(serialized);
                }
            }
            if (this.hasL2()) {
                yyBitVector[0] |= 2;
                yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(l2.size()));
                for (List<Empty> yyElement0 : l2) {
                    if (yyElement0 == null) {
                        throw new IllegalArgumentException("Elements of list must be not null");
                    }
                    yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(yyElement0.size()));
                    for (Empty yyElement1 : yyElement0) {
                        if (yyElement1 == null) {
                            throw new IllegalArgumentException("Elements of list must be not null");
                        }
                        final byte[] serialized = yyElement1.serialize();
                        yyDataOutput.write(serialized.length);
                        yyDataOutput.write(serialized);
                    }
                }
            }
            if (this.hasL3()) {
                yyBitVector[0] |= 4;
                yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(l3.size()));
                for (List<List<Empty>> yyElement0 : l3) {
                    if (yyElement0 == null) {
                        throw new IllegalArgumentException("Elements of list must be not null");
                    }
                    yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(yyElement0.size()));
                    for (List<Empty> yyElement1 : yyElement0) {
                        if (yyElement1 == null) {
                            throw new IllegalArgumentException("Elements of list must be not null");
                        }
                        yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(yyElement1.size()));
                        for (Empty yyElement2 : yyElement1) {
                            if (yyElement2 == null) {
                                throw new IllegalArgumentException("Elements of list must be not null");
                            }
                            final byte[] serialized = yyElement2.serialize();
                            yyDataOutput.write(serialized.length);
                            yyDataOutput.write(serialized);
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
                final List<Empty> yyDeserializedList = new ArrayList<Empty>(yyListLength);
                for (int yyI = 0; yyI < yyListLength; yyI++) {
                    final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                    final Empty deserialized = Empty.yyDeserialize(yyIn, serializedLength);
                    yyDeserializedList.add(deserialized);
                }
                yyResultValue.setL1(yyDeserializedList);
            }
            if ((serialized[0] & 2) != 0) {
                final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                final List<List<Empty>> yyDeserializedList = new ArrayList<List<Empty>>(yyListLength);
                for (int yyI = 0; yyI < yyListLength; yyI++) {
                    final int yyListLength0 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                    final List<Empty> yyDeserializedList0 = new ArrayList<Empty>(yyListLength0);
                    yyDeserializedList.add(yyDeserializedList0);
                    for (int yyI0 = 0; yyI0 < yyListLength0; yyI0++) {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                        final Empty deserialized = Empty.yyDeserialize(yyIn, serializedLength);
                        yyDeserializedList0.add(deserialized);
                    }
                }
                yyResultValue.setL2(yyDeserializedList);
            }
            if ((serialized[0] & 4) != 0) {
                final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                final List<List<List<Empty>>> yyDeserializedList = new ArrayList<List<List<Empty>>>(yyListLength);
                for (int yyI = 0; yyI < yyListLength; yyI++) {
                    final int yyListLength0 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                    final List<List<Empty>> yyDeserializedList0 = new ArrayList<List<Empty>>(yyListLength0);
                    yyDeserializedList.add(yyDeserializedList0);
                    for (int yyI0 = 0; yyI0 < yyListLength0; yyI0++) {
                        final int yyListLength1 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                        final List<Empty> yyDeserializedList1 = new ArrayList<Empty>(yyListLength1);
                        yyDeserializedList0.add(yyDeserializedList1);
                        for (int yyI1 = 0; yyI1 < yyListLength1; yyI1++) {
                            final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                            final Empty deserialized = Empty.yyDeserialize(yyIn, serializedLength);
                            yyDeserializedList1.add(deserialized);
                        }
                    }
                }
                yyResultValue.setL3(yyDeserializedList);
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
            final List<Empty> yyDeserializedList = new ArrayList<Empty>(yyListLength);
            for (int yyI = 0; yyI < yyListLength; yyI++) {
                final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
                final Empty deserialized = Empty.yyDeserialize(petriReader, serializedLength);
                yyDeserializedList.add(deserialized);
            }
            yyResultValue.setL1(yyDeserializedList);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 2) != 0) {
            final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
            final List<List<Empty>> yyDeserializedList = new ArrayList<List<Empty>>(yyListLength);
            for (int yyI = 0; yyI < yyListLength; yyI++) {
                final int yyListLength0 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
                final List<Empty> yyDeserializedList0 = new ArrayList<Empty>(yyListLength0);
                yyDeserializedList.add(yyDeserializedList0);
                for (int yyI0 = 0; yyI0 < yyListLength0; yyI0++) {
                    final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
                    final Empty deserialized = Empty.yyDeserialize(petriReader, serializedLength);
                    yyDeserializedList0.add(deserialized);
                }
            }
            yyResultValue.setL2(yyDeserializedList);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 4) != 0) {
            final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
            final List<List<List<Empty>>> yyDeserializedList = new ArrayList<List<List<Empty>>>(yyListLength);
            for (int yyI = 0; yyI < yyListLength; yyI++) {
                final int yyListLength0 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
                final List<List<Empty>> yyDeserializedList0 = new ArrayList<List<Empty>>(yyListLength0);
                yyDeserializedList.add(yyDeserializedList0);
                for (int yyI0 = 0; yyI0 < yyListLength0; yyI0++) {
                    final int yyListLength1 = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
                    final List<Empty> yyDeserializedList1 = new ArrayList<Empty>(yyListLength1);
                    yyDeserializedList0.add(yyDeserializedList1);
                    for (int yyI1 = 0; yyI1 < yyListLength1; yyI1++) {
                        final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
                        final Empty deserialized = Empty.yyDeserialize(petriReader, serializedLength);
                        yyDeserializedList1.add(deserialized);
                    }
                }
            }
            yyResultValue.setL3(yyDeserializedList);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}