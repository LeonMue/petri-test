package org.dhbw.ka.ml.petritest.extension.complex;

import java.io.*;

public class NewerParentObject {
    private NewerInnerObject newer;

    public NewerInnerObject getNewer() {
        return this.newer;
    }

    public boolean hasNewer() {
        return this.newer != null;
    }

    public void setNewer(NewerInnerObject value) {
        this.newer = value;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[1];
        ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();
        try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {
            if (this.hasNewer()) {
                yyBitVector[0] |= 1;
                final byte[] serialized = newer.serialize();
                yyDataOutput.write(serialized.length);
                yyDataOutput.write(serialized);
            }
            ByteArrayOutputStream yyResult = new ByteArrayOutputStream();
            yyResult.writeBytes(yyBitVector);
            yySerializedFields.writeTo(yyResult);
            return yyResult.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("This should not happen...", e);
        }
    }

    public static NewerParentObject deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final NewerParentObject yyResultValue = new NewerParentObject();
        try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {
            int yyLengthOfBitVector = 1;
            while ((yyIn.readByte() & 0x80) != 0) {
                yyLengthOfBitVector++;
            }
            if ((serialized[0] & 1) != 0) {
                final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                final NewerInnerObject deserialized = NewerInnerObject.yyDeserialize(yyIn, serializedLength);
                yyResultValue.setNewer(deserialized);
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return yyResultValue;
    }

    static NewerParentObject yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {
        final NewerParentObject yyResultValue = new NewerParentObject();
        final int yyBeginOffset = petriReader.getOffset();
        int yyLengthOfBitVector = 1;
        while ((petriReader.readByte() & 0x80) != 0) {
            yyLengthOfBitVector++;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {
            final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
            final NewerInnerObject deserialized = NewerInnerObject.yyDeserialize(petriReader, serializedLength);
            yyResultValue.setNewer(deserialized);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}