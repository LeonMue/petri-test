package org.dhbw.ka.ml.petritest.sd.lists.primitive.nonrecursive;

import lombok.EqualsAndHashCode;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

@EqualsAndHashCode
public class L {
    private List<Integer> l1;

    public List<Integer> getL1() {
        return this.l1;
    }

    public void setL1(List<Integer> value) {
        this.l1 = value;
    }

    public boolean hasL1() {
        return this.l1 != null;
    }

    private List<String> l2;

    public List<String> getL2() {
        return this.l2;
    }

    public void setL2(List<String> value) {
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
                for (Integer yyElement0 : l1) {
                    if (yyElement0 == null) {
                        throw new IllegalArgumentException("Elements of list must be not null");
                    }
                    org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.serialize(yyElement0, yyDataOutput);
                }
            }
            if (this.hasL2()) {
                yyBitVector[0] |= 2;
                yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(l2.size()));
                for (String yyElement0 : l2) {
                    if (yyElement0 == null) {
                        throw new IllegalArgumentException("Elements of list must be not null");
                    }
                    org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(yyElement0, yyDataOutput);
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
                final List<Integer> yyDeserializedList = new ArrayList<Integer>(yyListLength);
                for (int yyI = 0; yyI < yyListLength; yyI++) {
                    final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(yyIn);
                    yyDeserializedList.add(deserialized);
                }
                yyResultValue.setL1(yyDeserializedList);
            }
            if ((serialized[0] & 2) != 0) {
                final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                final List<String> yyDeserializedList = new ArrayList<String>(yyListLength);
                for (int yyI = 0; yyI < yyListLength; yyI++) {
                    final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                    yyDeserializedList.add(deserialized);
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
            final List<Integer> yyDeserializedList = new ArrayList<Integer>(yyListLength);
            for (int yyI = 0; yyI < yyListLength; yyI++) {
                final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(petriReader);
                yyDeserializedList.add(deserialized);
            }
            yyResultValue.setL1(yyDeserializedList);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 2) != 0) {
            final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
            final List<String> yyDeserializedList = new ArrayList<String>(yyListLength);
            for (int yyI = 0; yyI < yyListLength; yyI++) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
                yyDeserializedList.add(deserialized);
            }
            yyResultValue.setL2(yyDeserializedList);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}