package groovy.com.accion.labs.test1

import com.accion.labs.test1.IntRandomGenerator
import spock.lang.Specification

import java.util.stream.Collectors

/**
 * Created by imtiyaz on 7/5/17.
 */
class RandomIntegerSpec extends Specification {
    def random = new IntRandomGenerator(1000, 1, 1000)

     def "Generate 1000 random numbers"() {
        when: "Random Numbers Generated"
            random.generateInts()
        then:
            random.getRandNumbers().size() == 1000
    }

    def "Find dups and print random numbers" () {
        given:
            random.generateInts();
        when:
            random.isDupsExist();
        then:
            random.findAndPrintDups() > 0
    }

}

