package ru.hotels

class Country {

    String name
    String capital

    static constraints = {
        name unique: true, maxSize: 255
        capital maxSize: 128
    }
}
