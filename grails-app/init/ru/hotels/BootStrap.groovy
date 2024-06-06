package ru.hotels

class BootStrap {
    CountryService countryService
    IHotelService hotelService

    def init = { servletContext ->
        def russia = countryService.save('Россия', 'Москва')
        def belarus = countryService.save('Беларусь', 'Минск')
        def kazakhstan = countryService.save('Казахстан', 'Астана')
        def tadjikistan = countryService.save('Таджикистан', 'Душанбе')
        def azerbaijan = countryService.save('Азербайджан', 'Баку')
        def kyrgyzstan = countryService.save('Киргизия', 'Бишкек')

        hotelService.save('Славянка', russia, 3 as byte, 'https://slavhotels.ru/')
        hotelService.save('МонАрх', russia, 5 as byte, 'https://monarchhotels.ru/')
        hotelService.save('Pentahotel Москва, Арбат', russia, 4 as byte, 'https://www.pentamoscow.ru/')
        hotelService.save('Измайлово «Бета»', russia, 3 as byte, 'https://www.hotelbeta.ru/')
        hotelService.save('А.Костерев Отель', russia, 2 as byte, 'https://kosterevhotel.ru/')
        hotelService.save('Космос', russia, 3 as byte, 'https://www.hotelcosmos.ru/')
        hotelService.save('Виктория', russia, 1 as byte, 'https://victoria.msk.ru/')
        hotelService.save('Байкал', russia, 2 as byte, 'https://baikalmoscow.ru/')
        hotelService.save('Авиамоторная', russia, 2 as byte)
        hotelService.save('Скайвью Таганка ', russia, 3 as byte)

        hotelService.save('Президент', belarus, 5 as byte, 'https://www.president-hotel.by/')
        hotelService.save('Юбилейный', belarus, 3 as byte, 'https://yhotel.by/')
        hotelService.save('Губернский', belarus, 4 as byte, 'https://gubernski.by/')
        hotelService.save('Планета', belarus, 3 as byte, 'https://hotelplaneta.by/')
        hotelService.save('Виктория', belarus, 4 as byte, 'https://hotel-victoria.by/')
        hotelService.save('IBB', belarus, 3 as byte, 'https://ibb.by/hotel')
        hotelService.save('Спутник', belarus, 3 as byte, 'https://sputnik-hotel.com/')
        hotelService.save('Славянская', belarus, 3 as byte, 'https://slavyanskaya-minsk.by/')
        hotelService.save('Дрозды Клуб', belarus, 3 as byte, 'https://drozdy-club.by/')
        hotelService.save('Минск', belarus, 4 as byte, 'https://hotelminsk.by/')

        hotelService.save('Ibis Astana', kazakhstan, 3 as byte)
        hotelService.save('Абсолют', kazakhstan, 4 as byte, 'https://absolutehotel.kz/')
        hotelService.save('Астана Марриотт', kazakhstan, 5 as byte)
        hotelService.save('Diplomat', kazakhstan, 4 as byte)
        hotelService.save('Султан Бейбарс', kazakhstan, 3 as byte, 'http://sultanbeibarys.com/')
        hotelService.save('Ака', kazakhstan, 3 as byte)
        hotelService.save('Виктория', kazakhstan, 1 as byte)
        hotelService.save('Байтерек', kazakhstan, 3 as byte, 'https://hbp.kz/hotelbp.html')
        hotelService.save('The St. Regis Astana', kazakhstan, 5 as byte, 'https://www.marriott.com/en-us/hotels/tsexr-the-st-regis-astana')
        hotelService.save('Beijing Palace Soluxe Hotel Astana', kazakhstan, 5 as byte, 'https://soluxeastana.kz/')

        hotelService.save('Rohat Hotel', tadjikistan, 4 as byte)
        hotelService.save('Юбилейный', tadjikistan, 1 as byte)
        hotelService.save('Ватан', tadjikistan, 4 as byte, 'http://hotelvatan.ru/')

        hotelService.save('Байхан', kyrgyzstan, 3 as byte)
        hotelService.save('Сити Бишкек', kyrgyzstan, 4 as byte, 'https://www.cityhotel.kg/ru/')
    }
    def destroy = {
    }
}
