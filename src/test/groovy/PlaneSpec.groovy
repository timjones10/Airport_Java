import spock.lang.Specification;

class PlaneSpec extends Specification {

    def "A plane states whether it is landed"(){
        given: "An airport is created"
        Airport airport = Stub (Airport)
        airport.land() >>> [true]
        Plane plane = new Plane()

        when: "An airport receives a plane"
        airport.land(plane)

        then: "A plane states that it is landed"
        plane.isLanded()
    }
}