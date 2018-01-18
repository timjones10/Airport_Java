import spock.lang.Specification

class WeatherSpec extends Specification {

    def "it has a stormy method which returns true if stormy"() {
        when: "A weather object is created"
        Weather weather = Stub(Weather)
        weather.stormy() >>> [true]

        then: "if the weather is stormy it returns true"
        weather.stormy() == true
    }
}
