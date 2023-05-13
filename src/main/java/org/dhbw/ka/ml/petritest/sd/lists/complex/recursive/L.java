package org.dhbw.ka.ml.petritest.sd.lists.complex.recursive;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

@lombok.EqualsAndHashCode
@lombok.ToString
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
        try (final org.dhbw.ka.ml.petrilib.io.PetriWriter yyDataOutput = new org.dhbw.ka.ml.petrilib.io.PetriWriter()) {
            if (this.hasL()) {
                yyBitVector[0] |= 1;
                org.dhbw.ka.ml.petrilib.io.PetriWriter yySerializedList0 = new org.dhbw.ka.ml.petrilib.io.PetriWriter();
                for (List<T> yyElement0 : l) {
                    if (yyElement0 == null) {
                        throw new IllegalArgumentException("Elements of list must be not null");
                    }
                    org.dhbw.ka.ml.petrilib.io.PetriWriter yySerializedList1 = new org.dhbw.ka.ml.petrilib.io.PetriWriter();
                    for (T yyElement1 : yyElement0) {
                        if (yyElement1 == null) {
                            throw new IllegalArgumentException("Elements of list must be not null");
                        }
                        final byte[] serialized = yyElement1.serialize();
                        yySerializedList1.writeInt(serialized.length);
                        yySerializedList1.write(serialized);
                    }
                    yySerializedList0.writeInt(yySerializedList1.size());
                    yySerializedList1.writeTo(yySerializedList0);
                }
                yyDataOutput.writeInt(yySerializedList0.size());
                yySerializedList0.writeTo(yyDataOutput);
            }
            org.dhbw.ka.ml.petrilib.io.PetriWriter yyResult = new org.dhbw.ka.ml.petrilib.io.PetriWriter();
            yyResult.writeBytes(yyBitVector);
            yyDataOutput.writeTo(yyResult);
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
                final int yyListLength = yyIn.readInt();
                final List<List<T>> yyDeserializedList = new ArrayList<List<T>>(yyListLength);
                final int beginningOffset = yyIn.getOffset();
                while (yyIn.getOffset() < beginningOffset + yyListLength) {
                    final int yyListLength0 = yyIn.readInt();
                    final List<T> yyDeserializedList0 = new ArrayList<T>();
                    yyDeserializedList.add(yyDeserializedList0);
                    final int yyBeginningOffset0 = yyIn.getOffset();
                    while (yyIn.getOffset() < yyBeginningOffset0 + yyListLength0) {
                        final int serializedLength = yyIn.readInt();
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
            final int yyListLength = petriReader.readInt();
            final List<List<T>> yyDeserializedList = new ArrayList<List<T>>(yyListLength);
            final int beginningOffset = petriReader.getOffset();
            while (petriReader.getOffset() < beginningOffset + yyListLength) {
                final int yyListLength0 = petriReader.readInt();
                final List<T> yyDeserializedList0 = new ArrayList<T>();
                yyDeserializedList.add(yyDeserializedList0);
                final int yyBeginningOffset0 = petriReader.getOffset();
                while (petriReader.getOffset() < yyBeginningOffset0 + yyListLength0) {
                    final int serializedLength = petriReader.readInt();
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