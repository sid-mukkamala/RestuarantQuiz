package ca.ubc.cs.cpsc210.quiz.model;

/**
 * Represents a category of restaurant with name and alias.
 */
public class Category {
    private String name;
    private String alias;


    public Category(String name, String alias) {
        this.alias = alias;
        this.name= name;


    }

    public String getName() {

        return name;

    }

    public String getAlias() {

        return alias;
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Category othercategory = (Category) o;


        return this.name.equals(othercategory.name)
                && this.alias.equals(othercategory.alias);

    }

    @Override
    public int hashCode() {
        int result = 1;
        final int prime=43;
        result = prime*result +((name==null) ? 0: name.hashCode());
        result = prime*result +((alias==null) ? 0: alias.hashCode());


        return result;
    }
    @Override
    public String toString() {

            return name;}

    }







