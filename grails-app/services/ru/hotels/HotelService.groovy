package ru.hotels

import grails.gorm.services.Service

@Service(Hotel)
abstract class HotelService implements IHotelService {
    @Override
    List<Hotel> listByNameAndCountryId(String name, Long countryId, Map args) {
        Hotel.createCriteria().list(args) {
            if (name) {
                ilike 'name', "%${name}%"
            }
            if (countryId) {
                eq 'country.id', countryId
            }
            order 'starRating', 'desc'
            order 'name', 'asc'
        } as List<Hotel>
    }
}
