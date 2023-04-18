package org.dhbw.ka.ml.petritest.sd.primitive;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.*;

@EqualsAndHashCode
@ToString
public class MyTestStruct {
    private String string1;
    private int int1;
    private boolean hasInt1 = false;
    private long long2;
    private boolean hasLong2 = false;
    private float float1;
    private boolean hasFloat1 = false;
    private double double1;
    private boolean hasDouble1 = false;
    private boolean bool1;
    private boolean hasBool1 = false;
    private String s2;
    private String s3;

    public String getString1() {
        return this.string1;
    }

    public boolean hasString1() {
        return this.string1 != null;
    }

    public int getInt1() {
        return this.int1;
    }

    public boolean hasInt1() {
        return this.hasInt1;
    }

    public long getLong2() {
        return this.long2;
    }

    public boolean hasLong2() {
        return this.hasLong2;
    }

    public float getFloat1() {
        return this.float1;
    }

    public boolean hasFloat1() {
        return this.hasFloat1;
    }

    public double getDouble1() {
        return this.double1;
    }

    public boolean hasDouble1() {
        return this.hasDouble1;
    }

    public boolean getBool1() {
        return this.bool1;
    }

    public boolean hasBool1() {
        return this.hasBool1;
    }

    public String getS2() {
        return this.s2;
    }

    public boolean hasS2() {
        return this.s2 != null;
    }

    public String getS3() {
        return this.s3;
    }

    public boolean hasS3() {
        return this.s3 != null;
    }

    public void setString1(String value) {
        this.string1 = value;
    }

    public void setInt1(int value) {
        this.hasInt1 = true;
        this.int1 = value;
    }

    public void setLong2(long value) {
        this.hasLong2 = true;
        this.long2 = value;
    }

    public void setFloat1(float value) {
        this.hasFloat1 = true;
        this.float1 = value;
    }

    public void setDouble1(double value) {
        this.hasDouble1 = true;
        this.double1 = value;
    }

    public void setBool1(boolean value) {
        this.hasBool1 = true;
        this.bool1 = value;
    }

    public void setS2(String value) {
        this.s2 = value;
    }

    public void setS3(String value) {
        this.s3 = value;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[2];
        ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();
        try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {
            if (this.hasString1()) {
                yyBitVector[0] |= 1;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(string1, yyDataOutput);
            }
            if (this.hasInt1()) {
                yyBitVector[0] |= 2;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.serialize(int1, yyDataOutput);
            }
            if (this.hasLong2()) {
                yyBitVector[0] |= 4;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.serialize(long2, yyDataOutput);
            }
            if (this.hasFloat1()) {
                yyBitVector[0] |= 8;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.serialize(float1, yyDataOutput);
            }
            if (this.hasDouble1()) {
                yyBitVector[0] |= 16;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.serialize(double1, yyDataOutput);
            }
            if (this.hasBool1()) {
                yyBitVector[0] |= 32;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.serialize(bool1, yyDataOutput);
            }
            if (this.hasS2()) {
                yyBitVector[0] |= 64;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(s2, yyDataOutput);
            }
            yyBitVector[0] |= 0x80;
            if (this.hasS3()) {
                yyBitVector[1] |= 1;
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

    public static MyTestStruct deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final MyTestStruct yyResultValue = new MyTestStruct();
        try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {
            int yyLengthOfBitVector = 1;
            while ((yyIn.readByte() & 0x80) != 0) {
                yyLengthOfBitVector++;
            }
            if ((serialized[0] & 1) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setString1(deserialized);
            }
            if ((serialized[0] & 2) != 0) {
                final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(yyIn);
                yyResultValue.setInt1(deserialized);
            }
            if ((serialized[0] & 4) != 0) {
                final long deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.deserialize(yyIn);
                yyResultValue.setLong2(deserialized);
            }
            if ((serialized[0] & 8) != 0) {
                final float deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.deserialize(yyIn);
                yyResultValue.setFloat1(deserialized);
            }
            if ((serialized[0] & 16) != 0) {
                final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(yyIn);
                yyResultValue.setDouble1(deserialized);
            }
            if ((serialized[0] & 32) != 0) {
                final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(yyIn);
                yyResultValue.setBool1(deserialized);
            }
            if ((serialized[0] & 64) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setS2(deserialized);
            }
            if (yyLengthOfBitVector == 1) {
                return yyResultValue;
            }
            if ((serialized[1] & 1) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setS3(deserialized);
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return yyResultValue;
    }

    static MyTestStruct yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {
        final MyTestStruct yyResultValue = new MyTestStruct();
        final int yyBeginOffset = petriReader.getOffset();
        int yyLengthOfBitVector = 1;
        while ((petriReader.readByte() & 0x80) != 0) {
            yyLengthOfBitVector++;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setString1(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 2) != 0) {
            final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(petriReader);
            yyResultValue.setInt1(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 4) != 0) {
            final long deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriLong.deserialize(petriReader);
            yyResultValue.setLong2(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 8) != 0) {
            final float deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriFloat.deserialize(petriReader);
            yyResultValue.setFloat1(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 16) != 0) {
            final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(petriReader);
            yyResultValue.setDouble1(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 32) != 0) {
            final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(petriReader);
            yyResultValue.setBool1(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 64) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setS2(deserialized);
        }
        if (yyLengthOfBitVector == 1) {
            return yyResultValue;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 1) & 1) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setS3(deserialized);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}