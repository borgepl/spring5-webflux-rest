package guru.springframework.spring5webfluxrest.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Vendor {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    public Vendor(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Vendor() {
    }

    public static VendorBuilder builder() {
        return new VendorBuilder();
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Vendor;
    }

    public static class VendorBuilder {
        private String id;
        private String firstName;
        private String lastName;

        VendorBuilder() {
        }

        public VendorBuilder id(String id) {
            this.id = id;
            return this;
        }

        public VendorBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public VendorBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Vendor build() {
            return new Vendor(id, firstName, lastName);
        }

        public String toString() {
            return "Vendor.VendorBuilder(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ")";
        }
    }
}
