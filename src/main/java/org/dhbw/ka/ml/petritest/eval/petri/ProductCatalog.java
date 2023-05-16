package org.dhbw.ka.ml.petritest.eval.petri;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

@lombok.EqualsAndHashCode
public class ProductCatalog {
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

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public boolean hasDescription() {
        return this.description != null;
    }

    private List<Category> categories;

    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> value) {
        this.categories = value;
    }

    public boolean hasCategories() {
        return this.categories != null;
    }

    public byte[] serialize() {
        byte[] yyBitVector = new byte[1];
        ByteArrayOutputStream yySerializedFields = new ByteArrayOutputStream();
        try (final DataOutputStream yyDataOutput = new DataOutputStream(yySerializedFields)) {
            if (this.hasName()) {
                yyBitVector[0] |= 1;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(name, yyDataOutput);
            }
            if (this.hasDescription()) {
                yyBitVector[0] |= 2;
                org.dhbw.ka.ml.petrilib.serializing.primitives.PetriString.serialize(description, yyDataOutput);
            }
            if (this.hasCategories()) {
                yyBitVector[0] |= 4;
                yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(categories.size()));
                for (Category yyElement0 : categories) {
                    if (yyElement0 == null) {
                        throw new IllegalArgumentException("Elements of list must be not null");
                    }
                    final byte[] serialized = yyElement0.serialize();
                    yyDataOutput.write(org.dhbw.ka.ml.petrilib.serializing.VarInt.serializeUnsigned(serialized.length));
                    yyDataOutput.write(serialized);
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

    public static ProductCatalog deserialize(byte[] serialized) throws org.dhbw.ka.ml.petrilib.serializing.ParseException {
        final ProductCatalog yyResultValue = new ProductCatalog();
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
                yyResultValue.setDescription(deserialized);
            }
            if ((serialized[0] & 4) != 0) {
                final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                final List<Category> yyDeserializedList = new ArrayList<Category>(yyListLength);
                for (int yyI = 0; yyI < yyListLength; yyI++) {
                    final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(yyIn);
                    final Category deserialized = Category.yyDeserialize(yyIn, serializedLength);
                    yyDeserializedList.add(deserialized);
                }
                yyResultValue.setCategories(yyDeserializedList);
            }
        } catch (IOException e) {
            throw new org.dhbw.ka.ml.petrilib.serializing.ParseException("Unable to parse message because of IOException. Sure your format is correct?", e);
        }
        return yyResultValue;
    }

    static ProductCatalog yyDeserialize(org.dhbw.ka.ml.petrilib.io.PetriReader petriReader, int length) throws IOException {
        final ProductCatalog yyResultValue = new ProductCatalog();
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
            yyResultValue.setDescription(deserialized);
        }
        if ((petriReader.getByteAt(yyBeginOffset + 0) & 4) != 0) {
            final int yyListLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
            final List<Category> yyDeserializedList = new ArrayList<Category>(yyListLength);
            for (int yyI = 0; yyI < yyListLength; yyI++) {
                final int serializedLength = org.dhbw.ka.ml.petrilib.serializing.VarInt.deserializeUnsigned(petriReader);
                final Category deserialized = Category.yyDeserialize(petriReader, serializedLength);
                yyDeserializedList.add(deserialized);
            }
            yyResultValue.setCategories(yyDeserializedList);
        }
        petriReader.skipBytes((yyBeginOffset + length) - petriReader.getOffset());
        return yyResultValue;
    }
}