package org.dhbw.ka.ml.petritest.eval.petri;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

@lombok.EqualsAndHashCode
public class Product {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public boolean hasName() {
        return this.name != null;
    }

    private String brand;

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String value) {
        this.brand = value;
    }

    public boolean hasBrand() {
        return this.brand != null;
    }

    private int price;
    private boolean hasPrice;

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int value) {
        this.hasPrice = true;
        this.price = value;
    }

    public boolean hasPrice() {
        return this.hasPrice;
    }

    private double weight;
    private boolean hasWeight;

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double value) {
        this.hasWeight = true;
        this.weight = value;
    }

    public boolean hasWeight() {
        return this.hasWeight;
    }

    private boolean available;
    private boolean hasAvailable;

    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean value) {
        this.hasAvailable = true;
        this.available = value;
    }

    public boolean hasAvailable() {
        return this.hasAvailable;
    }

    private List<String> colors;

    public List<String> getColors() {
        return this.colors;
    }

    public void setColors(List<String> value) {
        this.colors = value;
    }

    public boolean hasColors() {
        return this.colors != null;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[1];
        ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();
        try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {
            if (this.hasName()) {
                yyBitVector[0] |= 1;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(name, yyDataOutput);
            }
            if (this.hasBrand()) {
                yyBitVector[0] |= 2;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(brand, yyDataOutput);
            }
            if (this.hasPrice()) {
                yyBitVector[0] |= 4;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.serialize(price, yyDataOutput);
            }
            if (this.hasWeight()) {
                yyBitVector[0] |= 8;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.serialize(weight, yyDataOutput);
            }
            if (this.hasAvailable()) {
                yyBitVector[0] |= 16;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.serialize(available, yyDataOutput);
            }
            if (this.hasColors()) {
                yyBitVector[0] |= 32;
                yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(colors.size()));
                for (String yyElement0 : colors) {
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

    public static Product deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final Product yyResultValue = new Product();
        try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {
            int yyLengthOfBitVector = 1;
            while ((yyIn.readByte() & 0x80) != 0) {
                yyLengthOfBitVector++;
            }
            if ((serialized[0] & 1) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setName(deserialized);
            }
            if ((serialized[0] & 2) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setBrand(deserialized);
            }
            if ((serialized[0] & 4) != 0) {
                final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(yyIn);
                yyResultValue.setPrice(deserialized);
            }
            if ((serialized[0] & 8) != 0) {
                final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(yyIn);
                yyResultValue.setWeight(deserialized);
            }
            if ((serialized[0] & 16) != 0) {
                final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(yyIn);
                yyResultValue.setAvailable(deserialized);
            }
            if ((serialized[0] & 32) != 0) {
                final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                final List<String> yyDeserializedList = new ArrayList<String>(yyListLength);
                for (int yyI = 0; yyI < yyListLength; yyI++) {
                    final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                    yyDeserializedList.add(deserialized);
                }
                yyResultValue.setColors(yyDeserializedList);
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return yyResultValue;
    }

    static Product yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {
        final Product yyResultValue = new Product();
        final int yyBeginOffset = petriReader.getOffset();
        int yyLengthOfBitVector = 1;
        while ((petriReader.readByte() & 0x80) != 0) {
            yyLengthOfBitVector++;
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 1) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setName(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 2) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setBrand(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 4) != 0) {
            final int deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriInt.deserialize(petriReader);
            yyResultValue.setPrice(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 8) != 0) {
            final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(petriReader);
            yyResultValue.setWeight(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 16) != 0) {
            final boolean deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriBool.deserialize(petriReader);
            yyResultValue.setAvailable(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 32) != 0) {
            final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
            final List<String> yyDeserializedList = new ArrayList<String>(yyListLength);
            for (int yyI = 0; yyI < yyListLength; yyI++) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
                yyDeserializedList.add(deserialized);
            }
            yyResultValue.setColors(yyDeserializedList);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}