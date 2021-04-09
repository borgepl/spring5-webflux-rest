package guru.springframework.spring5webfluxrest.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category {

    @Id
    private String id;
    private String description;

    public Category(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Category() {
    }

    public static CategoryBuilder builder() {
        return new CategoryBuilder();
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Category)) return false;
        final Category other = (Category) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Category;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    public String toString() {
        return "Category(id=" + this.getId() + ", description=" + this.getDescription() + ")";
    }

    public static class CategoryBuilder {
        private String id;
        private String description;

        CategoryBuilder() {
        }

        public CategoryBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Category build() {
            return new Category(id, description);
        }

        public String toString() {
            return "Category.CategoryBuilder(id=" + this.id + ", description=" + this.description + ")";
        }
    }
}
