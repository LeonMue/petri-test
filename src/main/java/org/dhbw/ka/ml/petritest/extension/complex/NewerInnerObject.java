package org.dhbw.ka.ml.petritest.extension.complex;

import java.io.*;

public class NewerInnerObject {
    private int i1;
    private boolean hasI1 = false;
    private long i2;
    private boolean hasI2 = false;
    private float f1;
    private boolean hasF1 = false;
    private double f2;
    private boolean hasF2 = false;
    private boolean b;
    private boolean hasB = false;
    private String s1;
    private String s2;
    private int i3;
    private boolean hasI3 = false;
    private String s3;

    public int getI1() {
        return this.i1;
    }

    public boolean hasI1() {
        return this.hasI1;
    }

    public long getI2() {
        return this.i2;
    }

    public boolean hasI2() {
        return this.hasI2;
    }

    public float getF1() {
        return this.f1;
    }

    public boolean hasF1() {
        return this.hasF1;
    }

    public double getF2() {
        return this.f2;
    }

    public boolean hasF2() {
        return this.hasF2;
    }

    public boolean getB() {
        return this.b;
    }

    public boolean hasB() {
        return this.hasB;
    }

    public String getS1() {
        return this.s1;
    }

    public boolean hasS1() {
        return this.s1 != null;
    }

    public String getS2() {
        return this.s2;
    }

    public boolean hasS2() {
        return this.s2 != null;
    }

    public int getI3() {
        return this.i3;
    }

    public boolean hasI3() {
        return this.hasI3;
    }

    public String getS3() {
        return this.s3;
    }

    public boolean hasS3() {
        return this.s3 != null;
    }

    public void setI1(int value) {
        this.hasI1 = true;
        this.i1 = value;
    }

    public void setI2(long value) {
        this.hasI2 = true;
        this.i2 = value;
    }

    public void setF1(float value) {
        this.hasF1 = true;
        this.f1 = value;
    }

    public void setF2(double value) {
        this.hasF2 = true;
        this.f2 = value;
    }

    public void setB(boolean value) {
        this.hasB = true;
        this.b = value;
    }

    public void setS1(String value) {
        this.s1 = value;
    }

    public void setS2(String value) {
        this.s2 = value;
    }

    public void setI3(int value) {
        this.hasI3 = true;
        this.i3 = value;
    }

    public void setS3(String value) {
        this.s3 = value;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[2];
        ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();
        try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {
            if (this.hasI1()) {
                yyBitVector[0] |= 1;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.serialize(i1, yyDataOutput);
            }
            if (this.hasI2()) {
                yyBitVector[0] |= 2;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.serialize(i2, yyDataOutput);
            }
            if (this.hasF1()) {
                yyBitVector[0] |= 4;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.serialize(f1, yyDataOutput);
            }
            if (this.hasF2()) {
                yyBitVector[0] |= 8;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.serialize(f2, yyDataOutput);
            }
            if (this.hasB()) {
                yyBitVector[0] |= 16;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.serialize(b, yyDataOutput);
            }
            if (this.hasS1()) {
                yyBitVector[0] |= 32;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(s1, yyDataOutput);
            }
            if (this.hasS2()) {
                yyBitVector[0] |= 64;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(s2, yyDataOutput);
            }
            yyBitVector[0] |= 0x80;
            if (this.hasI3()) {
                yyBitVector[1] |= 1;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.serialize(i3, yyDataOutput);
            }
            if (this.hasS3()) {
                yyBitVector[1] |= 2;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(s3, yyDataOutput);
            }
            ByteArrayOutputStream yyResult = new ByteArrayOutputStream();
            yyResult.writeBytes(yyBitVector);
            yySerializedFields.writeTo(yyResult);
            return yyResult.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("This should not happen...", e);
        }
    }

    public static NewerInnerObject deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final NewerInnerObject yyResultValue = new NewerInnerObject();
        try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {
            int yyLengthOfBitVector = 1;
            while ((yyIn.readByte() & 0x80) != 0) {
                yyLengthOfBitVector++;
            }
            if ((serialized[0] & 1) != 0) {
                final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(yyIn);
                yyResultValue.setI1(deserialized);
            }
            if ((serialized[0] & 2) != 0) {
                final long deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.deserialize(yyIn);
                yyResultValue.setI2(deserialized);
            }
            if ((serialized[0] & 4) != 0) {
                final float deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.deserialize(yyIn);
                yyResultValue.setF1(deserialized);
            }
            if ((serialized[0] & 8) != 0) {
                final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(yyIn);
                yyResultValue.setF2(deserialized);
            }
            if ((serialized[0] & 16) != 0) {
                final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(yyIn);
                yyResultValue.setB(deserialized);
            }
            if ((serialized[0] & 32) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setS1(deserialized);
            }
            if ((serialized[0] & 64) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setS2(deserialized);
            }
            if (yyLengthOfBitVector == 1) {
                return yyResultValue;
            }
            if ((serialized[1] & 1) != 0) {
                final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(yyIn);
                yyResultValue.setI3(deserialized);
            }
            if ((serialized[1] & 2) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setS3(deserialized);
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return yyResultValue;
    }

    static NewerInnerObject yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {
        final NewerInnerObject yyResultValue = new NewerInnerObject();
        final int yyBeginOffset = petriReader.getOffset();
        int yyLengthOfBitVector = 1;
        while ((petriReader.readByte() & 0x80) != 0) {
            yyLengthOfBitVector++;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {
            final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(petriReader);
            yyResultValue.setI1(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 2) != 0) {
            final long deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.deserialize(petriReader);
            yyResultValue.setI2(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 4) != 0) {
            final float deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.deserialize(petriReader);
            yyResultValue.setF1(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 8) != 0) {
            final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(petriReader);
            yyResultValue.setF2(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 16) != 0) {
            final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(petriReader);
            yyResultValue.setB(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 32) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setS1(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 64) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setS2(deserialized);
        }
        if (yyLengthOfBitVector == 1) {
            return yyResultValue;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 1) & 1) != 0) {
            final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(petriReader);
            yyResultValue.setI3(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 1) & 2) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setS3(deserialized);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}