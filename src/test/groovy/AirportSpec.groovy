import spock.lang.Specification

class AirportSpec extends Specification {

    Airport airport
    Plane plane
    Plane plane2
    Weather weather

    def setup(){
        weather = Stub(Weather)
        weather.stormy() >>> [false]
        airport = new Airport(1, weather)
        plane = Mock(Plane)
        plane2 = Mock(Plane)
    }

    def "An airport can receive a plane" () {

        when: "An airport can receive a plane"
        airport.land(plane)

        then: "The plane is added to the Planes list"
        airport.GetNumberOfPlanes() == 1
    }

    def "An airport cannot receive a plane if at capacity"() {

        when: "An airport with capacity of 1 has a plane land"
        airport.land(plane)

        then: "A plane cannot land"
        !airport.land(plane2)
    }

    def "An airport can allow a plane to takeoff"() {
        given: "A plane is in the Airport"
        Plane landedPlane = Stub(Plane)
        landedPlane.isLanded() >>> [true]
        airport.land(landedPlane)

        when: "That plane can take off"
        airport.takeOff(plane)

        then: airport.GetNumberOfPlanes() == 0
    }

    def "An airport does not allow a plane to takeoff if it is not at airport" () {
        expect: !airport.takeOff(plane)
    }

    def "A plane cannot land if it is 'landed'" (){
        given: "A plane is landed"
        Plane landedPlane = Stub(Plane)
        landedPlane.isLanded() >>> [true]

        when: "The airport tries to land it"
        airport.land(landedPlane)

        then: "The plane is not allowed to land"
        airport.GetNumberOfPlanes() == 0
    }

    def "A plane cannot land if the weather is stormy"(){
        given: "A plane is in the air"
        Plane airPlane = Stub(Plane)
        airPlane.isLanded() >>> [false]

        when: "Weather is stormy"
        Weather weather = Stub(Weather)
        weather.stormy() >>> [true]
        airport = new Airport(1, weather)

        then: "The plane cannot land"
        !airport.land(airPlane)

    }

    def "A plane cannot take off if the weather" () {
        given: "A plane is on the ground at the airport"
        Plane landedPlane = Stub(Plane)
        airport.land(landedPlane)
        landedPlane.isLanded() >>> [true]

        when: "The weather is stormy"
        Weather weather = Stub(Weather)
        weather.stormy() >>> [true]
        airport = new Airport(1, weather)

        then: "The plane cannot takeoff"
        !airport.takeOff(landedPlane)

    }
}
