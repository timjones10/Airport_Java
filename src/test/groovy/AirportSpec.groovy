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

}
