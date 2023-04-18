package org.dhbw.ka.ml.petritest.extension.primitive;

import java.io.*;

public class NewerExtension {
    private long integer64;
    private boolean hasInteger64 = false;
    private boolean isNewer;
    private boolean hasIsNewer = false;
    private String description;
    private int i2;
    private boolean hasI2 = false;
    private float f1;
    private boolean hasF1 = false;
    private double f2;
    private boolean hasF2 = false;
    private boolean b1;
    private boolean hasB1 = false;
    private String myString;

    public long getInteger64() {
        return this.integer64;
    }

    public boolean hasInteger64() {
        return this.hasInteger64;
    }

    public boolean getIsNewer() {
        return this.isNewer;
    }

    public boolean hasIsNewer() {
        return this.hasIsNewer;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean hasDescription() {
        return this.description != null;
    }

    public int getI2() {
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

    public boolean getB1() {
        return this.b1;
    }

    public boolean hasB1() {
        return this.hasB1;
    }

    public String getMyString() {
        return this.myString;
    }

    public boolean hasMyString() {
        return this.myString != null;
    }

    public void setInteger64(long value) {
        this.hasInteger64 = true;
        this.integer64 = value;
    }

    public void setIsNewer(boolean value) {
        this.hasIsNewer = true;
        this.isNewer = value;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public void setI2(int value) {
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

    public void setB1(boolean value) {
        this.hasB1 = true;
        this.b1 = value;
    }

    public void setMyString(String value) {
        this.myString = value;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[2];
        ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();
        try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {
            if (this.hasInteger64()) {
                yyBitVector[0] |= 1;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.serialize(integer64, yyDataOutput);
            }
            if (this.hasIsNewer()) {
                yyBitVector[0] |= 2;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.serialize(isNewer, yyDataOutput);
            }
            if (this.hasDescription()) {
                yyBitVector[0] |= 4;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(description, yyDataOutput);
            }
            if (this.hasI2()) {
                yyBitVector[0] |= 8;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.serialize(i2, yyDataOutput);
            }
            if (this.hasF1()) {
                yyBitVector[0] |= 16;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.serialize(f1, yyDataOutput);
            }
            if (this.hasF2()) {
                yyBitVector[0] |= 32;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.serialize(f2, yyDataOutput);
            }
            if (this.hasB1()) {
                yyBitVector[0] |= 64;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.serialize(b1, yyDataOutput);
            }
            yyBitVector[0] |= 0x80;
            if (this.hasMyString()) {
                yyBitVector[1] |= 1;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(myString, yyDataOutput);
            }
            ByteArrayOutputStream yyResult = new ByteArrayOutputStream();
            yyResult.writeBytes(yyBitVector);
            yySerializedFields.writeTo(yyResult);
            return yyResult.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("This should not happen...", e);
        }
    }

    public static NewerExtension deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final NewerExtension yyResultValue = new NewerExtension();
        try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {
            int yyLengthOfBitVector = 1;
            while ((yyIn.readByte() & 0x80) != 0) {
                yyLengthOfBitVector++;
            }
            if ((serialized[0] & 1) != 0) {
                final long deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.deserialize(yyIn);
                yyResultValue.setInteger64(deserialized);
            }
            if ((serialized[0] & 2) != 0) {
                final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(yyIn);
                yyResultValue.setIsNewer(deserialized);
            }
            if ((serialized[0] & 4) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setDescription(deserialized);
            }
            if ((serialized[0] & 8) != 0) {
                final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(yyIn);
                yyResultValue.setI2(deserialized);
            }
            if ((serialized[0] & 16) != 0) {
                final float deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.deserialize(yyIn);
                yyResultValue.setF1(deserialized);
            }
            if ((serialized[0] & 32) != 0) {
                final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(yyIn);
                yyResultValue.setF2(deserialized);
            }
            if ((serialized[0] & 64) != 0) {
                final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(yyIn);
                yyResultValue.setB1(deserialized);
            }
            if (yyLengthOfBitVector == 1) {
                return yyResultValue;
            }
            if ((serialized[1] & 1) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setMyString(deserialized);
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return yyResultValue;
    }

    static NewerExtension yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {
        final NewerExtension yyResultValue = new NewerExtension();
        final int yyBeginOffset = petriReader.getOffset();
        int yyLengthOfBitVector = 1;
        while ((petriReader.readByte() & 0x80) != 0) {
            yyLengthOfBitVector++;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {
            final long deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.deserialize(petriReader);
            yyResultValue.setInteger64(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 2) != 0) {
            final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(petriReader);
            yyResultValue.setIsNewer(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 4) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setDescription(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 8) != 0) {
            final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(petriReader);
            yyResultValue.setI2(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 16) != 0) {
            final float deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.deserialize(petriReader);
            yyResultValue.setF1(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 32) != 0) {
            final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(petriReader);
            yyResultValue.setF2(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 64) != 0) {
            final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(petriReader);
            yyResultValue.setB1(deserialized);
        }
        if (yyLengthOfBitVector == 1) {
            return yyResultValue;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 1) & 1) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setMyString(deserialized);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}