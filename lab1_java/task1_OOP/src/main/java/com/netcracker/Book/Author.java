package com.netcracker.Book;

public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Author[" +
                "name=" + name +
                ", email=" + email +
                ", gender=" + gender +
                ']';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Author author = (Author) obj;
        return email.equals(author.email) &&
                name.equals(author.name) &&
                gender == author.gender;
    }

    @Override
    public int hashCode() {
        int result = 14;
        result += name.hashCode();
        result = 31 * result + ( email.hashCode());
        result = 31 * result + (int) gender;
        return result;
    }
}
