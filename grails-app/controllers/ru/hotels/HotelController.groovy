package ru.hotels

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HotelController {

    IHotelService hotelService
    CountryService countryService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def list(String filterByName, Long filterByCountryId) {
        def filterParams = getDefaultFilterParams()

        if (filterByName) {
            filterParams.filterByName = filterByName
        }

        if (filterByCountryId) {
            filterParams.filterByCountryId = filterByCountryId
        }

        if (!params.offset) {
            params.offset = 0
            params.max = 10
        }

        def hotels = hotelService.listByNameAndCountryId(filterParams.filterByName, filterParams.filterByCountryId, params)

        if (hotels.isEmpty()) {
            render view: 'index', model: [
                    filterParams: filterParams,
                    countryList : countryService.list(),
                    message     : message(code: 'hotels.notfound', default: 'not found')
            ]
        } else {
            render view: 'list', model: [
                    filterParams: filterParams,
                    hotelList   : hotels,
                    hotelCount  : hotels.totalCount,
                    message     : message(code: 'hotels.count', default: 'number of hotels found', args: [hotels.totalCount])
            ]
        }
    }

    def index() {
        respond([filterParams: getDefaultFilterParams(), countryList: countryService.list()])
    }

    def show(Long id) {
        respond hotelService.get(id)
    }

    def create() {
        respond new Hotel(params)
    }

    def save(Hotel hotel) {
        if (hotel == null) {
            notFound()
            return
        }

        try {
            hotelService.save(hotel)
        } catch (ValidationException e) {
            respond hotel.errors, view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'hotel.label', default: 'Hotel'), hotel.id])
                redirect hotel
            }
            '*' { respond hotel, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond hotelService.get(id)
    }

    def update(Hotel hotel) {
        if (hotel == null) {
            notFound()
            return
        }

        try {
            hotelService.save(hotel)
        } catch (ValidationException e) {
            respond hotel.errors, view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'hotel.label', default: 'Hotel'), hotel.id])
                redirect hotel
            }
            '*' { respond hotel, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        hotelService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'hotel.label', default: 'Hotel'), id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'hotel.label', default: 'Hotel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    protected static def getDefaultFilterParams() {
        [filterByName: '', filterByCountryId: null as Long]
    }
}
