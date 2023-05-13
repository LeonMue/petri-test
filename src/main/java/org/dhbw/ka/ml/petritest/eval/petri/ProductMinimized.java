package org.dhbw.ka.ml.petritest.eval.petri;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

@lombok.EqualsAndHashCode
@lombok.ToString
public class ProductMinimized {
    private int amount;
    private boolean hasAmount;

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int value) {
        this.hasAmount = true;
        this.amount = value;
    }

    public boolean hasAmount() {
        return this.hasAmount;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[1];
        try (final org.dhbw.ka.ml.petrilib.io.PetriWriter yyDataOutput = new org.dhbw.ka.ml.petrilib.io.PetriWriter()) {
            if (this.hasAmount()) {
                yyBitVector[0] |= 8;
                yyDataOutput.writeInt(amount);
            }
            org.dhbw.ka.ml.petrilib.io.PetriWriter yyResult = new org.dhbw.ka.ml.petrilib.io.PetriWriter();
            yyResult.writeBytes(yyBitVector);
            yyDataOutput.writeTo(yyResult);
            return yyResult.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("This should not happen...", e);
        }
    }

    public static ProductMinimized deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final ProductMinimized yyResultValue = new ProductMinimized();
        try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {
            int yyLengthOfBitVector = 1;
            while ((yyIn.readByte() & 0x80) != 0) {
                yyLengthOfBitVector++;
            }
            if ((serialized[0] & 1) != 0) {
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.skip(yyIn);
            }
            if ((serialized[0] & 2) != 0) {
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.skip(yyIn);
            }
            if ((serialized[0] & 4) != 0) {
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.skip(yyIn);
            }
            if ((serialized[0] & 8) != 0) {
                final int deserialized = yyIn.readInt();
                yyResultValue.setAmount(deserialized);
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return yyResultValue;
    }

    static ProductMinimized yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {
        final ProductMinimized yyResultValue = new ProductMinimized();
        final int yyBeginOffset = petriReader.getOffset();
        int yyLengthOfBitVector = 1;
        while ((petriReader.readByte() & 0x80) != 0) {
            yyLengthOfBitVector++;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {
            org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.skip(petriReader);
        }
        petriReader.skipBytes(8 + 8);
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 8) != 0) {
            final int deserialized = petriReader.readInt();
            yyResultValue.setAmount(deserialized);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}