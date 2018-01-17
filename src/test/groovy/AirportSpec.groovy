import spock.lang.Specification

class AirportSpec extends Specification {

    Airport airport
    Plane plane
    Plane plane2

    def setup(){
        airport = new Airport()
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

        given: "An airport with capacity of 1"
        def airport1 = new Airport(1)

        when: "An airport with capacity of 1 has a plane land"
        airport1.land(plane)

        then: "A plane cannot land"
        !airport1.land(plane2)
    }

}
