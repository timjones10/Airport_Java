import spock.lang.Specification

class AirportSpec extends Specification {
    def "An airport can receive a plane" () {
        given: "When an instance of an Airport is created"
        def airport = new Airport();
        def plane = Mock(Plane);

        when: "An airport can receive a plane"
        airport.land(plane)

        then: "The plane is added to the Planes list"
        airport.GetNumberOfPlanes() == 1
    }

}
