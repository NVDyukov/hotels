package ru.hotels

class Hotel {

    String name
    int starRating
    String webSite

    static belongsTo = [country: Country]

    static constraints = {
        name unique: 'country', maxSize: 255
        starRating inList: [1, 2, 3, 4, 5]
        webSite nullable: true, url: true
    }

    String getNameAndWebSite() {
        return name + '///n' + webSite
    }
}
