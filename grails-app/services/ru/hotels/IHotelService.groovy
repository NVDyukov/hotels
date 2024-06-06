package ru.hotels

interface IHotelService {

    Hotel get(Serializable id)

    List<Hotel> list(Map args)

    Long count()

    void delete(Serializable id)

    Hotel save(Hotel hotel)

    Hotel save(String name, Country country, int starRating)

    Hotel save(String name, Country country, int starRating, String webSite)

    List<Hotel> listByNameAndCountryId(String name, Long countryId, Map args)
}

