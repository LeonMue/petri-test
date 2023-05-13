package org.dhbw.ka.ml.petritest.eval.petri;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

@lombok.EqualsAndHashCode
@lombok.ToString
public class Product {
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

    private double price;
    private boolean hasPrice;

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double value) {
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
        try (final org.dhbw.ka.ml.petrilib.io.PetriWriter yyDataOutput = new org.dhbw.ka.ml.petrilib.io.PetriWriter()) {
            if (this.hasBrand()) {
                yyBitVector[0] |= 1;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(brand, yyDataOutput);
            }
            if (this.hasPrice()) {
                yyBitVector[0] |= 2;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.serialize(price, yyDataOutput);
            }
            if (this.hasWeight()) {
                yyBitVector[0] |= 4;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.serialize(weight, yyDataOutput);
            }
            if (this.hasAmount()) {
                yyBitVector[0] |= 8;
                yyDataOutput.writeInt(amount);
            }
            if (this.hasName()) {
                yyBitVector[0] |= 16;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(name, yyDataOutput);
            }
            if (this.hasColors()) {
                yyBitVector[0] |= 32;
                org.dhbw.ka.ml.petrilib.io.PetriWriter yySerializedList0 = new org.dhbw.ka.ml.petrilib.io.PetriWriter();
                for (String yyElement0 : colors) {
                    if (yyElement0 == null) {
                        throw new IllegalArgumentException("Elements of list must be not null");
                    }
                    org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(yyElement0, yySerializedList0);
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

    public static Product deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final Product yyResultValue = new Product();
        try (final org.dhbw.ka.ml.petrilib.io.PetriReader yyIn = new org.dhbw.ka.ml.petrilib.io.PetriReader(serialized)) {
            int yyLengthOfBitVector = 1;
            while ((yyIn.readByte() & 0x80) != 0) {
                yyLengthOfBitVector++;
            }
            if ((serialized[0] & 1) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setBrand(deserialized);
            }
            if ((serialized[0] & 2) != 0) {
                final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(yyIn);
                yyResultValue.setPrice(deserialized);
            }
            if ((serialized[0] & 4) != 0) {
                final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(yyIn);
                yyResultValue.setWeight(deserialized);
            }
            if ((serialized[0] & 8) != 0) {
                final int deserialized = yyIn.readInt();
                yyResultValue.setAmount(deserialized);
            }
            if ((serialized[0] & 16) != 0) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(yyIn);
                yyResultValue.setName(deserialized);
            }
            if ((serialized[0] & 32) != 0) {
                final int yyListLength = yyIn.readInt();
                final List<String> yyDeserializedList = new ArrayList<String>(yyListLength);
                final int beginningOffset = yyIn.getOffset();
                while (yyIn.getOffset() < beginningOffset + yyListLength) {
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
            yyResultValue.setBrand(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 2) != 0) {
            final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(petriReader);
            yyResultValue.setPrice(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 4) != 0) {
            final double deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriDouble.deserialize(petriReader);
            yyResultValue.setWeight(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 8) != 0) {
            final int deserialized = petriReader.readInt();
            yyResultValue.setAmount(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 16) != 0) {
            final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
            yyResultValue.setName(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 32) != 0) {
            final int yyListLength = petriReader.readInt();
            final List<String> yyDeserializedList = new ArrayList<String>(yyListLength);
            final int beginningOffset = petriReader.getOffset();
            while (petriReader.getOffset() < beginningOffset + yyListLength) {
                final String deserialized = org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.deserialize(petriReader);
                yyDeserializedList.add(deserialized);
            }
            yyResultValue.setColors(yyDeserializedList);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}