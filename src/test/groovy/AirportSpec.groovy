import spock.lang.Specification

class AirportSpec extends Specification {
    def "An airport can receive a plane" () {
        given: "When an instance of an Airport is created"
        def airport = new Airport()
        def plane = Mock(Plane)

        when: "An airport can receive a plane"
        airport.land(plane)

        then: "The plane is added to the Planes list"
        airport.GetNumberOfPlanes() == 1
    }

    def "An airport cannot receive a plane if at capacity"() {
        given: "When an instance of an Airport is created"
        def airport = new Airport(1)
        def plane = Mock(Plane)
        def plane2 = Mock(Plane)

        when: "An airport with capacity of 1 has a plane land"
        airport.land(plane)

        then: "A plane cannot land"
        !airport.land(plane2)
    }

}
